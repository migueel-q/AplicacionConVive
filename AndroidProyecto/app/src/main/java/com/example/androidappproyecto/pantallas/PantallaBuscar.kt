package com.example.androidappproyecto.pantallas

import android.Manifest
import android.content.Context
import android.graphics.Bitmap.createScaledBitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Geocoder
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.androidappproyecto.R
import com.example.androidappproyecto.data.data.modelos.Piso
import com.example.androidappproyecto.data.data.viewmodels.PisoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import java.util.Locale

@Composable
fun PantallaBuscar(pisoViewModel: PisoViewModel) {
    val context = LocalContext.current

    var puntosPisos by remember { mutableStateOf<List<Pair<String, GeoPoint>>>(emptyList()) }

    val pisos by pisoViewModel.pisos.collectAsState()

    LaunchedEffect(pisos) {
        if (pisos.isEmpty()) return@LaunchedEffect

        val geocoder = Geocoder(context, Locale.getDefault())
        val listaTemporal = mutableListOf<Pair<String, GeoPoint>>()

        withContext(Dispatchers.IO) {
            pisos.forEach { piso ->
                val dir = piso.direccion
                if (dir != null) {
                    val direccionCompleta = "${dir.calle}, ${dir.ciudad}, ${dir.provincia}"
                    try {
                        val resultados = geocoder.getFromLocationName(direccionCompleta, 1)
                        if (!resultados.isNullOrEmpty()) {
                            val location = resultados[0]
                            val punto = GeoPoint(location.latitude, location.longitude)
                            listaTemporal.add("${piso.direccion.calle},${piso.direccion.ciudad} \nPrecio: ${piso.precio}€/mes" to punto)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            withContext(Dispatchers.Main) {
                puntosPisos = listaTemporal
            }
        }
    }

    LaunchedEffect(Unit) {
        Configuration.getInstance().load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
    }

    var hasLocationPermission by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions -> hasLocationPermission = permissions.values.all { it } }

    LaunchedEffect(Unit) {
        launcher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
    }

    AndroidView(
        factory = { ctx ->
            MapView(ctx).apply {
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)
                controller.setZoom(15.0)

                val locationProvider = GpsMyLocationProvider(ctx)
                val locationOverlay = MyLocationNewOverlay(locationProvider, this)

                locationOverlay.enableMyLocation()
                locationOverlay.enableFollowLocation()

                locationOverlay.runOnFirstFix {
                    post {
                        controller.animateTo(locationOverlay.myLocation)
                        controller.setCenter(locationOverlay.myLocation)
                    }
                }

                overlays.add(locationOverlay)
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = { mapView ->
            // Buscamos si ya existe el overlay de ubicación para no borrarlo
            val locationOverlay = mapView.overlays.firstOrNull { it is MyLocationNewOverlay }

            mapView.overlays.clear()

            // Volvemos a añadir la ubicación si existía
            locationOverlay?.let { mapView.overlays.add(it) }

            // Añadimos los marcadores de los pisos
            puntosPisos.forEach { (texto, punto) ->
                val marker = Marker(mapView)
                marker.position = punto
                marker.title = texto
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                val originalDrawable = ContextCompat.getDrawable(context, R.drawable.img)
                if (originalDrawable != null) {
                    val bitmap = (originalDrawable as BitmapDrawable).bitmap
                    val scaledBitmap = createScaledBitmap(bitmap, 100, 100, true)
                    marker.icon = BitmapDrawable(context.resources, scaledBitmap)
                }
                mapView.overlays.add(marker)
            }
            mapView.invalidate()
        }
    )
}
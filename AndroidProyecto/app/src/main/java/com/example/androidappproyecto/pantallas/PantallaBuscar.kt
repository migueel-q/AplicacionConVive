package com.example.androidappproyecto.pantallas

import android.Manifest
import android.content.Context
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
import com.example.androidappproyecto.data.data.modelos.Piso // Asegúrate de importar tu clase Piso real
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
fun PantallaBuscar() {
    val context = LocalContext.current

    // 1. Estado para almacenar los puntos geolocalizados
    // Usamos un mapa para asociar el Piso con su GeoPoint una vez calculado
    var puntosPisos by remember { mutableStateOf<List<Pair<String, GeoPoint>>>(emptyList()) }

    // Simulación de tu lista de la DB (Esto vendría de tu ViewModel)
    val listaPisosFromDb = remember { mutableStateListOf<Piso>() }

    // 2. Efecto para convertir direcciones a Coordenadas
    LaunchedEffect(listaPisosFromDb) {
        val geocoder = Geocoder(context, Locale.getDefault())
        val listaTemporal = mutableListOf<Pair<String, GeoPoint>>()

        withContext(Dispatchers.IO) {
            listaPisosFromDb.forEach { piso ->
                val direccionCompleta = "${piso.direccion?.calle}, ${piso.direccion?.ciudad}, ${piso.direccion?.provincia}"
                try {
                    // Obtener coordenadas de la dirección
                    val resultados = geocoder.getFromLocationName(direccionCompleta, 1)
                    if (!resultados.isNullOrEmpty()) {
                        val location = resultados[0]
                        listaTemporal.add(piso.titulo to GeoPoint(location.latitude, location.longitude))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            withContext(Dispatchers.Main) {
                puntosPisos = listaTemporal
            }
        }
    }

    // Configuración inicial OSMDroid
    LaunchedEffect(Unit) {
        Configuration.getInstance().load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
    }

    // Permisos (igual que antes)
    var hasLocationPermission by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions -> hasLocationPermission = permissions.values.all { it } }

    LaunchedEffect(Unit) {
        launcher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
    }

    // 3. El Mapa
    AndroidView(
        factory = { ctx ->
            MapView(ctx).apply {
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)
                controller.setZoom(15.0) // Un zoom más cercano para ver calles

                // Capa de ubicación
                val locationProvider = GpsMyLocationProvider(ctx)
                val locationOverlay = MyLocationNewOverlay(locationProvider, this)

                // ESTA ES LA CLAVE:
                locationOverlay.enableMyLocation()
                locationOverlay.enableFollowLocation() // Intenta seguir al usuario automáticamente

                // Centrar el mapa la primera vez que se obtenga la ubicación
                locationOverlay.runOnFirstFix {
                    // Usamos post para asegurar que se ejecuta en el hilo de la UI
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
            // Limpiar marcadores antiguos (excepto la capa de mi ubicación)
            val locationOverlay = mapView.overlays.firstOrNull { it is MyLocationNewOverlay }
            mapView.overlays.clear()
            locationOverlay?.let { mapView.overlays.add(it) }

            // Añadir los nuevos marcadores calculados
            puntosPisos.forEach { (titulo, punto) ->
                val marker = Marker(mapView)
                marker.position = punto
                marker.title = titulo
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                mapView.overlays.add(marker)
            }
            mapView.invalidate()
        }
    )
}
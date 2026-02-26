package com.example.androidappproyecto.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidappproyecto.data.data.modelos.Direccion
import com.example.androidappproyecto.data.data.modelos.Piso

import com.example.androidappproyecto.navegacion.PisoSeleccionado
import com.example.androidappproyecto.navegacion.Rutas

@Composable
fun PantallaMisPisos(navController: NavHostController) {

    val pisosPrueba = listOf(
        Piso(
            direccion = Direccion(
                calle = "Calle Consolación",
                ciudad = "Torrelavega",
                provincia = "Cantabria"
            ),
            descripcion = "Luminoso, 3 habitaciones, cerca de todo.",
            url_imagen = "https://picsum.photos/600/400?random=1",
            disponible = true,
            propietario = null,
            precio = 350.00,
            id = 1
        ),
        Piso(
            direccion = Direccion(
                calle = "Calle Burgos",
                ciudad = "Santander",
                provincia = "Cantabria"
            ),
            descripcion = "Vistas al mar, ideal para teletrabajo.",
            propietario = null,
            precio = 420.00,
            url_imagen = "https://picsum.photos/600/400?random=2",
            id = 2
        )
    )

    if (pisosPrueba.isEmpty()) {
        EstadoSinPisos()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(pisosPrueba) { piso ->
                TarjetaPiso(piso) {
                    PisoSeleccionado.piso = piso
                    navController.navigate(Rutas.DetallePiso.name)
                }
            }
        }
    }
}

@Composable
private fun EstadoSinPisos() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No tienes ningún piso",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun TarjetaPiso(piso: Piso, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = piso.precio.toString(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )

            // Arreglo para el objeto Direccion
            piso.direccion?.let { dir ->
                Text(
                    text = "${dir.calle}, ${dir.ciudad}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
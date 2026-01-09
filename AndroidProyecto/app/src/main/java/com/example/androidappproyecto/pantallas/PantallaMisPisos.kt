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
import com.example.androidappproyecto.data.pisos
import com.example.androidappproyecto.modelos.Piso

import com.example.androidappproyecto.navegacion.PisoSeleccionado

@Composable
fun PantallaMisPisos(navController: NavHostController) {

    val pisosPrueba = listOf(
        Piso(
            titulo = "Piso Centro",
            direccion = "C/ Mayor 12, Torrelavega",
            descripcion = "Luminoso, 3 habitaciones, cerca de todo.",
            url_imagen = "https://picsum.photos/600/400?random=1",
            disponible = true,
            propietario = null,
            precio = 350.00,
            inquilinos = null,
            ofertas = null,
            gastos = null,
            contratos = null,
            id = 1
        ),
        Piso(
            titulo = "Piso Playa",
            direccion = "Av. del Mar 5, Suances",
            descripcion = "Vistas al mar, ideal para teletrabajo.",
            propietario = null,
            precio = 420.00,
            url_imagen = "https://picsum.photos/600/400?random=2",
            inquilinos = null,
            ofertas = null,
            gastos = null,
            contratos = null,
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
        Column {
            GlideImage(
                model = piso.url_imagen,
                contentDescription = "Foto del piso",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(piso.titulo, fontWeight = FontWeight.Bold)
                piso.direccion?.let { Text(it) }
            }
        }
    }
}
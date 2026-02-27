package com.example.androidappproyecto.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidappproyecto.data.data.modelos.Direccion
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Piso
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.viewmodels.PisoViewModel

import com.example.androidappproyecto.navegacion.PisoSeleccionado
import com.example.androidappproyecto.navegacion.Rutas

@Composable
fun PantallaMisPisos(
    navController: NavHostController,
    pisoViewModel: PisoViewModel,
    inquilino: Inquilino?,
    propietario: Propietario?
) {
    // Cargar pisos al entrar a la pantalla
    LaunchedEffect(Unit) {
        pisoViewModel.refrescarPisos()
    }

    val listaDePisos by pisoViewModel.pisos.collectAsStateWithLifecycle()
    val estado = pisoViewModel.estado

    Column(modifier = Modifier.fillMaxSize()) {

        when (estado) {
            PisoViewModel.HomeState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is PisoViewModel.HomeState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = (estado as PisoViewModel.HomeState.Error).mensaje
                            ?: "Error desconocido"
                    )
                }
            }

            PisoViewModel.HomeState.Success, PisoViewModel.HomeState.Idle -> {
                if (listaDePisos.isEmpty()) {
                    EstadoSinPisos()
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(listaDePisos) { piso ->
                            if (propietario!=null&& piso.propietario?.id ==propietario.id) {
                                TarjetaPiso(piso = piso, onClick = {
                                    PisoSeleccionado.piso = piso
                                    navController.navigate(Rutas.DetalleMisPisos.name)
                                })
                            }
                            if (inquilino!=null && inquilino.contrato?.aceptado == true){
                                TarjetaPiso(piso = piso, onClick = {
                                    PisoSeleccionado.piso = piso
                                    navController.navigate(Rutas.DetalleMisPisos.name)
                                })
                            }
                        }
                    }
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
fun TarjetaPiso(piso: Piso, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }, // Aquí se maneja el clic
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            piso.direccion?.let { dir ->
                Text(
                    text = "${dir.calle ?: ""}, ${dir.ciudad ?: ""}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
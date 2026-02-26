package com.example.androidappproyecto.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.androidappproyecto.R
import com.example.androidappproyecto.data.data.modelos.Direccion
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Piso
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.viewmodels.PisoViewModel

@Composable
fun PantallaHome(
    inquilino: Inquilino?,
    propietario: Propietario?,
    pisoViewModel: PisoViewModel
) {
    // Cargar pisos al entrar a la pantalla
    LaunchedEffect(Unit) {
        pisoViewModel.refrescarPisos()
    }

    // Observar la lista de pisos desde el ViewModel
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
                    Text(text = (estado as PisoViewModel.HomeState.Error).mensaje ?: "Error desconocido")
                }
            }

            PisoViewModel.HomeState.Success, PisoViewModel.HomeState.Idle -> {
                if (listaDePisos.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No hay pisos disponibles")
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(listaDePisos) { piso ->
                            PisoCard(piso)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PisoCard(piso: Piso) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            if (!piso.url_imagen.isNullOrEmpty()) {
                GlideImage(
                    model = piso.url_imagen,
                    contentDescription = "Imagen del piso",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.LightGray),
                    contentScale = ContentScale.Crop,
                    loading = placeholder(R.drawable.loading),
                    failure = placeholder(R.drawable.error)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(
                text = "${piso.precio} €/mes",
                fontSize = 16.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${piso.direccion?.calle}, ${piso.direccion?.ciudad}, ${piso.direccion?.provincia}",
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = piso.descripcion,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


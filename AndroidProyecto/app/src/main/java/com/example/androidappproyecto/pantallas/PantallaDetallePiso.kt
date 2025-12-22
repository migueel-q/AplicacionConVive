package com.example.androidappproyecto.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

import com.example.androidappproyecto.navegacion.PisoSeleccionado

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PantallaDetallePiso() {

    val piso = PisoSeleccionado.piso ?: return

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            GlideImage(
                model = piso.urlImagen,
                contentDescription = "Foto piso",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(piso.titulo, fontWeight = FontWeight.Bold)
            Text(piso.direccion)
            Spacer(modifier = Modifier.height(8.dp))
            Text(piso.descripcion)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Usuarios", fontWeight = FontWeight.Bold)
        }

    }
}
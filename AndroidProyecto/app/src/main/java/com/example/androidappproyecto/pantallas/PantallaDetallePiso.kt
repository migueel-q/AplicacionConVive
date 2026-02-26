package com.example.androidappproyecto.pantallas

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario

import com.example.androidappproyecto.navegacion.PisoSeleccionado

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PantallaDetallePiso(
    inqLogueado: Inquilino?,
    propLogueado: Propietario?
) {

    val piso = PisoSeleccionado.piso ?: return
    val contexto = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            GlideImage(
                model = piso.url_imagen,
                contentDescription = "Foto piso",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(piso.titulo, fontWeight = FontWeight.Bold)
            piso.direccion?.let { dir ->
                Text(
                    text = "${dir.calle}, ${dir.ciudad} (${dir.provincia})",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(piso.precio.toString()+ "€/mes", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(piso.descripcion)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Propietario: "+ piso.propietario?.nombre_real)
            Button(
                onClick = {
                    // viewModel.solicitarAlquiler(piso.id, usuarioLogueado.id)
                    Toast.makeText(contexto, "Solicitud de alquiler enviada", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000))
            ) {
                Text("Solicitar Alquiler", color = Color.White)
            }
        }
    }
}
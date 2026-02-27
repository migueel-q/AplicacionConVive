package com.example.androidappproyecto.pantallas

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PantallaDetallePiso(
    inqLogueado: Inquilino?,
    propLogueado: Propietario?
) {

    val piso = PisoSeleccionado.piso ?: return
    val contexto = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            // FOTO HERO
            GlideImage(
                model = piso.url_imagen ?: "",
                contentDescription = "Foto del piso",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))

            // DIRECCIÓN
            Text(
                text = "${piso.direccion?.calle ?: ""}, ${piso.direccion?.ciudad ?: ""} (${piso.direccion?.provincia ?: ""})",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))

            // DESCRIPCIÓN
            Text(
                text = piso.descripcion ?: "Sin descripción disponible",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))

            // PRECIO
            Text(
                text = "€${piso.precio}",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))

            // PROPIETARIO
            Text(
                text = "Propietario: ${piso.propietario?.nombre_real ?: "Desconocido"}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(16.dp))

            // CHIPS
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // Chip disponibilidad
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = if (piso.disponible==true) "Disponible" else "No disponible",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (piso.disponible==true) Color(0xFF4CAF50) else Color.Red
                    )
                )

                // Chip validación
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = if (piso.validado == true) "Validado" else "No validado",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (piso.validado == true) Color(0xFF2196F3) else Color.Gray
                    )
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


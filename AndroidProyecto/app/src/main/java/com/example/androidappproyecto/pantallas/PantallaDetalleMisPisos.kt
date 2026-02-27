package com.example.androidappproyecto.pantallas

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.isEmpty
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.modelos.Tarea
import com.example.androidappproyecto.data.data.viewmodels.ContratoViewModel
import com.example.androidappproyecto.data.data.viewmodels.InquilinoViewModel
import com.example.androidappproyecto.data.data.viewmodels.TareaViewModel
import com.example.androidappproyecto.navegacion.PisoSeleccionado

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PantallaDetalleMisPisos(
    inqLogueado: Inquilino?,
    propLogueado: Propietario?,
    viewModel: ContratoViewModel,
    inqViewModel: InquilinoViewModel,
    tareaViewModel: TareaViewModel
) {
    val piso = PisoSeleccionado.piso ?: return

    var mostrarDialogoTarea by remember { mutableStateOf(false) }
    var textoNuevaTarea by remember { mutableStateOf("") }
    val listaTareas by tareaViewModel.tareas.collectAsState()

    LaunchedEffect(piso.id) {
        tareaViewModel.obtenerTareasPorPiso(piso.id)
    }

    if (mostrarDialogoTarea) {
        AlertDialog(
            onDismissRequest = { mostrarDialogoTarea = false },
            title = { Text("Nueva Tarea") },
            text = {
                TextField(
                    value = textoNuevaTarea,
                    onValueChange = { textoNuevaTarea = it },
                    placeholder = { Text("Descripción de la tarea...") }
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    if (textoNuevaTarea.isNotBlank()) {
                        tareaViewModel.insertarTarea(
                            Tarea(
                                id = 0,
                                inquilino = inqLogueado,
                                piso = piso,
                                descripcion = textoNuevaTarea,
                            )
                        )
                        mostrarDialogoTarea = false
                        textoNuevaTarea = ""
                    }
                }) { Text("Guardar") }
            },
            dismissButton = {
                TextButton(onClick = { mostrarDialogoTarea = false }) { Text("Cancelar") }
            }
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            GlideImage(
                model = piso.url_imagen ?: "",
                contentDescription = "Foto del piso",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))
            piso.direccion?.let { dir ->
                Text(
                    text = "${dir.calle}, ${dir.ciudad} (${dir.provincia})",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("${piso.precio}€/mes", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(piso.descripcion)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Propietario: ${piso.propietario?.nombre_real?.uppercase() ?: ""}")
            Spacer(modifier = Modifier.height(16.dp))

            // Chips de estado
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AssistChip(
                    onClick = { },
                    label = { Text(if (piso.disponible == true) "Disponible" else "No disponible", color = Color.White) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (piso.disponible == true) Color(0xFF4CAF50) else Color.Red
                    )
                )
                if (propLogueado != null) {
                    AssistChip(
                        onClick = { },
                        label = { Text(if (piso.validado == true) "Validado" else "No validado", color = Color.White) },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = if (piso.validado == true) Color(0xFF2196F3) else Color.Gray
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // BOTONES DE ACCIÓN
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
//                Button(
//                    onClick = { /* Lógica Gasto */ },
//                    modifier = Modifier.weight(1f),
//                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
//                    shape = RoundedCornerShape(8.dp)
//                ) {
//                    Text("Añadir Gasto", color = Color.White)
//                }
                if(inqLogueado!=null) {
                    Button(
                        onClick = { mostrarDialogoTarea = true },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Añadir Tarea", color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Tareas del Piso",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

        }
        if (listaTareas.isEmpty()) {
            item {
                Text(
                    text = "No hay tareas pendientes.",
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        } else {
            items(listaTareas) { tarea ->
                CardTarea(
                    nombre = tarea.descripcion ?: "Tarea sin nombre",
                )
            }
        }
    }
}
@Composable
fun CardTarea(nombre: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = nombre,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}


package com.example.androidappproyecto.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.viewmodels.InquilinoPropietarioViewModel
import com.example.androidappproyecto.navegacion.PisoSeleccionado

@Composable
fun PantallaChat(
    viewModel: InquilinoPropietarioViewModel,
    inqLogueado: Inquilino?,
) {
    val listaMensajes by viewModel.mensajes.collectAsState()
    val miId = inqLogueado?.id ?: 0

    var destinoId by remember { mutableIntStateOf(0) }
    var cargandoPropietario by remember { mutableStateOf(true) }

    LaunchedEffect(miId) {
        if (miId != 0) {
            val idDirecto = inqLogueado?.contrato?.piso?.propietario?.id ?: 0

            val idPisoSeleccionado = PisoSeleccionado.piso?.propietario?.id ?: 0

            if (idDirecto != 0) {
                destinoId = idDirecto
                cargandoPropietario = false
            } else if (idPisoSeleccionado != 0) {
                destinoId = idPisoSeleccionado
                cargandoPropietario = false
            } else {
                viewModel.obtenerPropietarioDelInquilino(miId) { idEncontrado ->
                    destinoId = idEncontrado
                    cargandoPropietario = false
                }
            }
        } else {
            cargandoPropietario = false
        }
    }

    LaunchedEffect(miId, destinoId) {
        if (miId != 0 && destinoId != 0) {
            viewModel.cargarChat(miId, destinoId)
        }
    }

    Scaffold(
        bottomBar = {
            if (miId != 0 && destinoId != 0) {
                CajaEnviarMensaje { texto ->
                    viewModel.enviarMensaje(miId, destinoId, texto, true)
                }
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            if (cargandoPropietario) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center as Alignment.Horizontal))
            } else if (destinoId == 0) {
                Text(
                    "No tienes un contrato activo para chatear.",
                    modifier = Modifier.padding(16.dp)
                )
            } else if (listaMensajes.isEmpty()) {
                Text(
                    text = "No hay mensajes. ¡Inicia la conversación!",
                    modifier = Modifier.align(Alignment.Center as Alignment.Horizontal),
                    color = Color.LightGray
                )
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(listaMensajes) { msg ->
                        if (msg.enviadoPorInquilino) {
                            MensajeDerecha(msg.mensaje ?: "")
                        } else {
                            MensajeIzquierda(msg.mensaje ?: "")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MensajeDerecha(texto: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Surface(
            color = Color(0xFFDFCFC8),
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp)
        ) {
            Text(text = texto, modifier = Modifier.padding(12.dp), color = Color.Black)
        }
    }
}

@Composable
fun MensajeIzquierda(texto: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomEnd = 12.dp),
            shadowElevation = 1.dp
        ) {
            Text(text = texto, modifier = Modifier.padding(12.dp), color = Color.Black)
        }
    }
}

@Composable
fun CajaEnviarMensaje(onSend: (String) -> Unit) {
    var texto by remember { mutableStateOf("") }

    Surface(
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = texto,
                onValueChange = { texto = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Mensaje...") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
            IconButton(
                onClick = {
                    if (texto.isNotBlank()) {
                        onSend(texto)
                        texto = ""
                    }
                }
            ) {
                Icon(Icons.Default.Send, contentDescription = "Enviar", tint = Color(0xFF6200EE))
            }
        }
    }
}
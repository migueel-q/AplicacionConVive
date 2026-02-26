package com.example.androidappproyecto.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.modelos.Usuario
import com.example.androidappproyecto.data.data.viewmodels.InquilinoPropietarioViewModel

@Composable
fun PantallaChat(
    viewModel: InquilinoPropietarioViewModel,
    inqId: Int,
    propId: Int,
    usuario: Usuario?
) {
    val mensajes = viewModel.mensajes
    val enviadoPorInquilino = if (usuario is Inquilino) true else false

    LaunchedEffect(inqId, propId) {
        viewModel.cargarChat(inqId, propId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            if (mensajes.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No has iniciado ninguna conversación")
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    reverseLayout = false
                ) {
                    items(mensajes) { msg ->
                        if (msg.inqId == inqId)
                            MensajeDerecha(msg.mensaje.toString())
                        else
                            MensajeIzquierda(msg.mensaje.toString())
                    }
                }
            }
        }

        CajaEnviarMensaje { texto ->
            viewModel.enviarMensaje(inqId, propId, texto, enviadoPorInquilino)
        }
    }
}

@Composable
fun MensajeDerecha(texto: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = texto,
            modifier = Modifier
                .padding(8.dp)
                .background(Color(0xFFDFCFC8), shape = RoundedCornerShape(12.dp))
                .padding(12.dp)
        )
    }
}

@Composable
fun MensajeIzquierda(texto: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = texto,
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(12.dp)
        )
    }
}

@Composable
fun CajaEnviarMensaje(onSend: (String) -> Unit) {
    var texto by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextField(
            value = texto,
            onValueChange = { texto = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Escribe un mensaje") }
        )
        IconButton(onClick = {
            if (texto.isNotBlank()) {
                onSend(texto)
                texto = ""
            }
        }) {
            Icon(Icons.Default.Send, contentDescription = null)
        }
    }
}


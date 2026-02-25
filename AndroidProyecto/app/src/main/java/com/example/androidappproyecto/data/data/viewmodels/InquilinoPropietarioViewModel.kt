package com.example.androidappproyecto.data.data.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.InquilinoPropietario
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.repositorios.InquilinoPropietarioRepositorio
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InquilinoPropietarioViewModel(
    private val repo: InquilinoPropietarioRepositorio
) : ViewModel() {
    var mensajes by mutableStateOf<List<InquilinoPropietario>>(emptyList())
        private set

    private var chatJob: Job? = null

    fun cargarChat(inq: Int, prop: Int) {
        chatJob?.cancel()

        chatJob = viewModelScope.launch {
            try {
                repo.syncChat(inq, prop)
            } catch (e: Exception) {
                Log.e("ChatViewModel", "Error sincronizando: ${e.message}")
            }

            repo.getChatLocal(inq, prop).collect { lista ->
                mensajes = lista
            }
        }
    }
    fun enviarMensaje(inq: Int, prop: Int, texto: String) {
        viewModelScope.launch {
            repo.enviarMensaje(inq, prop, texto)
        }
    }

}

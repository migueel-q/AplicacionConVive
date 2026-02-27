package com.example.androidappproyecto.data.data.viewmodels

import android.util.Log
import androidx.activity.result.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.InquilinoPropietario
import com.example.androidappproyecto.data.data.repositorios.InquilinoPropietarioRepositorio
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InquilinoPropietarioViewModel(
    private val repo: InquilinoPropietarioRepositorio
) : ViewModel() {

    private val _mensajes = MutableStateFlow<List<InquilinoPropietario>>(emptyList())
    val mensajes: StateFlow<List<InquilinoPropietario>> = _mensajes.asStateFlow()

    // Variable para evitar llamadas dobles a la carga
    private var idsCargados: String? = null

    fun cargarChat(inq: Int, prop: Int) {
        val key = "$inq-$prop"
        if (idsCargados == key) return
        idsCargados = key

        viewModelScope.launch {
            repo.getChatLocal(inq, prop).collect { lista ->
                _mensajes.value = lista
            }
        }

        sincronizar(inq, prop)
    }

    fun sincronizar(inq: Int, prop: Int) {
        viewModelScope.launch {
            try {
                repo.syncChat(inq, prop)
            } catch (e: Exception) {
                Log.e("ChatViewModel", "Error sync: ${e.message}")
            }
        }
    }

    fun enviarMensaje(inq: Int, prop: Int, texto: String, enviadoPorInquilino: Boolean) {
        viewModelScope.launch {
            try {
                repo.enviarMensaje(inq, prop, texto, enviadoPorInquilino)
                sincronizar(inq, prop)
            } catch (e: Exception) {
                Log.e("ChatViewModel", "Error envío: ${e.message}")
            }
        }
    }

    fun obtenerPropietarioDelInquilino(inqId: Int, onResultado: (Int) -> Unit) {
        viewModelScope.launch {
            val idEncontrado = repo.buscarPropietarioIdLocal(inqId)
            onResultado(idEncontrado)
        }
    }
}
package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Piso
import com.example.androidappproyecto.data.data.repositorios.PisoRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PisoViewModel(private val repositorio: PisoRepositorio) : ViewModel() {

    // Estado para la lista de pisos (se actualiza automáticamente desde Room)
    val todosLosPisos = repositorio.obtenerTodosLosPisos()

    // Estado para manejar la carga y los mensajes de error
    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun refrescarPisos() {
        viewModelScope.launch {
            _estaCargando.value = true
            _mensajeError.value = null
            try {
                repositorio.syncPisos()
            } catch (e: Exception) {
                _mensajeError.value = "Error al conectar con el servidor"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun insertarPiso(piso: Piso) {
        viewModelScope.launch {
            try {
                _estaCargando.value = true
                repositorio.insertarPiso(piso)
            } catch (e: Exception) {
                _mensajeError.value = e.message
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun actualizarPiso(piso: Piso) {
        viewModelScope.launch {
            try {
                repositorio.actualizarPiso(piso)
            } catch (e: Exception) {
                _mensajeError.value = "No se pudo actualizar: ${e.message}"
            }
        }
    }

    fun eliminarPiso(piso: Piso) {
        viewModelScope.launch {
            try {
                repositorio.eliminarPiso(piso)
            } catch (e: Exception) {
                _mensajeError.value = "No se pudo eliminar: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.repositorios.InquilinoRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InquilinoViewModel(private val repositorio: InquilinoRepositorio) : ViewModel() {

    // Observa la lista de inquilinos desde Room
    val todosLosInquilinos = repositorio.obtenerTodosLosInquilinos()

    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun refrescarInquilinos() {
        viewModelScope.launch {
            _estaCargando.value = true
            _mensajeError.value = null
            try {
                repositorio.refrescarInquilinos()
            } catch (e: Exception) {
                _mensajeError.value = "Error al sincronizar: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun insertarInquilino(inquilino: Inquilino) {
        viewModelScope.launch {
            _estaCargando.value = true
            try {
                repositorio.insertarInquilino(inquilino)
            } catch (e: Exception) {
                _mensajeError.value = e.message
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun actualizarInquilino(inquilino: Inquilino) {
        viewModelScope.launch {
            try {
                repositorio.actualizarInquilino(inquilino)
            } catch (e: Exception) {
                _mensajeError.value = "No se pudo actualizar: ${e.message}"
            }
        }
    }

    fun eliminarInquilino(inquilino: Inquilino) {
        viewModelScope.launch {
            try {
                repositorio.eliminarInquilino(inquilino)
            } catch (e: Exception) {
                _mensajeError.value = "No se pudo eliminar: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Solicitud
import com.example.androidappproyecto.data.data.repositorios.SolicitudRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SolicitudViewModel(private val repositorio: SolicitudRepositorio) :
    ViewModel() {

    // Observa la lista de solicitudes desde la DB local
    val todasLasSolicitudes = repositorio.obtenerTodasLasSolicitudes()

    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun refrescarSolicitudes() {
        viewModelScope.launch {
            _estaCargando.value = true
            _mensajeError.value = null
            try {
                repositorio.refrescarSolicitudes()
            } catch (e: Exception) {
                _mensajeError.value = "Error al sincronizar solicitudes: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun insertarSolicitud(solicitud: Solicitud) {
        viewModelScope.launch {
            _estaCargando.value = true
            try {
                repositorio.insertarSolicitud(solicitud)
            } catch (e: Exception) {
                _mensajeError.value = "Error al crear solicitud: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun actualizarSolicitud(solicitud: Solicitud) {
        viewModelScope.launch {
            try {
                repositorio.actualizarSolicitud(solicitud)
            } catch (e: Exception) {
                _mensajeError.value = "Error al actualizar solicitud: ${e.message}"
            }
        }
    }

    fun eliminarSolicitud(solicitud: Solicitud) {
        viewModelScope.launch {
            try {
                repositorio.eliminarSolicitud(solicitud)
            } catch (e: Exception) {
                _mensajeError.value = "Error al eliminar solicitud: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
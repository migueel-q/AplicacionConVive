package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Oferta
import com.example.androidappproyecto.data.data.repositorios.OfertaRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OfertaViewModel(private val repositorio: OfertaRepositorio) : ViewModel() {

    val todasLasOfertas = repositorio.obtenerTodasLasOfertas()

    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun refrescarOfertas() {
        viewModelScope.launch {
            _estaCargando.value = true
            _mensajeError.value = null
            try {
                repositorio.refrescarOfertas()
            } catch (e: Exception) {
                _mensajeError.value = "Error al sincronizar ofertas: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun insertarOferta(oferta: Oferta) {
        viewModelScope.launch {
            _estaCargando.value = true
            try {
                repositorio.insertarOferta(oferta)
            } catch (e: Exception) {
                _mensajeError.value = "Error al crear oferta: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun actualizarOferta(oferta: Oferta) {
        viewModelScope.launch {
            try {
                repositorio.actualizarOferta(oferta)
            } catch (e: Exception) {
                _mensajeError.value = "Error al actualizar oferta: ${e.message}"
            }
        }
    }

    fun eliminarOferta(oferta: Oferta) {
        viewModelScope.launch {
            try {
                repositorio.eliminarOferta(oferta)
            } catch (e: Exception) {
                _mensajeError.value = "Error al eliminar oferta: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
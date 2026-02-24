package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Contrato
import com.example.androidappproyecto.data.data.repositorios.ContratoRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContratoViewModel(private val repositorio: ContratoRepositorio) : ViewModel() {

    // Observa los contratos desde la DB local en tiempo real
    val todosLosContratos = repositorio.obtenerTodosLosContratos()

    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun refrescarContratos() {
        viewModelScope.launch {
            _estaCargando.value = true
            _mensajeError.value = null
            try {
                repositorio.refrescarContratos()
            } catch (e: Exception) {
                _mensajeError.value = "Error al refrescar contratos: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun insertarContrato(contrato: Contrato) {
        viewModelScope.launch {
            _estaCargando.value = true
            try {
                repositorio.insertarContrato(contrato)
            } catch (e: Exception) {
                _mensajeError.value = "Error al crear contrato: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun actualizarContrato(contrato: Contrato) {
        viewModelScope.launch {
            try {
                repositorio.actualizarContrato(contrato)
            } catch (e: Exception) {
                _mensajeError.value = "Error al actualizar: ${e.message}"
            }
        }
    }

    fun eliminarContrato(contrato: Contrato) {
        viewModelScope.launch {
            try {
                repositorio.eliminarContrato(contrato)
            } catch (e: Exception) {
                _mensajeError.value = "Error al eliminar: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.DTO.PropietarioDTO
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.repositorios.PropietarioRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PropietarioViewModel(private val repositorio: PropietarioRepositorio) : ViewModel() {

    val todosLosPropietarios = repositorio.obtenerTodosLosPropietarios()

    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun refrescarPropietarios() {
        viewModelScope.launch {
            _estaCargando.value = true
            _mensajeError.value = null
            try {
                repositorio.refrescarPropietarios()
            } catch (e: Exception) {
                _mensajeError.value = "Error al sincronizar propietarios: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun insertarPropietario(propietario: Propietario) {
        viewModelScope.launch {
            _estaCargando.value = true
            try {
                repositorio.insertarPropietario(propietario)
            } catch (e: Exception) {
                _mensajeError.value = "Error al crear propietario: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun actualizarPropietario(propietario: Propietario) {
        viewModelScope.launch {
            try {
                repositorio.actualizarPropietario(propietario)
            } catch (e: Exception) {
                _mensajeError.value = "Error al actualizar propietario: ${e.message}"
            }
        }
    }

    fun eliminarPropietario(propietario: Propietario) {
        viewModelScope.launch {
            try {
                repositorio.eliminarPropietario(propietario)
            } catch (e: Exception) {
                _mensajeError.value = "Error al eliminar propietario: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
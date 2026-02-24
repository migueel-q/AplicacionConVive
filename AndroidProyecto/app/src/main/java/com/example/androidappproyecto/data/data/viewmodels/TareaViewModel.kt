package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Tarea
import com.example.androidappproyecto.data.data.repositorios.TareaRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TareaViewModel(private val repositorio: TareaRepositorio) : ViewModel() {

    // Observa la lista de tareas desde Room en tiempo real
    val todasLasTareas = repositorio.obtenerTodasLasTareas()

    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun refrescarTareas() {
        viewModelScope.launch {
            _estaCargando.value = true
            _mensajeError.value = null
            try {
                repositorio.refrescarTareas()
            } catch (e: Exception) {
                _mensajeError.value = "Error al sincronizar tareas: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun insertarTarea(tarea: Tarea) {
        viewModelScope.launch {
            _estaCargando.value = true
            try {
                repositorio.insertarTarea(tarea)
            } catch (e: Exception) {
                _mensajeError.value = "Error al crear tarea: ${e.message}"
            } finally {
                _estaCargando.value = false
            }
        }
    }

    fun actualizarTarea(tarea: Tarea) {
        viewModelScope.launch {
            try {
                repositorio.actualizarTarea(tarea)
            } catch (e: Exception) {
                _mensajeError.value = "Error al actualizar tarea: ${e.message}"
            }
        }
    }

    fun eliminarTarea(tarea: Tarea) {
        viewModelScope.launch {
            try {
                repositorio.eliminarTarea(tarea)
            } catch (e: Exception) {
                _mensajeError.value = "Error al eliminar tarea: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
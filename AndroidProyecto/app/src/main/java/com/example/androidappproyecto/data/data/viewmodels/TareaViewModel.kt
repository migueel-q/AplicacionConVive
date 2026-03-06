package com.example.androidappproyecto.data.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Tarea
import com.example.androidappproyecto.data.data.repositorios.TareaRepositorio
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TareaViewModel(private val repositorio: TareaRepositorio) : ViewModel() {

    private val _tareas = MutableStateFlow<List<Tarea>>(emptyList())
    val tareas: StateFlow<List<Tarea>> = _tareas.asStateFlow()

    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    // 1. Guardamos el Job de la escucha actual para cancelarlo si cambiamos de piso
    private var tareasJob: Job? = null

    fun obtenerTareasPorPiso(pisoId: Int) {
        // Cancelamos la escucha anterior si existe
        tareasJob?.cancel()

        tareasJob = viewModelScope.launch {
            _estaCargando.value = true
            try {
                repositorio.refrescarTareas()

                repositorio.getTareasByPiso(pisoId).collect { lista ->
                    _tareas.value = lista
                    _estaCargando.value = false
                }
            } catch (e: Exception) {
                _mensajeError.value = "Error al cargar tareas: ${e.message}"
                _estaCargando.value = false
            }
        }
    }

    fun insertarTarea(tarea: Tarea) {
        viewModelScope.launch {
            try {
                repositorio.insertarTarea(tarea)
            } catch (e: Exception) {
                _mensajeError.value = "Error al crear tarea: ${e.message}"
            }
        }
    }

    // 3. Corregido: Ahora recibe el nuevo estado booleano
    fun actualizarEstadoTarea(tareaId: Int, nuevoEstado: Boolean) {
        viewModelScope.launch {
            try {
                repositorio.actualizarEstadoTarea(tareaId, nuevoEstado)
            } catch (e: Exception) {
                _mensajeError.value = "Error al actualizar: ${e.message}"
            }
        }
    }

    fun limpiarError() {
        _mensajeError.value = null
    }
}
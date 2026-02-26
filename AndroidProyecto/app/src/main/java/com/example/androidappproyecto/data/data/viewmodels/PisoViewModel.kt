package com.example.androidappproyecto.data.data.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.daos.PisoDao
import com.example.androidappproyecto.data.data.modelos.Direccion
import com.example.androidappproyecto.data.data.modelos.Piso
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.pisos
import com.example.androidappproyecto.data.data.repositorios.PisoRepositorio
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PisoViewModel(
    private val repositorio: PisoRepositorio
) : ViewModel() {


    private val _estaCargando = MutableStateFlow(false)
    val estaCargando: StateFlow<Boolean> = _estaCargando


    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError


    private val _pisos = MutableStateFlow<List<Piso>>(emptyList())
    val pisos: StateFlow<List<Piso>> = _pisos


    var estado by mutableStateOf<HomeState>(HomeState.Idle)
        private set

    fun cargarPisos(userId: Int, rol: String) {
        viewModelScope.launch {
            estado = HomeState.Loading
            try {
                val lista = if (rol == "PROPIETARIO") {
                    repositorio.obtenerPisosPorPropietario(userId)
                } else {
                    repositorio.obtenerTodosLosPisos()
                }

                _pisos.value = lista as List<Piso>
                estado = HomeState.Success

            } catch (e: Exception) {
                estado = HomeState.Error("Error al cargar pisos: ${e.message}")
            }
        }
    }


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

    sealed class HomeState {
        object Idle : HomeState()
        object Loading : HomeState()
        object Success : HomeState()
        data class Error(val mensaje: String) : HomeState()
    }
}
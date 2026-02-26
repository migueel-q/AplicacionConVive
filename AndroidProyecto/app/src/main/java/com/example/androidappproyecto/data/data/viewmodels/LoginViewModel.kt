package com.example.androidappproyecto.data.data.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.repositorios.InquilinoRepositorio
import com.example.androidappproyecto.data.data.repositorios.PropietarioRepositorio
import kotlinx.coroutines.launch
import java.net.ConnectException

class LoginViewModel(
    private val repoProp: PropietarioRepositorio,
    private val repoInq: InquilinoRepositorio
    ) : ViewModel() {

    // Estado observable para la UI
    var estado by mutableStateOf<LoginState>(LoginState.Idle)
        private set

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            estado = LoginState.Error("Por favor, rellena todos los campos")
            return
        }
        viewModelScope.launch {
            estado = LoginState.Loading
            try {
                val respuesta = repoProp.login(email, password)

                if (respuesta != null) {
                    estado = LoginState.Success(
                        userId = respuesta.id,
                        rol = "PROPIETARIO",
                        nombreUsuario = respuesta.nombre_usuario,
                        nombreReal = respuesta.nombre_real,
                        fechaNac = respuesta.fecha_nacimiento.toString(),
                        email = respuesta.email,
                        password = respuesta.password
                    )
                } else {
                    val respuesta = repoInq.login(email, password)

                    if (respuesta != null) {
                        estado = LoginState.Success(
                            userId = respuesta.id,
                            rol = "INQUILINO",
                            nombreUsuario = respuesta.nombre_usuario,
                            nombreReal = respuesta.nombre_real,
                            fechaNac = respuesta.fecha_nacimiento.toString(),
                            email = respuesta.email,
                            password = respuesta.password
                        )
                    } else {
                        estado = LoginState.Error("Fallo al iniciar sesión")
                    }
                }

            } catch (e: ConnectException) {
                estado = LoginState.Error("Error de conexión: No se pudo contactar con la API Java")
            } catch (e: Exception) {
                estado = LoginState.Error("Error inesperado: ${e.localizedMessage}")
            }
        }
    }

    fun registrar(nombreUsuario: String,
                  nombreReal: String,
                  email: String,
                  password: String,
                  fechaNacimiento: String,
                  esPropietario: Boolean) {
        viewModelScope.launch {
            estado = LoginState.Loading
            try {
                if (esPropietario) {
                    val respuesta = repoProp.insertarPropietario(
                        Propietario(0, nombreUsuario, nombreReal, fechaNacimiento, email, password)
                    )
                    estado = LoginState.Success(0, nombreReal, fechaNacimiento, email, password, "PROPIETARIO", nombreUsuario)
                } else {
                    repoInq.insertarInquilino(
                        Inquilino(0, nombreUsuario, nombreReal, fechaNacimiento, email, password)
                    )
                    estado = LoginState.Success(0, nombreReal, fechaNacimiento, email, password, "INQUILINO", nombreUsuario)
                }
            } catch (e: Exception) {
                estado = LoginState.Error("Fallo al registrar: ${e.localizedMessage}")
            }
        }
    }

    fun resetEstado() {
        estado = LoginState.Idle
    }
}

// Estados detallados para la navegación y UI
sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val userId: Int, val nombreReal: String,val fechaNac: String, val email: String, val password: String, val rol: String, val nombreUsuario: String) : LoginState()
    data class Error(val mensaje: String) : LoginState()
}
package com.example.androidappproyecto.data.data.modelos

import java.io.Serializable

open class Usuario(
    open val id: Int = 0,
    open val nombre_usuario: String,
    open val nombre_real: String,
    open val fecha_nacimiento: String? = null,
    open val email: String,
    open val password: String,
) : Serializable


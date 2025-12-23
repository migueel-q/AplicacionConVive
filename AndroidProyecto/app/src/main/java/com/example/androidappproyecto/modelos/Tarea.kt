package com.example.androidappproyecto.modelos

data class Tarea(
    val id: Int,
    val descripcion: String? = null,

    val inquilino: Inquilino? = null
)
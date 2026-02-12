package com.example.androidappproyecto.modelos

data class Solicitud(
    val id: Int,
    val aceptado: Boolean = false,

    val inquilino: Inquilino? = null,
    val oferta: Oferta? = null
)
package com.example.androidappproyecto.data.data.modelos

import java.io.Serializable

data class Direccion(
    val calle: String? = null,
    val ciudad: String? = null,
    val provincia: String? = null
) : Serializable
package com.example.androidappproyecto.modelos

data class Gasto(
    val id: Int = 0,
    val concepto: String? = null,
    val valor: Double = 0.0,

    // Relaciones
    val inquilino: Inquilino? = null,
    val piso: Piso? = null
)
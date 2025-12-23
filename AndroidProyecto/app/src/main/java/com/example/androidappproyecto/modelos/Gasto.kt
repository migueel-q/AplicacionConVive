package com.example.androidappproyecto.modelos

data class Gasto(
    val id: Int,
    val concepto: String? = null,
    val valor: Double,

    val inquilino: Inquilino? = null,
    val piso: Piso? = null
)
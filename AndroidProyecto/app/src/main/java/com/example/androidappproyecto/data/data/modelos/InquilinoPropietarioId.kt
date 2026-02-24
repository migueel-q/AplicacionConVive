package com.example.androidappproyecto.data.data.modelos

import java.time.LocalDateTime

data class InquilinoPropietarioId(
    val inquilino: Int,
    val propietario: Int,
    val fecha_msg: LocalDateTime? = null
)
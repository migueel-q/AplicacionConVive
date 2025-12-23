package com.example.androidappproyecto.modelos

data class Inquilino(

    val uid: String,
    val name: String,
    val email: String,
    val role: String,
    val phone: String,
    val address: String,

    val fecha_alta: String? = null,

    val piso: Piso? = null,
    val contrato: Contrato? = null,

    val tareas: List<Tarea>? = null,
    val ofertas: List<Oferta>? = null,
    val solicitudes: List<Solicitud>? = null,
    val gastos: List<Gasto>? = null,
    val propietarios: List<InquilinoPropietario>? = null
)
package com.example.androidappproyecto.modelos

data class Propietario(
    val uid: String,
    val name: String,
    val email: String,
    val role: String,
    val phone: String,
    val address: String,

    val pisos: List<Piso>? = null,

    val inquilinos: List<InquilinoPropietario>? = null,

    val ofertas: List<Oferta>? = null,
    val contratos: List<Contrato>? = null
)
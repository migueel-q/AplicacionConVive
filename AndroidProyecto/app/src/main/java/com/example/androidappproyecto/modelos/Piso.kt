package com.example.androidappproyecto.modelos

data class Piso(
    val id: Int,
    val titulo : String,
    val direccion: String? = null,
    val descripcion: String,
    val url_imagen: String? = null,
    val disponible: Boolean = false,
    val precio : Double,

    val inquilinos: List<Inquilino>? = null,
    val propietario: Propietario? = null,
    val ofertas: List<Oferta>? = null,
    val gastos: List<Gasto>? = null,
    val contratos: List<Contrato>? = null
)

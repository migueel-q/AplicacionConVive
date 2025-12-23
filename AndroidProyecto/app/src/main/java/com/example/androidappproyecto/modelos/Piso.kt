package com.example.androidappproyecto.modelos

data class Piso(
    val id: Int = 0,
    val direccion: Direccion? = null,
    val descripcion: String? = null,
    val url_imagen: String? = null,
    val disponible: Boolean = false,

    val inquilinos: List<Inquilino>? = null,
    val propietario: Propietario? = null,
    val ofertas: List<Oferta>? = null,
    val gastos: List<Gasto>? = null,
    val contratos: List<Contrato>? = null
)

package com.example.androidappproyecto.modelos

data class Oferta(
    var id: Int,
    var cantidad: Double,
    var descripcion: String? = null,

    var piso: Piso? = null,
    var inquilino: Inquilino? = null,

    var solicitudes: List<Solicitud>? = null

)
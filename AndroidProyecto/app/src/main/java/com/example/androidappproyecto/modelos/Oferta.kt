package com.example.androidappproyecto.modelos

data class Oferta(
    var id: Int = 0,
    var cantidad: Double = 0.0,
    var descripcion: String? = null,

    var piso: Piso? = null,
    var inquilino: Inquilino? = null,

    var solicitudes: List<Solicitud>? = null

)
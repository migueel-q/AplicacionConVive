package com.example.androidappproyecto.modelos

data class Contrato(
    var id: Int,
    var descripcion: String? = null,
    var precio: Double,

    var fecha_inicio: String? = null,
    var fecha_fin: String? = null,

    var inquilinos: List<Inquilino>? = null,
    var propietario: Propietario? = null,
    var piso: Piso? = null
)
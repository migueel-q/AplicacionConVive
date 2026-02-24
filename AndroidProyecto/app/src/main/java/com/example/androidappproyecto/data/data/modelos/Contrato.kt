package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(
    tableName = "contratos",
    foreignKeys = [
        ForeignKey(
            entity = Piso::class,
            parentColumns = ["id_piso"],
            childColumns = ["piso_id_piso"],
            onDelete = ForeignKey.CASCADE // Si borras el piso se borra el contrato
        )
    ]
)
@TypeConverters(Converters::class)
data class Contrato(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_contrato")
    var id: Int = 0,

    @ColumnInfo(name = "descripcion")
    var descripcion: String? = null,

    @ColumnInfo(name = "precio")
    var precio: Double,

    @ColumnInfo(name = "fecha_inicio")
    var fecha_inicio: String? = null,
    @ColumnInfo(name = "fecha_fin")
    var fecha_fin: String? = null,

    @Embedded(prefix = "piso_")
    var piso: Piso? = null
)
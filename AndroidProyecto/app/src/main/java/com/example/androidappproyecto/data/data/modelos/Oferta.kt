package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(
    tableName = "ofertas",
    foreignKeys = [
        ForeignKey(
            entity = Piso::class,
            parentColumns = ["id_piso"],
            childColumns = ["piso_id_piso"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Inquilino::class,
            parentColumns = ["id"],
            childColumns = ["inq_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
@TypeConverters(Converters::class)
data class Oferta(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_oferta")
    var id: Int = 0,
    @ColumnInfo(name = "cantidad")
    var cantidad: Double,
    @ColumnInfo(name = "descripcion")
    var descripcion: String? = null,

    @Embedded(prefix = "piso_")
    var piso: Piso? = null,
    @Embedded(prefix = "inq_")
    var inquilino: Inquilino? = null,

)
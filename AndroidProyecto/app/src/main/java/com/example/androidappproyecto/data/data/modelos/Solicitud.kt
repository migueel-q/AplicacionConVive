package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "solicitudes",
    foreignKeys = [
        ForeignKey(
            entity = Inquilino::class,
            parentColumns = ["id"],
            childColumns = ["inq_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Oferta::class,
            parentColumns = ["id_oferta"],
            childColumns = ["oferta_id_oferta"],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
data class Solicitud(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_solicitud")
    val id: Int = 0,
    @ColumnInfo(name = "aceptado")
    val aceptado: Boolean = false,
    @Embedded(prefix = "inq_")
    val inquilino: Inquilino? = null,
    @Embedded(prefix = "oferta_")
    val oferta: Oferta? = null
)
package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "inquilinos_propietarios",
    foreignKeys = [
        ForeignKey(
            entity = Inquilino::class,
            parentColumns = ["id"],
            childColumns = ["inq_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Propietario::class,
            parentColumns = ["id"],
            childColumns = ["prop_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
data class InquilinoPropietario(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_inquilino_propietario")
    val id: Int = 0,
    @Embedded(prefix = "inq_")
    val inquilino: Inquilino? = null,
    @Embedded(prefix = "prop_")
    val propietario: Propietario? = null,

    @ColumnInfo(name = "fecha_msg")
    val fecha_msg: String? = null,
    @ColumnInfo(name = "mensaje")
    val mensaje: String? = null
)

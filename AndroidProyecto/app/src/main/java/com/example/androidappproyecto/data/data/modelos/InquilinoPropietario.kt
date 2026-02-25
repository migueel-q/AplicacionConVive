package com.example.androidappproyecto.data.data.modelos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "inquilinos_propietarios",
    primaryKeys = ["inq_id", "prop_id", "fecha_msg"],
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
    @ColumnInfo(name = "inq_id")
    val inqId: Int, // ID del inquilino (Parte de la PK)

    @ColumnInfo(name = "prop_id")
    val propId: Int, // ID del propietario (Parte de la PK)

    @ColumnInfo(name = "fecha_msg")
    val fechaMsg: LocalDateTime,
    @ColumnInfo(name = "mensaje")
    val mensaje: String? = null,

    @ColumnInfo(name = "enviado_por_inquilino")
    val enviadoPorInquilino: Boolean
)

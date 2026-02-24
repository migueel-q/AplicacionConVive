package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "gastos",
    foreignKeys = [
        ForeignKey(
            entity = Inquilino::class,
            parentColumns = ["id"],
            childColumns = ["inq_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Piso::class,
            parentColumns = ["id_piso"],
            childColumns = ["piso_id_piso"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Gasto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_gasto")
    val id: Int = 0,

    @ColumnInfo(name = "concepto")
    val concepto: String? = null,

    @ColumnInfo(name = "valor")
    val valor: Double,

    @Embedded(prefix = "inq_")
    val inquilino: Inquilino? = null,

    @Embedded(prefix = "piso_")
    val piso: Piso? = null
)
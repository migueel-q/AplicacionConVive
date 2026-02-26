package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(
    tableName = "inquilinos",
    foreignKeys = [
        ForeignKey(
            entity = Contrato::class,
            parentColumns = ["id_contrato"],
            childColumns = ["contrato_id_contrato"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
)
@TypeConverters(Converters::class)
data class Inquilino(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre_usuario")
    val nombre_usuario: String,
    @ColumnInfo(name = "nombre_real")
    val nombre_real: String,
    @ColumnInfo(name = "fecha_nacimiento")
    val fecha_nacimiento: String?,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "password")
    val password: String,
    @Embedded(prefix = "contrato_")
    val contrato: Contrato? = null,
    )
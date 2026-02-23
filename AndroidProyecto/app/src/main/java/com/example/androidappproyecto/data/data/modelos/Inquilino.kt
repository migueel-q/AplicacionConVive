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
    override val id: Int,
    override val nombre_usuario: String,
    override val nombre_real: String,
    override val fecha_nacimiento: String?,
    override val email: String,
    override val password: String,
    @Embedded(prefix = "contrato_")
    val contrato: Contrato? = null,

) : Usuario(id, nombre_usuario, nombre_real, fecha_nacimiento, email, password)
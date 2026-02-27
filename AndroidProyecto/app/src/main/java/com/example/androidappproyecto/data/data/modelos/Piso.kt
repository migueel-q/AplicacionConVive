package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity(
    tableName = "pisos",
    foreignKeys = [
        ForeignKey(
            entity = Propietario::class,
            parentColumns = ["id"],
            childColumns = ["prop_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
@TypeConverters(Converters::class)
data class Piso(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_piso")
    val id: Int = 0,
    @Embedded(prefix = "dir_")
    val direccion: Direccion? = null,
    @ColumnInfo(name = "descripcion")
    val descripcion: String,
    @ColumnInfo(name = "url_imagen")
    val url_imagen: String? = null,
    @ColumnInfo(name = "disponible")
    val disponible: Boolean = false,
    @ColumnInfo(name = "precio")
    val precio : Double,
    @ColumnInfo(name = "validado")
    val validado: Boolean = false,
    @Embedded(prefix = "prop_")
    val propietario: Propietario? = null,
)

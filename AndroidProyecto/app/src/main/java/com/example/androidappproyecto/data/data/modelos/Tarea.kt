package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "tareas",
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
    ],
)
data class Tarea(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_tarea")
    val id: Int = 0,
    @ColumnInfo(name = "descripcion")
    val descripcion: String? = null,
    @Embedded(prefix = "inq_")
    val inquilino: Inquilino? = null,
    @Embedded(prefix = "piso_")
    val piso : Piso? = null
)

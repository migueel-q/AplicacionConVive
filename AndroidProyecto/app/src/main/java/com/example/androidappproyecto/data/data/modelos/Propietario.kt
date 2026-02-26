package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "propietarios")
@TypeConverters(Converters::class)
data class Propietario(
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
)
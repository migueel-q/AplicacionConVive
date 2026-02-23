package com.example.androidappproyecto.data.data.modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "propietarios")
@TypeConverters(Converters::class)
data class Propietario(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,
    override val nombre_usuario: String,
    override val nombre_real: String,
    override val fecha_nacimiento: String?,
    override val email: String,
    override val password: String,
) : Usuario(id, nombre_usuario, nombre_real, fecha_nacimiento, email, password)
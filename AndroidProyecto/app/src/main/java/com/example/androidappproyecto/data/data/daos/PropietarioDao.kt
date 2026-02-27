package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.Propietario
import kotlinx.coroutines.flow.Flow

@Dao
interface PropietarioDao {

    @Query("SELECT * FROM propietarios")
    fun getAllPropietarios(): Flow<List<Propietario>>

    @Query("SELECT * FROM propietarios WHERE id = :id")
    suspend fun getPropietarioById(id: Int): Propietario

    @Insert
    suspend fun insertPropietario(propietario: Propietario)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPropietarios(propietarios: List<Propietario>)

    @Update
    suspend fun updatePropietario(propietario: Propietario)

    @Delete
    suspend fun deletePropietario(propietario: Propietario)

    @Query("SELECT * FROM propietarios WHERE email = :email AND password = :password LIMIT 1")
    suspend fun loginPropietario(email: String, password: String): Propietario?
}
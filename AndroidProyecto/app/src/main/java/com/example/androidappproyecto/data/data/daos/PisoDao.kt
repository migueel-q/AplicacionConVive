package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.Piso
import kotlinx.coroutines.flow.Flow

@Dao
interface PisoDao {

    @Query("SELECT * FROM pisos")
    fun getAllPisos(): Flow<List<Piso>>

    @Query("SELECT * FROM pisos WHERE id_piso = :id")
    suspend fun getPisoById(id: Int): Piso

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPisos(pisos: List<Piso>)

    @Insert
    suspend fun insertPiso(piso: Piso)

    @Update
    suspend fun updatePiso(piso: Piso)

    @Delete
    suspend fun deletePiso(piso: Piso)

}
package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.androidappproyecto.data.data.modelos.Piso
import kotlinx.coroutines.flow.Flow

@Dao
interface PisoDao {
    @Query("SELECT * FROM pisos")
    fun getAllPisos(): Flow<List<Piso>>
}
package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.Inquilino
import kotlinx.coroutines.flow.Flow

@Dao
interface InquilinoDao {

    @Query("SELECT * FROM inquilinos")
    fun getAllInquilinos(): Flow<List<Inquilino>>

    @Insert
    suspend fun insertInquilino(inquilino: Inquilino): Long

    @Update
    suspend fun updateInquilino(inquilino: Inquilino)

    @Delete
    suspend fun deleteInquilino(inquilino: Inquilino)

}
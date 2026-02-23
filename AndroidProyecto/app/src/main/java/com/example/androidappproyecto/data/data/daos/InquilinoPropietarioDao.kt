package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.InquilinoPropietario
import kotlinx.coroutines.flow.Flow

@Dao
interface InquilinoPropietarioDao {

    @Query("SELECT * FROM inquilinos_propietarios")
    fun getAllInquilinosPropietarios(): Flow<List<InquilinoPropietarioDao>>

    @Insert
    suspend fun insertInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

    @Update
    suspend fun updateInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

    @Delete
    suspend fun deleteInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

}





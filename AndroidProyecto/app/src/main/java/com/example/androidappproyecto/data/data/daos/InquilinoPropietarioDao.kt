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

    @Query("SELECT * FROM inquilinos_propietarios WHERE id_inquilino_propietario = :id")
    suspend fun getInquilinoPropietarioById(id: Int): InquilinoPropietario

    @Insert
    suspend fun insertInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

    @Insert
    suspend fun insertInquilinosPropietarios(inquilinosPropietarios: List<InquilinoPropietario>)


    @Update
    suspend fun updateInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

    @Delete
    suspend fun deleteInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

}





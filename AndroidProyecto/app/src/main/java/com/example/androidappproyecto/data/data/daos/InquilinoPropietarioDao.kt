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
    @Query("SELECT * FROM inquilinos_propietarios WHERE inq_id = :inq AND prop_id = :prop")
    fun getChat(inq: Int, prop: Int): Flow<List<InquilinoPropietario>>

    @Insert
    suspend fun insertInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

    @Insert
    suspend fun insertInquilinosPropietarios(inquilinosPropietarios: List<InquilinoPropietario>)

    @Update
    suspend fun updateInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)

    @Delete
    suspend fun deleteInquilinoPropietario(inquilinoPropietario: InquilinoPropietario)
    @Query("""
    SELECT 
        CASE 
            WHEN enviado_por_inquilino = 1 THEN prop_id 
            ELSE inq_id 
        END 
    FROM inquilinos_propietarios 
    WHERE inq_id = :idInquilino OR prop_id = :idInquilino 
    LIMIT 1
""")
    suspend fun getPropietarioIdByInquilino(idInquilino: Int): Int?
}





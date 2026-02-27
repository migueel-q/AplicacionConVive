package com.example.androidappproyecto.data.data.daos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.Contrato
import kotlinx.coroutines.flow.Flow

@Dao
interface ContratoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContrato(contrato: Contrato): Long

    @Query("SELECT * FROM contratos")
    fun getAllContratos(): Flow<List<Contrato>>

    @Update
    suspend fun updateContrato(contrato: Contrato)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contratos: List<Contrato>) : List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContratos(contratos: List<Contrato>)
    @Query("SELECT * FROM contratos WHERE piso_id_piso = :pisoId")
    fun getContratosPorPiso(pisoId: Int): List<Contrato>
    @Delete
    suspend fun deleteContrato(contrato: Contrato)

    @Query("SELECT * FROM contratos WHERE id_contrato = :id")
    suspend fun getContratoById(id: Int): Contrato

}

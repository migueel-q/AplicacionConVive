package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.Gasto
import kotlinx.coroutines.flow.Flow

@Dao
interface GastoDao {

    @Query("SELECT * FROM gastos")
    fun getAllGastos(): Flow<List<Gasto>>

    @Query("SELECT * FROM gastos WHERE id_gasto = :id")
    suspend fun getGastoById(id: Int): Gasto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGastos(gastos: List<Gasto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGasto(gasto: Gasto)

    @Update
    suspend fun updateGasto(gasto: Gasto)

    @Delete
    suspend fun deleteGasto(gasto: Gasto)


}
package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.Oferta
import kotlinx.coroutines.flow.Flow

@Dao
interface OfertaDao {
    @Query("SELECT * FROM ofertas")
    fun getAllOfertas(): Flow<List<Oferta>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOferta(oferta: Oferta)

    @Update
    suspend fun updateOferta(oferta: Oferta)

    @Delete
    suspend fun deleteOferta(oferta: Oferta)


}
package com.example.androidappproyecto.data.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidappproyecto.data.data.modelos.Tarea
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDao {

    @Query("SELECT * FROM tareas")
    fun getAllTareas(): Flow<List<Tarea>>

    @Query("SELECT * FROM tareas WHERE id_tarea = :id")
    suspend fun getTareaById(id: Int): Tarea

    @Insert
    suspend fun insertTarea(tarea: Tarea)
    @Query("SELECT * FROM tareas WHERE piso_id_piso = :pisoId")
    fun getTareasByPiso(pisoId: Int): Flow<List<Tarea>>


    @Insert
    suspend fun insertTareas(tareas: List<Tarea>)

    @Update
    suspend fun updateTarea(tarea: Tarea)

    @Delete
    suspend fun deleteTarea(tarea: Tarea)

}
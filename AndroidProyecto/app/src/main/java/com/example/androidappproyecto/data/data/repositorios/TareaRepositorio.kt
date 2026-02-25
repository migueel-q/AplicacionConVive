package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.TareaApi
import com.example.androidappproyecto.data.data.daos.TareaDao
import com.example.androidappproyecto.data.data.modelos.Tarea
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class TareaRepositorio(
    private val tareaDao: TareaDao,
    private val tareaApi: TareaApi
) {

    fun obtenerTodasLasTareas(): Flow<List<Tarea>> {
        return tareaDao.getAllTareas()
    }

    suspend fun obtenerTareaPorId(id: Int): Tarea? {
        return tareaDao.getTareaById(id)
    }

    suspend fun insertarTarea(tarea: Tarea) {
        try {
            val tareaCreada = tareaApi.createTarea(tarea)
            tareaDao.insertTarea(tareaCreada)
        } catch (e: Exception) {
            throw IOException("Error al insertar tarea: ${e.message}", e)
        }
    }

    suspend fun actualizarTarea(tarea: Tarea) {
        try {
            tareaApi.updateTarea(tarea.id, tarea)
            tareaDao.updateTarea(tarea)
        } catch (e: Exception) {
            throw IOException("Error al actualizar tarea: ${e.message}", e)
        }
    }

    suspend fun eliminarTarea(tarea: Tarea) {
        try {
            tareaApi.deleteTarea(tarea.id)
            tareaDao.deleteTarea(tarea)
        } catch (e: Exception) {
            throw IOException("Error al eliminar tarea: ${e.message}", e)
        }
    }

    suspend fun refrescarTareas() {
        try {
            val listaApi = tareaApi.getAllTareas()
            tareaDao.insertTareas(listaApi)
        } catch (e: Exception) {
            println("Error al refrescar tareas: ${e.message}")
        }
    }
}
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
    fun getTareasByPiso(pisoId: Int): Flow<List<Tarea>> {
        return tareaDao.getTareasByPiso(pisoId)
    }

    /**
     * Actualiza solo el estado de "completada" de una tarea.
     */
    suspend fun actualizarEstadoTarea(tareaId: Int, completada: Boolean) {
        try {
            // 1. Buscamos la tarea actual en Room para no perder los otros datos
            val tareaActual = tareaDao.getTareaById(tareaId)
            if (tareaActual != null) {
                // 2. Creamos una copia con el nuevo estado
                val tareaActualizada = tareaActual

                // 3. Actualizamos en el servidor (API Java)
                tareaApi.updateTarea(tareaId, tareaActualizada)

                // 4. Actualizamos en Room
                tareaDao.updateTarea(tareaActualizada)
            }
        } catch (e: Exception) {
            throw IOException("Error al cambiar estado de la tarea: ${e.message}", e)
        }
    }
}
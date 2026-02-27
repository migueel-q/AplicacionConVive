package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.PisoApi
import com.example.androidappproyecto.data.data.daos.PisoDao
import com.example.androidappproyecto.data.data.daos.PropietarioDao
import com.example.androidappproyecto.data.data.modelos.Piso
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class PisoRepositorio(
    private val pisoDao: PisoDao,
    private val pisoApi: PisoApi,
    private val propietarioDao: PropietarioDao
){

    fun obtenerTodosLosPisos(): Flow<List<Piso>> {
        return pisoDao.getAllPisos()
    }
    suspend fun obtenerPisoPorId(pisoId: Int): Piso? {
        return pisoDao.getPisoById(pisoId)
    }

    suspend fun obtenerPisosPorPropietario(propietarioId: Int): List<Piso> {
        return pisoApi.getAllPisos().filter { it.propietario?.id == propietarioId }
    }

    suspend fun insertarPiso(piso: Piso) {
        try {
            val pisoCreadoEnApi = pisoApi.createPiso(piso)
            pisoDao.insertPiso(pisoCreadoEnApi)
        } catch (e: Exception) {
            throw IOException("Error al crear el piso: ${e.message}", e)
        }
    }
    suspend fun actualizarPiso(piso: Piso) {
        try {
            pisoApi.updatePiso(piso.id, piso)
            pisoDao.updatePiso(piso)
        } catch (e: Exception) {
            throw IOException("Error al actualizar el piso: ${e.message}", e)
        }
    }
    suspend fun eliminarPiso(piso: Piso) {
        try {
            pisoApi.deletePiso(piso.id)
            pisoDao.deletePiso(piso)
        } catch (e: Exception) {
            throw IOException("Error al eliminar el piso: ${e.message}", e)
        }
    }


    suspend fun syncPisos(){
        try {
            val pisosDeApi = pisoApi.getAllPisos()

            val propietarios = pisosDeApi.mapNotNull { it.propietario }.distinctBy { it.id }

            propietarioDao.insertPropietarios(propietarios)

            pisoDao.insertPisos(pisosDeApi)
        } catch (e: Exception) {
            e.printStackTrace()
            throw IOException("Error en la sincronización: ${e.message}", e)
        }
    }


}
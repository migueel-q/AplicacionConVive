package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.PisoApi
import com.example.androidappproyecto.data.data.daos.PisoDao
import com.example.androidappproyecto.data.data.modelos.Piso
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class PisoRepositorio(
    private val pisoDao: PisoDao,
    private val pisoApi: PisoApi
){
//    fun obtenerTodosLosPisos(): Flow<List<Piso>> {
//        return pisoDao.getAllPisos()
//    }
//
//    suspend fun obtenerPisoPorId(pisoId: Int): Piso? {
//        return pisoDao.getPisoById(pisoId)
//    }
//
//    suspend fun insertarPiso(piso: Piso) : Piso {
//        val creado = pisoApi.createPiso(piso)
//        pisoDao.insertPiso(creado)
//        return creado
//    }
//    suspend fun actualizarPiso(piso: Piso) {
//        try {
//            val response = pisoApi.updatePiso(piso.id, piso) // Asumo un método updatePiso(id, body)
//            if (response.isSuccessful) {
//                pisoDao.updatePiso(piso)
//            } else {
//                throw IOException("Error al actualizar el piso en el servidor: ${response.message()}")
//            }
//        } catch (e: Exception) {
//            throw e
//        }
//    }
//    suspend fun eliminarPiso(piso: Piso) {
//        try {
//            val response = pisoApi.deletePiso(piso.id) // Asumo un método deletePiso(id)
//            if (response.isSuccessful) {
//                pisoDao.deletePiso(piso)
//            } else {
//                throw IOException("Error al eliminar el piso en el servidor: ${response.message()}")
//            }
//        } catch (e: Exception) {
//            throw e
//        }
//    }
//
//
//    suspend fun syncPisos() : List<Long>{
//        try {
//            val response = pisoApi.getAllPisos() // Llama a la API para obtener la lista fresca
//            if (response.isSuccessful && response.body() != null) {
//                val pisosDeApi = response.body()!!
//                pisoDao.insertPisos(pisosDeApi)
//            }
//        } catch (e: IOException) {
//            throw e
//        }
//    }
//

}
package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.InquilinoApi
import com.example.androidappproyecto.data.data.daos.InquilinoDao
import com.example.androidappproyecto.data.data.modelos.Inquilino
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class InquilinoRepositorio(
    private val inquilinoDao: InquilinoDao,
    private val inquilinoApi: InquilinoApi
) {

    fun obtenerTodosLosInquilinos(): Flow<List<Inquilino>> {
        return inquilinoDao.getAllInquilinos()
    }

    suspend fun obtenerInquilinoPorId(id: Int): Inquilino? {
        return inquilinoDao.getInquilinoById(id)
    }

    suspend fun insertarInquilino(inquilino: Inquilino) {
        try {
            val inquilinoCreado = inquilinoApi.createInquilino(inquilino)
            inquilinoDao.insertInquilino(inquilinoCreado)
        } catch (e: Exception) {
            throw IOException("Error al insertar inquilino: ${e.message}", e)
        }
    }

    suspend fun actualizarInquilino(inquilino: Inquilino) {
        try {
            inquilinoApi.updateInquilino(inquilino.id, inquilino)
            inquilinoDao.updateInquilino(inquilino)
        } catch (e: Exception) {
            throw IOException("Error al actualizar inquilino: ${e.message}", e)
        }
    }

    suspend fun eliminarInquilino(inquilino: Inquilino) {
        try {
            inquilinoApi.deleteInquilino(inquilino.id)
            inquilinoDao.deleteInquilino(inquilino)
        } catch (e: Exception) {
            throw IOException("Error al eliminar inquilino: ${e.message}", e)
        }
    }

    suspend fun refrescarInquilinos() {
        try {
            val listaApi = inquilinoApi.getAllInquilinos()
            inquilinoDao.insertInquilinos(listaApi)
        } catch (e: Exception) {
            println("Error al refrescar inquilinos: ${e.message}")
        }
    }

    suspend fun login(username: String, pass: String): Inquilino? {
        return try {
            val inquilino = inquilinoApi.loginInquilino(username, pass)
            inquilinoDao.insertInquilino(inquilino)
            inquilino
        } catch (e: Exception) {
            inquilinoDao.loginInquilino(username, pass)
        }
    }
}
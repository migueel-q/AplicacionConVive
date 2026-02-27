package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.ContratoApi
import com.example.androidappproyecto.data.data.daos.ContratoDao
import com.example.androidappproyecto.data.data.modelos.Contrato
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class ContratoRepositorio(
    private val contratoDao: ContratoDao,
    private val contratoApi: ContratoApi
) {

    fun obtenerTodosLosContratos(): Flow<List<Contrato>> {
        return contratoDao.getAllContratos()
    }

    suspend fun obtenerContratoPorId(id: Int): Contrato? {
        return contratoDao.getContratoById(id)
    }
    fun getContratosPorPiso(pisoId: Int): List<Contrato> {
        return contratoDao.getContratosPorPiso(pisoId)
    }
    suspend fun insertarContrato(contrato: Contrato) {
        try {
            val contratoCreadoEnServidor = contratoApi.createContrato(contrato)
            contratoDao.insertContrato(contratoCreadoEnServidor)
        } catch (e: Exception) {
            throw IOException("Error al insertar el contrato: ${e.message}", e)
        }
    }

    suspend fun actualizarContrato(contrato: Contrato) {
        try {
            contratoApi.updateContrato(contrato.id, contrato)
            contratoDao.updateContrato(contrato)
        } catch (e: Exception) {
            throw IOException("Error al actualizar el contrato: ${e.message}", e)
        }
    }

    suspend fun eliminarContrato(contrato: Contrato) {
        try {
            contratoApi.deleteContrato(contrato.id)
            contratoDao.deleteContrato(contrato)
        } catch (e: Exception) {
            throw IOException("Error al eliminar el contrato: ${e.message}", e)
        }
    }

    suspend fun refrescarContratos() {
        try {
            val listaDesdeServidor = contratoApi.getAllContratos()
            contratoDao.insertContratos(listaDesdeServidor)
        } catch (e: Exception) {
            println("No se pudieron refrescar los contratos: ${e.message}")
        }
    }
}
package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.GastoApi
import com.example.androidappproyecto.data.data.daos.GastoDao
import com.example.androidappproyecto.data.data.modelos.Gasto
import kotlinx.coroutines.flow.Flow
import java.io.IOException

/**
 * Repositorio para la gestión de Gastos.
 * Actúa como mediador entre Room (local) y Retrofit (remoto).
 */
class GastoRepositorio(
    private val gastoDao: GastoDao,
    private val gastoApi: GastoApi
) {

    fun obtenerTodosLosGastos(): Flow<List<Gasto>> {
        return gastoDao.getAllGastos()
    }

    suspend fun obtenerGastoPorId(id: Int): Gasto? {
        return gastoDao.getGastoById(id)
    }

    suspend fun insertarGasto(gasto: Gasto) {
        try {
            val gastoCreadoEnServidor = gastoApi.createGasto(gasto)
            gastoDao.insertGasto(gastoCreadoEnServidor)
        } catch (e: Exception) {
            throw IOException("Error al insertar el gasto en el servidor: ${e.message}", e)
        }
    }

    suspend fun actualizarGasto(gasto: Gasto) {
        try {
            gastoApi.updateGasto(gasto.id, gasto)
            gastoDao.updateGasto(gasto)
        } catch (e: Exception) {
            throw IOException("Error al actualizar el gasto: ${e.message}", e)
        }
    }

    suspend fun eliminarGasto(gasto: Gasto) {
        try {
            gastoApi.deleteGasto(gasto.id)
            gastoDao.deleteGasto(gasto)
        } catch (e: Exception) {
            throw IOException("Error al eliminar el gasto: ${e.message}", e)
        }
    }

    suspend fun refrescarGastos() {
        try {
            val listaDesdeServidor = gastoApi.getAllGastos()
            gastoDao.insertGastos(listaDesdeServidor)
        } catch (e: Exception) {
            println("Error al sincronizar gastos: ${e.message}")
        }
    }
}
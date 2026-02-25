package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.SolicitudApi
import com.example.androidappproyecto.data.data.daos.SolicitudDao
import com.example.androidappproyecto.data.data.modelos.Solicitud
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class SolicitudRepositorio(
    private val solicitudDao: SolicitudDao,
    private val solicitudApi: SolicitudApi
) {

    fun obtenerTodasLasSolicitudes(): Flow<List<Solicitud>> {
        return solicitudDao.getAllSolicitudes()
    }

    suspend fun obtenerSolicitudPorId(id: Int): Solicitud? {
        return solicitudDao.getSolicitudById(id)
    }

    suspend fun insertarSolicitud(solicitud: Solicitud) {
        try {
            val solicitudCreada = solicitudApi.createSolicitud(solicitud)
            solicitudDao.insertSolicitud(solicitudCreada)
        } catch (e: Exception) {
            throw IOException("Error al insertar solicitud: ${e.message}", e)
        }
    }

    suspend fun actualizarSolicitud(solicitud: Solicitud) {
        try {
            solicitudApi.updateSolicitud(solicitud.id, solicitud)
            solicitudDao.updateSolicitud(solicitud)
        } catch (e: Exception) {
            throw IOException("Error al actualizar solicitud: ${e.message}", e)
        }
    }

    suspend fun eliminarSolicitud(solicitud: Solicitud) {
        try {
            solicitudApi.deleteSolicitud(solicitud.id)
            solicitudDao.deleteSolicitud(solicitud)
        } catch (e: Exception) {
            throw IOException("Error al eliminar solicitud: ${e.message}", e)
        }
    }

    suspend fun refrescarSolicitudes() {
        try {
            val listaApi = solicitudApi.getAllSolicitudes()
            solicitudDao.insertSolicitudes(listaApi)
        } catch (e: Exception) {
            println("Error al refrescar solicitudes: ${e.message}")
        }
    }
}
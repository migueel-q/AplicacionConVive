package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.OfertaApi
import com.example.androidappproyecto.data.data.daos.OfertaDao
import com.example.androidappproyecto.data.data.modelos.Oferta
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class OfertaRepositorio(
    private val ofertaDao: OfertaDao,
    private val ofertaApi: OfertaApi
) {

    fun obtenerTodasLasOfertas(): Flow<List<Oferta>> {
        return ofertaDao.getAllOfertas()
    }

    suspend fun obtenerOfertaPorId(id: Int): Oferta? {
        return ofertaDao.getOfertaById(id)
    }

    suspend fun insertarOferta(oferta: Oferta) {
        try {
            val ofertaCreada = ofertaApi.createOferta(oferta)
            ofertaDao.insertOferta(ofertaCreada)
        } catch (e: Exception) {
            throw IOException("Error al insertar oferta: ${e.message}", e)
        }
    }

    suspend fun actualizarOferta(oferta: Oferta) {
        try {
            ofertaApi.updateOferta(oferta.id, oferta)
            ofertaDao.updateOferta(oferta)
        } catch (e: Exception) {
            throw IOException("Error al actualizar oferta: ${e.message}", e)
        }
    }

    suspend fun eliminarOferta(oferta: Oferta) {
        try {
            ofertaApi.deleteOferta(oferta.id)
            ofertaDao.deleteOferta(oferta)
        } catch (e: Exception) {
            throw IOException("Error al eliminar oferta: ${e.message}", e)
        }
    }

    suspend fun refrescarOfertas() {
        try {
            val listaApi = ofertaApi.getAllOfertas()
            ofertaDao.insertOfertas(listaApi)
        } catch (e: Exception) {
            println("Error al refrescar ofertas: ${e.message}")
        }
    }
}
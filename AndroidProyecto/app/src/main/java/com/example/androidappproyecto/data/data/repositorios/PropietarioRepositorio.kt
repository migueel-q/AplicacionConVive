package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.PropietarioApi
import com.example.androidappproyecto.data.data.daos.PropietarioDao
import com.example.androidappproyecto.data.data.modelos.Propietario
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class PropietarioRepositorio(
    private val propietarioDao: PropietarioDao,
    private val propietarioApi: PropietarioApi
) {

    fun obtenerTodosLosPropietarios(): Flow<List<Propietario>> {
        return propietarioDao.getAllPropietarios()
    }

    suspend fun obtenerPropietarioPorId(id: Int): Propietario? {
        return propietarioDao.getPropietarioById(id)
    }

    suspend fun insertarPropietario(propietario: Propietario) {
        try {
            val propietarioCreado = propietarioApi.createPropietario(propietario)
            propietarioDao.insertPropietario(propietarioCreado)
        } catch (e: Exception) {
            throw IOException("Error al insertar propietario: ${e.message}", e)
        }
    }

    suspend fun actualizarPropietario(propietario: Propietario) {
        try {
            propietarioApi.updatePropietario(propietario.id, propietario)
            propietarioDao.updatePropietario(propietario)
        } catch (e: Exception) {
            throw IOException("Error al actualizar propietario: ${e.message}", e)
        }
    }

    suspend fun eliminarPropietario(propietario: Propietario) {
        try {
            propietarioApi.deletePropietario(propietario.id)
            propietarioDao.deletePropietario(propietario)
        } catch (e: Exception) {
            throw IOException("Error al eliminar propietario: ${e.message}", e)
        }
    }

    suspend fun refrescarPropietarios() {
        try {
            val listaApi = propietarioApi.getAllPropietarios()
            propietarioDao.insertPropietarios(listaApi)
        } catch (e: Exception) {
            println("Error al refrescar propietarios: ${e.message}")
        }
    }

    suspend fun login(username: String, pass: String): Propietario? {
        return try {
            val propietario = propietarioApi.loginPropietario(username, pass)
            propietarioDao.insertPropietario(propietario)
            propietario
        } catch (e: Exception) {
            propietarioDao.loginPropietario(username, pass)
        }
    }
}

package com.example.androidappproyecto.data.data.repositorios

import com.example.androidappproyecto.data.data.api.InquilinoApi
import com.example.androidappproyecto.data.data.api.InquilinoPropietarioApi
import com.example.androidappproyecto.data.data.api.PropietarioApi
import com.example.androidappproyecto.data.data.daos.InquilinoDao
import com.example.androidappproyecto.data.data.daos.InquilinoPropietarioDao
import com.example.androidappproyecto.data.data.daos.PropietarioDao
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario
import java.io.IOException

class InquilinoPropietarioRepositorio(
    private val api: InquilinoPropietarioApi,
    private val dao: InquilinoPropietarioDao

) {
    fun getChatLocal(inq: Int, prop: Int) =
        dao.getChat(inq, prop)

    suspend fun syncChat(inq: Int, prop: Int) {
        val mensajes = api.getChat(inq, prop)
        dao.insertInquilinosPropietarios(mensajes)
    }

    suspend fun enviarMensaje(inq: Int, prop: Int, texto: String, enviadoPorInquilino: Boolean) {
        val msg = api.enviarMensaje(inq, prop, texto, enviadoPorInquilino)
        dao.insertInquilinoPropietario(msg)
    }

}
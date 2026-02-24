package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Solicitud
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface SolicitudApi {

    @GET("api/solicitudes")
    suspend fun getAllSolicitudes(): List<Solicitud>

    @GET("api/solicitudes/{id}")
    suspend fun getSolicitudById(@Path("id") id: Int): Solicitud

    @POST("api/solicitudes")
    suspend fun createSolicitud(@Body solicitud: Solicitud): Solicitud

    @PUT("api/solicitudes/{id}")
    suspend fun updateSolicitud(@Path("id") id: Int, @Body solicitud: Solicitud): Solicitud

    @DELETE("api/solicitudes/{id}")
    suspend fun deleteSolicitud(@Path("id") id: Int)

}
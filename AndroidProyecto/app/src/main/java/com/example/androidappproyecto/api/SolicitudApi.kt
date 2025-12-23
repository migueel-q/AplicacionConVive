package com.example.androidappproyecto.api
import com.example.androidappproyecto.modelos.Solicitud
import retrofit2.Call
import retrofit2.http.*
interface SolicitudApi {
    @GET("solicitudes")
    fun findAll(): Call<List<Solicitud>>

    @GET("solicitudes/{id}")
    fun findById(@Path("id") id: Int): Call<Solicitud>

    @POST("solicitudes")
    fun add(@Body solicitud: Solicitud): Call<Solicitud>

    @PUT("solicitudes/{id}")
    fun update(@Path("id") id: Int, @Body solicitud: Solicitud): Call<Solicitud>

    @DELETE("solicitudes/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
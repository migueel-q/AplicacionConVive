package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Oferta
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface OfertaApi {

    @GET("api/ofertas")
    suspend fun getAllOfertas(): List<Oferta>

    @GET("api/ofertas/{id}")
    suspend fun getOfertaById(@Path("id") id: Int): Oferta

    @POST("api/ofertas")
    suspend fun createOferta(@Body oferta: Oferta): Oferta

    @PUT("api/ofertas/{id}")
    suspend fun updateOferta(@Path("id") id: Int, @Body oferta: Oferta): Oferta

    @DELETE("api/ofertas/{id}")
    suspend fun deleteOferta(@Path("id") id: Int)
}
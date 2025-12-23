package com.example.androidappproyecto.api

import com.example.androidappproyecto.modelos.Oferta
import retrofit2.Call
import retrofit2.http.*

interface OfertaApi {
    @GET("ofertas")
    fun findAll(): Call<List<Oferta>>

    @GET("ofertas/{id}")
    fun findById(@Path("id") id: Int): Call<Oferta>

    @POST("ofertas")
    fun add(@Body oferta: Oferta): Call<Oferta>

    @PUT("ofertas/{id}")
    fun update(@Path("id") id: Int, @Body oferta: Oferta): Call<Oferta>

    @DELETE("ofertas/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
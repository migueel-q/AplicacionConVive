package com.example.androidappproyecto.api

import com.example.androidappproyecto.modelos.Piso
import retrofit2.Call
import retrofit2.http.*
interface PisoApi {

    @GET("pisos")
    fun findAll(): Call<List<Piso>>

    @GET("pisos/{id}")
    fun findById(@Path("id") id: Int): Call<Piso>

    @POST("pisos")
    fun add(@Body piso: Piso): Call<Piso>

    @PUT("pisos/{id}")
    fun update(@Path("id") id: Int, @Body piso: Piso): Call<Piso>

    @DELETE("pisos/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
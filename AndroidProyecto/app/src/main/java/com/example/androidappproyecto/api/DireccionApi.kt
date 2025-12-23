package com.example.androidappproyecto.api


import com.example.androidappproyecto.modelos.Direccion
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface DireccionApi {
    @GET("direcciones")
    fun findAll(): Call<List<Direccion>>

    @GET("direcciones/{id}")
    fun findById(@Path("id") id: Int): Call<Direccion>

    @POST("direcciones")
    fun add(@Body direccion: Direccion): Call<Direccion>

    @PUT("direcciones/{id}")
    fun update(@Path("id") id: Int, @Body direccion: Direccion): Call<Direccion>

    @DELETE("direcciones/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
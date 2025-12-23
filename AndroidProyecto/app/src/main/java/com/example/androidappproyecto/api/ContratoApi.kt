package com.example.androidappproyecto.api

import com.example.androidappproyecto.modelos.Contrato
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ContratoApi {
    @GET("contratos")
    fun findAll(): Call<List<Contrato>>

    @GET("contratos/{id}")
    fun findById(@Path("id") id: Int): Call<Contrato>

    @POST("contratos")
    fun add(@Body contrato: Contrato): Call<Contrato>

    @PUT("contratos/{id}")
    fun update(@Path("id") id: Int, @Body contrato: Contrato): Call<Contrato>

    @DELETE("contratos/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
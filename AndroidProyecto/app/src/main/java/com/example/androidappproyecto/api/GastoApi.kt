package com.example.androidappproyecto.api


import com.example.androidappproyecto.modelos.Gasto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface GastoApi {
    @GET("gastos")
    fun findAll(): Call<List<Gasto>>

    @GET("gastos/{id}")
    fun findById(@Path("id") id: Int): Call<Gasto>

    @POST("gastos")
    fun add(@Body gasto: Gasto): Call<Gasto>

    @PUT("gastos/{id}")
    fun update(@Path("id") id: Int, @Body gasto: Gasto): Call<Gasto>

    @DELETE("gastos/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
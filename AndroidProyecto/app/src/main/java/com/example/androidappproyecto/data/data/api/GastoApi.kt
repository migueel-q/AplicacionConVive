package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Gasto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface GastoApi {

    @GET("api/gastos")
    suspend fun getAllGastos(): List<Gasto>

    @GET("api/gastos/{id}")
    suspend fun getGastoById(@Path("id") id: Int): Gasto

    @POST("api/gastos")
    suspend fun createGasto(@Body gasto: Gasto): Gasto

    @PUT("api/gastos/{id}")
    suspend fun updateGasto(@Path("id") id: Int, @Body gasto: Gasto): Gasto

    @DELETE("api/gastos/{id}")
    suspend fun deleteGasto(@Path("id") id: Int)
}
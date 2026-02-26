package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Piso
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PisoApi {

    @GET("api/pisos")
    suspend fun getAllPisos(): List<Piso>

    @GET("api/pisos/{id}")
    suspend fun getPisoById(@Path("id") id: Int): Piso

    @POST("api/pisos")
    suspend fun createPiso(@Body piso: Piso): Piso

    @PUT("api/pisos/{id}")
    suspend fun updatePiso(@Path("id") id: Int, @Body piso: Piso): Piso

    @DELETE("api/pisos/{id}")
    suspend fun deletePiso(@Path("id") id: Int)

}
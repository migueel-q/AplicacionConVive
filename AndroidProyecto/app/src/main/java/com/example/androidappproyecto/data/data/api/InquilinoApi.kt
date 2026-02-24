package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Inquilino
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface InquilinoApi {

    @GET("api/inquilinos")
    suspend fun getAllInquilinos(): List<Inquilino>

    @GET("api/inquilinos/{id}")
    suspend fun getInquilinoById(@Path("id") id: Int): Inquilino

    @POST("api/inquilinos")
    suspend fun createInquilino(@Body inquilino: Inquilino): Inquilino

    @PUT("api/inquilinos/{id}")
    suspend fun updateInquilino(@Path("id") id: Int, @Body inquilino: Inquilino): Inquilino

    @DELETE("api/inquilinos/{id}")
    suspend fun deleteInquilino(@Path("id") id: Int)

}
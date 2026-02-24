package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Contrato
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface ContratoApi {

    @GET("api/contratos")
    suspend fun getAllContratos(): List<Contrato>

    @GET("api/contratos/{id}")
    suspend fun getContratoById(@Path("id") id: Int): Contrato

    @POST("api/contratos")
    suspend fun createContrato(@Body contrato: Contrato): Contrato

    @PUT("api/contratos/{id}")
    suspend fun updateContrato(@Path("id") id: Int, @Body contrato: Contrato): Contrato

    @DELETE("api/contratos/{id}")
    suspend fun deleteContrato(@Path("id") id: Int)
}
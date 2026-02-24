package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.InquilinoPropietario
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface InquilinoPropietarioApi {

    @GET("api/inquilinos_propietarios")
    suspend fun getAllInquilinosPropietarios(): List<InquilinoPropietario>

    @GET("api/inquilinos_propietarios/{id}")
    suspend fun getInquilinoPropietarioById(@Path("id") id: Int): InquilinoPropietario

    @POST("api/inquilinos_propietarios")
    suspend fun createInquilinoPropietario(@Body inquilinoPropietario: InquilinoPropietario): InquilinoPropietario

    @PUT("api/inquilinos_propietarios/{id}")
    suspend fun updateInquilinoPropietario(@Path("id") id: Int, @Body inquilinoPropietario: InquilinoPropietario): InquilinoPropietario

    @DELETE("api/inquilinos_propietarios/{id}")
    suspend fun deleteInquilinoPropietario(@Path("id") id: Int)

}
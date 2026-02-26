package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Inquilino
import retrofit2.http.Query
import com.example.androidappproyecto.data.data.modelos.Propietario
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PropietarioApi {

    @GET("api/propietarios")
    suspend fun getAllPropietarios(): List<Propietario>

    @GET("api/propietarios/{id}")
    suspend fun getPropietarioById(@Path("id") id: Int): Propietario

    @POST("api/propietarios")
    suspend fun createPropietario(@Body propietario: Propietario): Propietario

    @PUT("api/propietarios/{id}")
    suspend fun updatePropietario(@Path("id") id: Int, @Body propietario: Propietario): Propietario

    @DELETE("api/propietarios/{id}")
    suspend fun deletePropietario(@Path("id") id: Int)

    @POST("api/propietarios/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Propietario

    data class LoginRequest(
        val email: String,
        val password: String
    )
}
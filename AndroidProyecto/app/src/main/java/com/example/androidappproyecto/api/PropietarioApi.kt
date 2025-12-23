package com.example.androidappproyecto.api
import com.example.androidappproyecto.modelos.Propietario
import retrofit2.Call
import retrofit2.http.*
interface PropietarioApi {
    @GET("propietarios")
    fun findAll(): Call<List<Propietario>>

    @GET("propietarios/{id}")
    fun findById(@Path("id") id: Int): Call<Propietario>

    @POST("propietarios")
    fun add(@Body propietario: Propietario): Call<Propietario>

    @PUT("propietarios/{id}")
    fun update(@Path("id") id: Int, @Body propietario: Propietario): Call<Propietario>

    @DELETE("propietarios/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
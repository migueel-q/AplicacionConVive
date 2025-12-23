package com.example.androidappproyecto.api
import com.example.androidappproyecto.modelos.Usuario
import retrofit2.Call
import retrofit2.http.*
interface UsuarioApi {
    @GET("usuarios")
    fun findAll(): Call<List<Usuario>>

    @GET("usuarios/{id}")
    fun findById(@Path("id") id: Int): Call<Usuario>

    @POST("usuarios")
    fun add(@Body usuario: Usuario): Call<Usuario>

    @PUT("usuarios/{id}")
    fun update(@Path("id") id: Int, @Body usuario: Usuario): Call<Usuario>

    @DELETE("usuarios/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
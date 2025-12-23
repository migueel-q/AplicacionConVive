package com.example.androidappproyecto.api


import com.example.androidappproyecto.modelos.Inquilino
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface InquilinoApi {
    @GET("inquilinos")
    fun findAll(): Call<List<Inquilino>>

    @GET("inquilinos/{id}")
    fun findById(@Path("id") id: Int): Call<Inquilino>

    @POST("inquilinos")
    fun add(@Body inquilino: Inquilino): Call<Inquilino>

    @PUT("inquilinos/{id}")
    fun update(@Path("id") id: Int, @Body inquilino: Inquilino): Call<Inquilino>

    @DELETE("inquilinos/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
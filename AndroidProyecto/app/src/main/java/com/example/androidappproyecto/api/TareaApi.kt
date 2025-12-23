package com.example.androidappproyecto.api
import com.example.androidappproyecto.modelos.Tarea
import retrofit2.Call
import retrofit2.http.*
interface TareaApi {
    @GET("tareas")
    fun findAll(): Call<List<Tarea>>

    @GET("tareas/{id}")
    fun findById(@Path("id") id: Int): Call<Tarea>

    @POST("tareas")
    fun add(@Body tarea: Tarea): Call<Tarea>

    @PUT("tareas/{id}")
    fun update(@Path("id") id: Int, @Body tarea: Tarea): Call<Tarea>

    @DELETE("tareas/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}
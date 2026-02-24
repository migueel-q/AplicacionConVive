package com.example.androidappproyecto.data.data.api

import com.example.androidappproyecto.data.data.modelos.Tarea
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TareaApi {

    @GET("api/tareas")
    suspend fun getAllTareas(): List<Tarea>

    @GET("api/tareas/{id}")
    suspend fun getTareaById(@Path("id") id: Int): Tarea

    @POST("api/tareas")
    suspend fun createTarea(@Body tarea: Tarea): Tarea

    @PUT("api/tareas/{id}")
    suspend fun updateTarea(@Path("id") id: Int, @Body tarea: Tarea): Tarea

    @DELETE("api/tareas/{id}")
    suspend fun deleteTarea(@Path("id") id: Int)

}
package com.example.androidappproyecto.database

import com.example.androidappproyecto.data.data.api.ContratoApi
import com.example.androidappproyecto.data.data.api.GastoApi
import com.example.androidappproyecto.data.data.api.InquilinoApi
import com.example.androidappproyecto.data.data.api.InquilinoPropietarioApi
import com.example.androidappproyecto.data.data.api.OfertaApi
import com.example.androidappproyecto.data.data.api.PisoApi
import com.example.androidappproyecto.data.data.api.PropietarioApi
import com.example.androidappproyecto.data.data.api.SolicitudApi
import com.example.androidappproyecto.data.data.api.TareaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCliente {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val contratoApi: ContratoApi by lazy {
        retrofit.create(ContratoApi::class.java)
    }

    val gastoApi: GastoApi by lazy {
        retrofit.create(GastoApi::class.java)
    }

    val inquilinoApi : InquilinoApi by lazy {
        retrofit.create(InquilinoApi::class.java)
    }

    val inquilinoPropietarioApi : InquilinoPropietarioApi by lazy {
        retrofit.create(InquilinoPropietarioApi::class.java)
    }

    val ofertaApi: OfertaApi by lazy {
        retrofit.create(OfertaApi::class.java)
    }

    val pisoApi: PisoApi by lazy {
        retrofit.create(PisoApi::class.java)
    }

    val propietarioApi: PropietarioApi by lazy {
        retrofit.create(PropietarioApi::class.java)
    }

    val solicitudApi: SolicitudApi by lazy {
        retrofit.create(SolicitudApi::class.java)
    }

    val tareaApi: TareaApi by lazy {
        retrofit.create(TareaApi::class.java)
    }
}
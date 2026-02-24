package com.example.androidappproyecto.data.data.modelos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.input.key.type
import androidx.room.TypeConverter
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.time.LocalDate

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromInquilinoList(value: List<Inquilino>?): String? = gson.toJson(value)

    @TypeConverter
    fun toInquilinoList(value: String?): List<Inquilino>? {
        val listType = object : TypeToken<List<Inquilino>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromPropietario(value: Propietario?): String? = gson.toJson(value)

    @TypeConverter
    fun toPropietario(value: String?): Propietario? = gson.fromJson(value, Propietario::class.java)

    @TypeConverter
    fun fromPiso(value: Piso?): String? = gson.toJson(value)

    @TypeConverter
    fun toPiso(value: String?): Piso? = gson.fromJson(value, Piso::class.java)

    @TypeConverter
    fun fromTareaList(value: List<Tarea>?): String? = gson.toJson(value)

    @TypeConverter
    fun toTareaList(value: String?): List<Tarea>? {
        val listType = object : TypeToken<List<Tarea>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromContrato(value: Contrato?): String? = gson.toJson(value)

    @TypeConverter
    fun toContrato(value: String?): Contrato? = gson.fromJson(value, Contrato::class.java)

    @TypeConverter
    fun fromSolicitudList(value: List<Solicitud>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toSolicitudList(value: String?): List<Solicitud>? {
        val listType = object : TypeToken<List<Solicitud>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromContratoList(value: List<Contrato>?): String? = Gson().toJson(value)

    @TypeConverter
    fun toContratoList(value: String?): List<Contrato>? {
        val listType = object : TypeToken<List<Contrato>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPisoList(value: List<Piso>?): String? = gson.toJson(value)

    @TypeConverter
    fun toPisoList(value: String?): List<Piso>? {
        val listType = object : TypeToken<List<Piso>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromInqPropList(value: List<InquilinoPropietario>?): String? = gson.toJson(value)

    @TypeConverter
    fun toInqPropList(value: String?): List<InquilinoPropietario>? {
        val listType = object : TypeToken<List<InquilinoPropietario>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromOfertaList(value: List<Oferta>?): String? = gson.toJson(value)

    @TypeConverter
    fun toOfertaList(value: String?): List<Oferta>? {
        val listType = object : TypeToken<List<Oferta>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromGastoList(value: List<Gasto>?): String? = gson.toJson(value)

    @TypeConverter
    fun toGastoList(value: String?): List<Gasto>? {
        val listType = object : TypeToken<List<Gasto>?>() {}.type
        return gson.fromJson(value, listType)
    }
}
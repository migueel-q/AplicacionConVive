package com.example.androidappproyecto.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.androidappproyecto.data.data.daos.ContratoDao
import com.example.androidappproyecto.data.data.daos.GastoDao
import com.example.androidappproyecto.data.data.daos.InquilinoDao
import com.example.androidappproyecto.data.data.daos.InquilinoPropietarioDao
import com.example.androidappproyecto.data.data.daos.OfertaDao
import com.example.androidappproyecto.data.data.daos.PisoDao
import com.example.androidappproyecto.data.data.daos.PropietarioDao
import com.example.androidappproyecto.data.data.daos.SolicitudDao
import com.example.androidappproyecto.data.data.daos.TareaDao
import com.example.androidappproyecto.data.data.modelos.Contrato
import com.example.androidappproyecto.data.data.modelos.Converters
import com.example.androidappproyecto.data.data.modelos.Gasto
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Oferta
import com.example.androidappproyecto.data.data.modelos.Piso
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.modelos.Solicitud
import com.example.androidappproyecto.data.data.modelos.Tarea
import com.example.androidappproyecto.data.data.modelos.Usuario
import kotlin.jvm.java

@Database(
    entities = [
        Contrato::class,
        Gasto::class,
        Inquilino::class,
        Oferta::class,
        Piso::class,
        Solicitud::class,
        Tarea::class,
        Propietario::class,
    ],
    version = 6,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contratoDao(): ContratoDao
    abstract fun gastoDao(): GastoDao
    abstract fun inquilinoDao(): InquilinoDao
    abstract fun inquilinoPropietarioDao(): InquilinoPropietarioDao
    abstract fun ofertaDao(): OfertaDao
    abstract fun pisoDao(): PisoDao
    abstract fun propietarioDao(): PropietarioDao
    abstract fun solicitudDao(): SolicitudDao
    abstract fun tareaDao(): TareaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "mydb"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


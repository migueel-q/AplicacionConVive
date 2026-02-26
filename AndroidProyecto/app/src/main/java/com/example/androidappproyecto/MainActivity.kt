package com.example.androidappproyecto

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidappproyecto.data.data.DTO.PropietarioDTO
import com.example.androidappproyecto.data.data.modelos.Direccion
import com.example.androidappproyecto.data.data.modelos.Piso
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.repositorios.PisoRepositorio
import com.example.androidappproyecto.data.data.viewmodels.PisoViewModel
import com.example.androidappproyecto.database.ApiCliente
import com.example.androidappproyecto.database.AppDatabase
import com.example.androidappproyecto.pantallas.ProyectoView
import com.example.androidappproyecto.ui.theme.AndroidAppProyectoTheme
import kotlinx.coroutines.launch

// MainActivity.kt
class MainActivity : ComponentActivity() {

    private lateinit var pisoViewModel: PisoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = AppDatabase.getDatabase(applicationContext)
        val pisoRepository = PisoRepositorio(
            pisoDao = db.pisoDao(),
            pisoApi = ApiCliente.pisoApi,
            propietarioDao = db.propietarioDao()
        )

        // ViewModel Factory
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PisoViewModel(
                    repositorio = pisoRepository,
                ) as T
            }
        }
        pisoViewModel = ViewModelProvider(this, factory)[PisoViewModel::class.java]
                setContent {
                    AndroidAppProyectoTheme {
                        MainScreen(pisoViewModel = pisoViewModel)
                    }
                }
            }
        }



@Composable
fun MainScreen(pisoViewModel: PisoViewModel) {
    ProyectoView(
        pisoViewModel = pisoViewModel
    )
}

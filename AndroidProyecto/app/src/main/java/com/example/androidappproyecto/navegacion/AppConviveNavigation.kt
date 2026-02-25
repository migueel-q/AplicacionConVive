package com.example.androidappproyecto.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.androidappproyecto.data.data.modelos.Usuario
import com.example.androidappproyecto.data.data.repositorios.InquilinoPropietarioRepositorio
import com.example.androidappproyecto.data.data.viewmodels.InquilinoPropietarioViewModel
import com.example.androidappproyecto.database.ApiCliente
import com.example.androidappproyecto.database.AppDatabase
import com.example.androidappproyecto.pantallas.PantallaBuscar
import com.example.androidappproyecto.pantallas.PantallaDetallePiso
import com.example.androidappproyecto.pantallas.PantallaHome
import com.example.androidappproyecto.pantallas.PantallaMisPisos
import com.example.androidappproyecto.pantallas.PantallaPerfil
import com.example.androidappproyecto.pantallas.PantallaChat

@Composable
fun AppConviveNavigation(navController: NavHostController, modifier: Modifier){
    // Simula sesión actual
    var currentUser = Usuario(
        id = 0,
        nombre_usuario = "miguelq",
        nombre_real = "miguel angel",
        fecha_nacimiento = "2005-12-12",
        password = "1234",
        email = "miguel@gmail.com"
    )

    NavHost(navController = navController,
        modifier = modifier,
        startDestination = Rutas.Home.name)
    {
        composable(Rutas.Home.name){ PantallaHome() }
        composable(Rutas.Buscar.name) { PantallaBuscar() }
        composable(Rutas.Chat.name + "/{inqId}/{propId}") { backStack ->
            val context = androidx.compose.ui.platform.LocalContext.current

            val inq = backStack.arguments?.getString("inqId")?.toInt() ?: 0
            val prop = backStack.arguments?.getString("propId")?.toInt() ?: 0

            val chatViewModel: InquilinoPropietarioViewModel =
                viewModel(
                // Usa una clave para que el ViewModel persista correctamente en la navegación
                key = "chat_${inq}_${prop}",
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        val database = AppDatabase.getDatabase(context)
                        // 1. Instancia el servicio de la API
                        val apiService = ApiCliente.inquilinoPropietarioApi
                        // 2. Pasa las dos dependencias al repositorio
                        val repository =
                            InquilinoPropietarioRepositorio(apiService, database.inquilinoPropietarioDao())

                        // Casteo seguro para devolver el ViewModel
                        @Suppress("UNCHECKED_CAST")
                        return InquilinoPropietarioViewModel(repository) as T
                    }
                }
            )

            PantallaChat(
                viewModel = chatViewModel,
                inqId = inq,
                propId = prop
            )
        }
        composable(Rutas.MisPisos.name) { PantallaMisPisos(navController) }
        composable(Rutas.Perfil.name) { PantallaPerfil(user = currentUser) }
        composable(Rutas.DetallePiso.name) { PantallaDetallePiso() }
    }

}




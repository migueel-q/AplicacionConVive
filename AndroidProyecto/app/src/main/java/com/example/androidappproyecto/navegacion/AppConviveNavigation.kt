package com.example.androidappproyecto.navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.modelos.Usuario
import com.example.androidappproyecto.data.data.repositorios.ContratoRepositorio
import com.example.androidappproyecto.data.data.repositorios.InquilinoPropietarioRepositorio
import com.example.androidappproyecto.data.data.repositorios.InquilinoRepositorio
import com.example.androidappproyecto.data.data.repositorios.PisoRepositorio
import com.example.androidappproyecto.data.data.repositorios.PropietarioRepositorio
import com.example.androidappproyecto.data.data.viewmodels.ContratoViewModel
import com.example.androidappproyecto.data.data.viewmodels.InquilinoPropietarioViewModel
import com.example.androidappproyecto.data.data.viewmodels.LoginState
import com.example.androidappproyecto.data.data.viewmodels.LoginViewModel
import com.example.androidappproyecto.data.data.viewmodels.PisoViewModel
import com.example.androidappproyecto.database.ApiCliente
import com.example.androidappproyecto.database.AppDatabase
import com.example.androidappproyecto.pantallas.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppConviveNavigation(navController: NavHostController, modifier: Modifier,pisoViewModel: PisoViewModel) {
    val context = LocalContext.current

    var currentUser by remember { mutableStateOf<Usuario?>(null) }
    var currentUserInq by remember { mutableStateOf<Inquilino?>(null) }
    var currentUserProp by remember { mutableStateOf<Propietario?>(null) }


    val loginViewModel: LoginViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val database = AppDatabase.getDatabase(context)
                val repoProp = PropietarioRepositorio(
                    database.propietarioDao(),
                    ApiCliente.propietarioApi
                )
                val repoInq = InquilinoRepositorio(
                    database.inquilinoDao(),
                    ApiCliente.inquilinoApi
                )
                @Suppress("UNCHECKED_CAST")
                return LoginViewModel(repoProp, repoInq) as T
            }
        }
    )
    val loginEstado = loginViewModel.estado
    LaunchedEffect(loginEstado) {
        if (loginEstado is LoginState.Success) {
            if(loginEstado.rol == "INQUILINO") {
                currentUserInq = Inquilino(
                    id = loginEstado.userId,
                    nombre_usuario = loginEstado.nombreUsuario,
                    nombre_real = loginEstado.nombreReal,
                    email = loginEstado.email,
                    password = loginEstado.password,
                    fecha_nacimiento = loginEstado.fechaNac
                )
                currentUserProp = null
            }
            if(loginEstado.rol == "PROPIETARIO") {
                currentUserProp = Propietario(
                    id = loginEstado.userId,
                    nombre_usuario = loginEstado.nombreUsuario,
                    nombre_real = loginEstado.nombreReal,
                    email = loginEstado.email,
                    password = loginEstado.password,
                    fecha_nacimiento = loginEstado.fechaNac
                    )
                currentUserInq = null
            }
        }
    }

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Rutas.Login.name
    ) {
        composable(Rutas.Login.name) {
            PantallaLogin(viewModel = loginViewModel, navController = navController)
        }
        composable(Rutas.Home.name) {
                PantallaHome(
                    currentUserInq,
                    currentUserProp,
                    pisoViewModel = pisoViewModel,
                    onPisoClick = { piso ->
                        // 1. Guardamos el piso seleccionado para que la otra pantalla lo lea
                        PisoSeleccionado.piso = piso

                        // 2. Navegamos a la pantalla de detalle
                        navController.navigate(Rutas.DetallePiso.name)
                    }
                )
        }
        composable(Rutas.Buscar.name) { PantallaBuscar(pisoViewModel) }

        composable(Rutas.Chat.name + "/{inqId}/{propId}") { backStack ->
            val inq = backStack.arguments?.getString("inqId")?.toInt() ?: 0
            val prop = backStack.arguments?.getString("propId")?.toInt() ?: 0

            val chatViewModel: InquilinoPropietarioViewModel = viewModel(
                key = "chat_${inq}_${prop}",
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        val database = AppDatabase.getDatabase(context)
                        val repository = InquilinoPropietarioRepositorio(
                            ApiCliente.inquilinoPropietarioApi,
                            database.inquilinoPropietarioDao()
                        )
                        @Suppress("UNCHECKED_CAST")
                        return InquilinoPropietarioViewModel(repository) as T
                    }
                }
            )
            PantallaChat(viewModel = chatViewModel, inqId = inq, propId = prop, currentUser)
        }

        composable(Rutas.MisPisos.name) { PantallaMisPisos(navController) }

        composable(Rutas.Perfil.name) {
            PantallaPerfil(currentUserInq, currentUserProp, navController, loginViewModel)
        }

        composable(Rutas.DetallePiso.name) {
            val contratoViewModel: ContratoViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        val repository = ContratoRepositorio(AppDatabase.getDatabase(context).contratoDao(), ApiCliente.contratoApi)
                        @Suppress("UNCHECKED_CAST")
                        return ContratoViewModel(repository) as T
                    }
                }
            )
            PantallaDetallePiso(currentUserInq, currentUserProp, contratoViewModel) }
    }
}
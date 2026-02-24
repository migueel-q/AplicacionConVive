package com.example.androidappproyecto.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.androidappproyecto.data.data.modelos.Usuario
import com.example.androidappproyecto.pantallas.PantallaBuscar
import com.example.androidappproyecto.pantallas.PantallaDetallePiso
import com.example.androidappproyecto.pantallas.PantallaHome
import com.example.androidappproyecto.pantallas.PantallaMisPisos
import com.example.androidappproyecto.pantallas.PantallaPerfil
import com.example.androidappproyecto.pantallas.PantallaChat
import com.example.androidappproyecto.navegacion.Rutas

@Composable
fun AppConviveNavigation(navController: NavHostController){
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
        startDestination = Rutas.Home.name)
    {
        composable(Rutas.Home.name){ PantallaHome() }
        composable(Rutas.Buscar.name) { PantallaBuscar() }
        composable(Rutas.Chat.name){ PantallaChat() }
        composable(Rutas.MisPisos.name) { PantallaMisPisos(navController) }
        composable(Rutas.Perfil.name) { PantallaPerfil(user = currentUser) }
        composable(Rutas.DetallePiso.name) { PantallaDetallePiso() }
    }

}




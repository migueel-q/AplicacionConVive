package com.example.androidappproyecto.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.androidappproyecto.modelos.Usuario
import com.example.androidappproyecto.pantallas.PantallaBuscar
import com.example.androidappproyecto.pantallas.PantallaDetallePiso
import com.example.androidappproyecto.pantallas.PantallaHome
import com.example.androidappproyecto.pantallas.PantallaMisPisos
import com.example.androidappproyecto.pantallas.PantallaPerfil
import com.example.androidappproyecto.pantallas.PantallaPremium
import com.example.androidappproyecto.pantallas.Rutas

@Composable
fun AppConviveNavigation(navController: NavHostController){
    // Simula sesión actual
    var currentUser = Usuario(
        uid = "1",
        name = "Juan Pérez",
        email = "juan@email.com",
        role = "propietario",
        phone = "123456789",
        address = "Calle Falsa 123"
    )

    NavHost(navController = navController,
        startDestination = Rutas.Home.name)
    {
        composable(Rutas.Home.name){ PantallaHome() }
        composable(Rutas.MisPisos.name) { PantallaMisPisos(navController) }
        composable(Rutas.Buscar.name) { PantallaBuscar() }
        composable(Rutas.Perfil.name) { PantallaPerfil(user = currentUser) }
        composable(Rutas.Premium.name) { PantallaPremium() }
        composable(Rutas.DetallePiso.name) { PantallaDetallePiso() }
    }

}




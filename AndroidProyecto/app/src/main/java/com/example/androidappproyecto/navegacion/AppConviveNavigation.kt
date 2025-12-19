package com.example.androidappproyecto.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

@Composable
fun MiMusicaNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Rutas.Home.name)
    {
        composable(Rutas.Home.name){ PantallaHome() }
        composable(Rutas.MisPisos.name) { PantallaMisPisos() }
        composable(Rutas.Buscar.name) { BuscarView() }
        composable(Rutas.Perfil.name) { PantallaPerfil() }
        composable(Rutas.Premium.name) { PremiumView() }
    }

}




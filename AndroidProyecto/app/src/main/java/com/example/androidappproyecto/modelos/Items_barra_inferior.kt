package com.example.androidappproyecto.modelos
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androidappproyecto.navegacion.Rutas

sealed class Items_barra_inferior(
    val icono: ImageVector,
    val texto:String,
    val ruta:String
) {
    object Item_bottom_nav_home: Items_barra_inferior(
        Icons.Filled.Home,"Home", Rutas.Home.name)
    object Item_bottom_nav_artists:Items_barra_inferior(
        Icons.Filled.List,"Artists",Rutas.MisPisos.name)
    object Item_bottom_nav_search:Items_barra_inferior(
        Icons.Filled.Search,"Search",Rutas.Buscar.name)
    object Item_bottom_nav_myapp:Items_barra_inferior(
        Icons.Filled.Person,"MyApp",Rutas.Perfil.name)
    object Item_bottom_nav_premium:Items_barra_inferior(
        Icons.Filled.Star,"Premium",Rutas.Premium.name)
}

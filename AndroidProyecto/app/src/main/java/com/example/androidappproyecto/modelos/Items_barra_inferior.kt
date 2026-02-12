package com.example.androidappproyecto.modelos
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androidappproyecto.pantallas.Rutas

sealed class Items_barra_inferior(
    val icono: ImageVector,
    val texto:String,
    val ruta:String
) {
    object Item_bottom_nav_home: Items_barra_inferior(
        Icons.Filled.Home,"Home", Rutas.Home.name)
    object Item_bottom_nav_search:Items_barra_inferior(
        Icons.Filled.Search,"Buscar", Rutas.Buscar.name)
    object Item_bottom_nav_chat:Items_barra_inferior(
        Icons.Filled.Notifications,"Chat", Rutas.Chat.name)
    object Item_bottom_nav_pisos:Items_barra_inferior(
        Icons.Filled.List,"Mis pisos", Rutas.MisPisos.name)
    object Item_bottom_nav_perfil:Items_barra_inferior(
        Icons.Filled.Person,"Perfil", Rutas.Perfil.name)

}

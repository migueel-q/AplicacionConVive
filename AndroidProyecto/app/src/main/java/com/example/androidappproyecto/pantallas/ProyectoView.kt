package com.example.androidappproyecto.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidappproyecto.R
import com.example.androidappproyecto.data.data.modelos.Items_barra_inferior
import com.example.androidappproyecto.data.data.viewmodels.PisoViewModel
import com.example.androidappproyecto.navegacion.AppConviveNavigation
import com.example.androidappproyecto.navegacion.Rutas


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProyectoView(pisoViewModel: PisoViewModel){
    val navController= rememberNavController()
    val rutaActual = currentRoute(navController)

    val mostrarBarras = rutaActual != Rutas.Login.name

    Scaffold(
        topBar = {
            if (mostrarBarras) {
                AppConviveTopBar()
            }
        },
        bottomBar = {
            if (mostrarBarras) {
                AppConviveBottomBar(navController = navController)
            }
        }
    ) { paddingValues ->
        AppConviveNavigation(navController = navController, Modifier.padding(paddingValues),pisoViewModel)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppConviveTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "ConVive",
                style = MaterialTheme.typography.headlineLarge
            )
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.convivelogo),
                contentDescription = "Logo de ConVive",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 12.dp)
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}
@Composable
fun currentRoute(navController: NavHostController):String?=
    navController.currentBackStackEntryAsState()
        .value?.destination?.route


@Composable
private fun AppConviveBottomBar(navController: NavHostController) {
    val bar_items= listOf(
        Items_barra_inferior.Item_bottom_nav_home,
        Items_barra_inferior.Item_bottom_nav_search,
        Items_barra_inferior.Item_bottom_nav_chat,
        Items_barra_inferior.Item_bottom_nav_pisos,
        Items_barra_inferior.Item_bottom_nav_perfil
)

    NavigationBar(
        contentColor = Color(0xFF800000),
        containerColor = MaterialTheme.colorScheme.surfaceVariant

    ){
        bar_items.forEach { it ->
            val clicked = currentRoute(navController) == it.ruta
            NavigationBarItem(selected = clicked,
                onClick = { navController.navigate(it.ruta) },
                icon = { Icon(
                    imageVector = it.icono,
                    contentDescription = null,
                )
                },
                label = { Text(text=it.texto) }
            )
        }
    }
}
package com.example.androidappproyecto.pantallas

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario

import com.example.androidappproyecto.data.data.modelos.Usuario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPerfil(user: Usuario){
    val rolTexto = when (user) {
        is Propietario -> "Propietario"
        is Inquilino -> "Inquilino"
        else -> "Usuario"
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Mi Perfil", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF800000)
                )
            )
        },
        containerColor = Color(0xFFF5F5F5)
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFF800000), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = user.nombre_real.take(1).uppercase(),
                    fontSize = 48.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))


            Text(user.nombre_usuario, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(user.nombre_real, fontSize = 16.sp, color = Color.Gray)
            Text(user.email, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = rolTexto,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF800000)
                )


            Spacer(modifier = Modifier.height(22.dp))
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                colors=ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF800000)
              )
            ) {
                Text(
                  text = "Editar Perfil",
                  color = Color.White,
                  fontSize = 16.sp
              )
          }
        }
    }
}




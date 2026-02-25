package com.example.androidappproyecto.pantallas

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidappproyecto.R
import com.example.androidappproyecto.data.data.viewmodels.LoginState
import com.example.androidappproyecto.data.data.viewmodels.LoginViewModel
import com.example.androidappproyecto.navegacion.Rutas
import com.example.androidappproyecto.ui.theme.rojo

@Composable
fun PantallaLogin(
    viewModel: LoginViewModel,
    navController: NavController
) {
    // Estados para el Login simple
    var emailLogin by remember { mutableStateOf("") }
    var passwordLogin by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Estado para mostrar/ocultar el diálogo de registro
    var showRegistroDialog by remember { mutableStateOf(false) }
    val estado = viewModel.estado

    // Escuchar cambios en el estado del ViewModel para navegar
    LaunchedEffect(estado) {
        if (estado is LoginState.Success) {
            navController.navigate(Rutas.Home.name) {
                // Limpiamos el stack para que no pueda volver al login con el botón atrás
                popUpTo(Rutas.Login.name) { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.convivelogo),
                contentDescription = "Logo ConVive",
                modifier = Modifier.size(210.dp)
            )
        }
        Text(
            text = "Bienvenido a ConVive",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = rojo
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = emailLogin,
            onValueChange = { emailLogin = it },
            label = { Text("Email") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLabelColor = rojo,
                focusedIndicatorColor = rojo,
                focusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = passwordLogin,
            onValueChange = { passwordLogin = it },
            label = { Text("Contraseña") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLabelColor = rojo,
                focusedIndicatorColor = rojo,
                focusedContainerColor = Color.White
            )
        )

        // Mostrar error si los datos son incorrectos
        if (estado is LoginState.Error) {
            Text(
                text = estado.mensaje,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (emailLogin.isNotEmpty() && passwordLogin.isNotEmpty()) {
                    viewModel.login(emailLogin, passwordLogin)
                } else {
                    Toast.makeText(
                        navController.context,
                        "Por favor, rellena todos los campos",
                        Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = estado !is LoginState.Loading,
            colors = ButtonDefaults.buttonColors(
                containerColor = rojo,
                contentColor = Color.White,
            )
        ) {
            if (estado is LoginState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp), color = MaterialTheme.colorScheme.onPrimary)
            } else {
                Text("INICIAR SESIÓN")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón Registrarse (Abre el Dialog)
        OutlinedButton(
            onClick = { showRegistroDialog = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = rojo,
            )
        ) {
            Text("REGISTRARSE")
        }
    }

    // DIÁLOGO DE REGISTRO
    if (showRegistroDialog) {
        DialogRegistro(
            onDismiss = { showRegistroDialog = false },
            onConfirm = { nomUsu, nomReal, correo, pass, fecha, esProp ->
                viewModel.registrar(nomUsu, nomReal, correo, pass, fecha, esProp)
                showRegistroDialog = false
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogRegistro(
    onDismiss: () -> Unit,
    onConfirm: (String, String, String, String, String, Boolean) -> Unit
) {
    var regNombreUsuario by remember { mutableStateOf("") }
    var regNombreReal by remember { mutableStateOf("") }
    var regEmail by remember { mutableStateOf("") }
    var regPass by remember { mutableStateOf("") }
    var regFechaNac by remember { mutableStateOf("") }
    var esPropietario by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Nueva Cuenta", fontWeight = FontWeight.Bold) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(value = regNombreUsuario, onValueChange = { regNombreUsuario = it }, label = { Text("Username") },
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = rojo,
                        focusedIndicatorColor = rojo
                    ))
                OutlinedTextField(value = regNombreReal, onValueChange = { regNombreReal = it }, label = { Text("Nombre Real") },
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = rojo,
                        focusedIndicatorColor = rojo
                    ))
                OutlinedTextField(value = regEmail, onValueChange = { regEmail = it }, label = { Text("Email") },
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = rojo,
                        focusedIndicatorColor = rojo
                    ))
                OutlinedTextField(
                    value = regPass,
                    onValueChange = { regPass = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = rojo,
                        focusedIndicatorColor = rojo
                    )
                )
                OutlinedTextField(value = regFechaNac, onValueChange = { regFechaNac = it }, label = { Text("Fecha Nac (YYYY-MM-DD)") },
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = rojo,
                        focusedIndicatorColor = rojo
                    ))

                // Desplegable (Exposed Dropdown Menu)
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = if (esPropietario) "Propietario" else "Inquilino",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Tipo de usuario") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier.menuAnchor(),
                        colors = TextFieldDefaults.colors(
                            focusedLabelColor = rojo,
                            focusedIndicatorColor = rojo
                        )
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Inquilino") },
                            onClick = { esPropietario = false; expanded = false }
                        )
                        DropdownMenuItem(
                            text = { Text("Propietario") },
                            onClick = { esPropietario = true; expanded = false }
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                onConfirm(regNombreUsuario, regNombreReal, regEmail, regPass, regFechaNac, esPropietario)
            }, colors = ButtonDefaults.buttonColors(
                containerColor = rojo,
                contentColor = Color.White,
            )) {
                Text("Registrar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss, colors = ButtonDefaults.textButtonColors(contentColor = rojo)) { Text("Cancelar") }
        }
    )
}
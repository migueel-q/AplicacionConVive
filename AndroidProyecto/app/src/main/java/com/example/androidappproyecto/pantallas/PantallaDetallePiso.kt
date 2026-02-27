package com.example.androidappproyecto.pantallas

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidappproyecto.data.data.modelos.Contrato
import com.example.androidappproyecto.data.data.modelos.Inquilino
import com.example.androidappproyecto.data.data.modelos.Propietario
import com.example.androidappproyecto.data.data.viewmodels.ContratoViewModel
import com.example.androidappproyecto.data.data.viewmodels.InquilinoViewModel
import com.example.androidappproyecto.navegacion.PisoSeleccionado
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PantallaDetallePiso(
    inqLogueado: Inquilino?,
    propLogueado: Propietario?,
    viewModel: ContratoViewModel,
    inqViewModel: InquilinoViewModel,
) {

    val piso = PisoSeleccionado.piso ?: return
    val contexto = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            GlideImage(
                model = piso.url_imagen ?: "",
                contentDescription = "Foto del piso",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))
            piso.direccion?.let { dir ->
                Text(
                    text = "${dir.calle}, ${dir.ciudad} (${dir.provincia})",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(piso.precio.toString()+ "€/mes", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(piso.descripcion)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Propietario: "+ piso.propietario?.nombre_real?.uppercase())
            Spacer(modifier = Modifier.height(16.dp))
            if (inqLogueado != null) {
                Button(
                    onClick = {
                        val contr = Contrato(
                            descripcion = "Solicitud de alquiler",
                            precio = piso.precio,
                            fecha_inicio = LocalDate.now().toString(),
                            fecha_fin = LocalDate.now().plusMonths(1).toString(),
                            aceptado = false,
                            piso = piso
                        )
                        viewModel.insertarContrato(contr)
                        inqLogueado.contrato = contr
                        inqViewModel.actualizarInquilino(inqLogueado)
                        Toast.makeText(
                            contexto,
                            "Solicitud de alquiler enviada",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000))
                ) {
                    Text("Solicitar Alquiler", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = if (piso.disponible == true) "Disponible" else "No disponible",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (piso.disponible == true) Color(0xFF4CAF50) else Color.Red
                    )
                )
                if(propLogueado!=null) {
                    AssistChip(
                        onClick = { },
                        label = {
                            Text(
                                text = if (piso.validado == true) "Validado" else "No validado",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        colors = AssistChipDefaults.    assistChipColors(
                            containerColor = if (piso.validado == true) Color(0xFF2196F3) else Color.Gray
                        )
                    )
                }
            }
        }
    }
}


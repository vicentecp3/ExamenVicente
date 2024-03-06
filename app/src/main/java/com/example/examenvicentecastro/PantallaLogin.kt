package com.example.examenvicentecastro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaLogin(navController: NavController) {

    var usuario by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }
    var mostrarError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = R.drawable.logoo),
            contentDescription = "Logo de login"
        )

        TextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )

        TextField(
            value = contrasenia,
            onValueChange = { contrasenia = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        // Mensaje de error si el usuario o contraseña son incorrectas
        if (mostrarError) {
            Text(
                text = "Usuario o contraseña incorrecto",
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        }
        // Botón de inicio de sesión
        Button(
            onClick = {
                // Verificacion de identidad
                if (usuario == "usuario" && contrasenia == "1234") {
                    //si es correcto inicia sesion
                    navController.navigate("pantallaPrincipal")
                } else {
                    // si no son correctas muestra error
                    mostrarError = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text(text = "Iniciar sesión")
        }
    }
}


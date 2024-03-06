package com.example.examenvicentecastro

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "PantallaLogin"
    ) {
        composable("PantallaLogin") {
            PantallaLogin(navController = navController)
        }
        composable("pantallaPrincipal") {
            PantallaPrincipal(navController = navController)
        }
    }
}
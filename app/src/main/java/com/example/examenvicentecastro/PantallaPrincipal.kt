package com.example.examenvicentecastro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(navController: NavController) {
    var VerMenu by remember { mutableStateOf(false) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    val imageList = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                ),
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = { /* */ },
                        modifier = Modifier
                            .size(90.dp)
                            .padding(7.dp)
                    ) {
                        Row {
                            Text(text = "Material 3")
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { VerMenu = !VerMenu }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Buscar"
                        )
                    }
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Mensaje"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(top = 32.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (i in imageList.indices) {
                    Card(
                        modifier = Modifier
                            .width(320.dp)
                            .height(150.dp)
                            .padding(16.dp, 8.dp),
                        onClick = { /* Acción al hacer clic en la Card */ }
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomStart
                        ) {
                            Image(
                                painter = painterResource(id = imageList[i]),
                                contentDescription = "Imagen $i",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Elevated",
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                            IconButton(
                                onClick = {
                                    isBottomSheetVisible = true
                                },
                                modifier = Modifier
                                    .padding(8.dp)
                                    .align(Alignment.TopEnd)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.MoreVert,
                                    contentDescription = "Más opciones"
                                )
                            }
                        }
                    }
                }
            }
        }
    )

    if (isBottomSheetVisible) {
        BottomSheetScaffold(
            sheetContent = {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    onClick = {
                        isBottomSheetVisible = false
                    }
                ) {
                    Text(text = "Mensaje")
                    Text(text = " Una criptomoneda es un activo digital que emplea un cifrado criptográfico " +
                                " para garantizar su titularidad y asegurar la integridad de las transacciones, y controlar la creación de unidades adicionales")
                }
            },
            scaffoldState = rememberBottomSheetScaffoldState(),
            content = { }
        )
    }
}
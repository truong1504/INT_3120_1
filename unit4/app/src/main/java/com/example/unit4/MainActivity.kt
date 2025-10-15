package com.example.unit4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.unit4.data.Datasource
import com.example.unit4.model.Dessert
import com.example.unit4.ui.theme.DessertClickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DessertClickerTheme {
                DessertClickerApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DessertClickerApp() {
    var revenue by remember { mutableStateOf(0) }
    var dessertsSold by remember { mutableStateOf(0) }

    val desserts = remember { Datasource.desserts }
    var currentDessertIndex by remember { mutableStateOf(0) }

    val currentDessert = desserts.getOrNull(currentDessertIndex) ?: desserts.first()

    fun updateDessert() {
        val nextIndex = desserts.indexOfLast {
            dessertsSold >= it.startProductionAmount
        }.takeIf { it != -1 } ?: 0
        currentDessertIndex = nextIndex
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Dessert Clicker") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = currentDessert.imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
                    .clickable {
                        revenue += currentDessert.price
                        dessertsSold++
                        updateDessert()
                    }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text("Desserts sold: $dessertsSold")
            Text("Total revenue: $$revenue")
        }
    }
}
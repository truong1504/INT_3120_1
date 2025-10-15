package com.example.unit4.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.unit4.viewmodel.OrderViewModel

@Composable
fun CheckoutScreen(
    viewModel: OrderViewModel,
    onRestart: () -> Unit,
    onCancel: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Order Summary", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Entree: ${viewModel.entree?.name ?: "-"}")
            Text("Side: ${viewModel.side?.name ?: "-"}")
            Text("Drink: ${viewModel.accompaniment?.name ?: "-"}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Total: $${viewModel.getOrderTotal()}")
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = onCancel) { Text("Back") }
                Button(onClick = onRestart) { Text("Start Over") }
            }
        }
    }
}

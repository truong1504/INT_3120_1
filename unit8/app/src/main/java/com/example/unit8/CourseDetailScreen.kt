package com.example.unit8

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CourseDetailScreen() {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("📚 Course Detail", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Text("Learn Android development with Jetpack Compose!")
        Spacer(Modifier.height(16.dp))
        Button(onClick = {}) { Text("Enroll Now") }
    }
}

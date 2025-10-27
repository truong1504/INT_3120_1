package com.example.unit7.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit7Theme {
                ThreadExampleScreen()
            }
        }
    }
}

@Composable
fun ThreadExampleScreen() {
    var status by remember { mutableStateOf("Chưa bắt đầu") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ví dụ Coroutine trong Kotlin",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Trạng thái: $status")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            status = "Đang chạy..."
            coroutineScope.launch {
                delay(3000)
                status = "Hoàn thành sau 3 giây ✅"
            }
        }) {
            Text("Chạy Coroutine")
        }
    }
}

@Composable
fun Unit7Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = androidx.compose.ui.graphics.Color(0xFF6200EE),
            secondary = androidx.compose.ui.graphics.Color(0xFF03DAC5),
            tertiary = androidx.compose.ui.graphics.Color(0xFF018786)
        ),
        content = content
    )
}
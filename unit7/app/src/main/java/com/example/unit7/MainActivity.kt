package com.example.unit7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.unit7.ui.theme.Unit7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit7Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DownloadScreen()
                }
            }
        }
    }
}

@Composable
fun DownloadScreen() {
    var progress by remember { mutableStateOf(0) }
    var status by remember { mutableStateOf("Idle") }
    var isRunning by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Progress: $progress%", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (!isRunning) {
                    isRunning = true
                    status = "Downloading..."
                    DownloadTask(
                        onProgress = { progress = it },
                        onFinish = {
                            status = "Completed!"
                            isRunning = false
                        }
                    ).execute()
                }
            },
            enabled = !isRunning
        ) {
            Text(text = "Start Download")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = status, style = MaterialTheme.typography.bodyMedium)
    }
}

package com.example.unit7_internetconnection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.unit7_internetconnection.ui.theme.Unit7InternetTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit7InternetTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    InternetScreen()
                }
            }
        }
    }
}

@Composable
fun InternetScreen() {
    var url by remember { mutableStateOf(TextFieldValue("https://jsonplaceholder.typicode.com/posts/1")) }
    var result by remember { mutableStateOf("Chưa tải dữ liệu") }
    var loading by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "🔗 Kiểm tra kết nối Internet và tải dữ liệu", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = url.text,
            onValueChange = { url = TextFieldValue(it) },
            label = { Text("Nhập URL") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Button(onClick = {
            loading = true
            result = "Đang tải..."
            CoroutineScope(Dispatchers.IO).launch {
                val data = NetworkUtils.fetchData(url.text)
                withContext(Dispatchers.Main) {
                    result = data
                    loading = false
                }
            }
        }) {
            Text(if (loading) "Đang tải..." else "Tải dữ liệu")
        }

        Spacer(Modifier.height(16.dp))

        Text(text = result)
    }
}

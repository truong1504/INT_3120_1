package com.example.unit1   
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.unit1.ui.theme.Unit1Theme   

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyMessage()
                }
            }
        }
    }
}

@Composable
fun MyMessage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = """
                Em tên là Nguyễn Đình Trường
                Quyết tâm A+ môn Mobile
                Em xin cam kết không gian lận và tiếp tay cho gian lận,
                nếu gian lận em sẽ trượt môn
            """.trimIndent(),
            fontSize = 20.sp,
            lineHeight = 28.sp
        )
    }
}

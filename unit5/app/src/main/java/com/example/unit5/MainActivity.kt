package com.example.unit5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit5.ui.theme.Unit5Theme
import androidx.compose.foundation.layout.BoxWithConstraints

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdaptiveLayout()
                }
            }
        }
    }
}

@Composable
fun AdaptiveLayout() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // ✅ Dùng cả maxWidth và maxHeight để tránh warning
        val screenWidth = maxWidth
        val screenHeight = maxHeight

        if (screenWidth < 600.dp) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Màn hình nhỏ (Compact)\n${screenWidth.value.toInt()}dp x ${screenHeight.value.toInt()}dp",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Màn hình lớn (Expanded)\n${screenWidth.value.toInt()}dp x ${screenHeight.value.toInt()}dp",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun CompactPreview() {
    Unit5Theme {
        AdaptiveLayout()
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 1280)
@Composable
fun ExpandedPreview() {
    Unit5Theme {
        AdaptiveLayout()
    }
}

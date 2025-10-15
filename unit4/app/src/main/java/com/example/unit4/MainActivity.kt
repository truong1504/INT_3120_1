package com.example.unit4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.unit4.ui.LunchTrayApp
import com.example.unit4.ui.theme.Unit4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit4Theme {
                LunchTrayApp()
            }
        }
    }
}

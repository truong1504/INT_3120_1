package com.example.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit3.ui.theme.FlashcardLearningAppTheme

data class Flashcard(val question: String, val answer: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashcardLearningAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlashcardApp()
                }
            }
        }
    }
}

@Composable
fun FlashcardApp() {
    val flashcards = listOf(
        Flashcard("What is the capital of France?", "Paris"),
        Flashcard("What is 5 + 7?", "12"),
        Flashcard("Who developed Kotlin?", "JetBrains"),
        Flashcard("What planet is known as the Red Planet?", "Mars"),
        Flashcard("What is the chemical symbol for water?", "H₂O")
    )

    var currentIndex by remember { mutableStateOf(0) }
    var flipped by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(if (flipped) 180f else 0f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Flashcard ${currentIndex + 1}/${flashcards.size}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Thẻ Flashcard
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12 * density
                }
                .clickable { flipped = !flipped },
            colors = CardDefaults.cardColors(
                containerColor = if (flipped) Color(0xFFBBDEFB) else Color(0xFFFFF59D)
            ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val text = if (!flipped)
                    flashcards[currentIndex].question
                else
                    flashcards[currentIndex].answer

                Text(
                    text = text,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Nút điều khiển
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { flipped = !flipped }) {
                Text(if (!flipped) "Flip" else "Show Question")
            }

            Button(
                onClick = {
                    flipped = false
                    currentIndex = (currentIndex + 1) % flashcards.size
                }
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlashcardPreview() {
    FlashcardLearningAppTheme {
        FlashcardApp()
    }
}

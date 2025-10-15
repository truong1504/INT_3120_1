package com.example.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit3.ui.theme.Unit3Theme

// ------------------- DATA MODEL -------------------
data class Course(
    val name: String,
    val lessons: Int,
    val imageRes: Int
)

// ------------------- SAMPLE DATA -------------------
fun getCourses(): List<Course> {
    return listOf(
        Course("Android Basics", 8, R.drawable.ic_launcher_foreground),
        Course("Kotlin Fundamentals", 12, R.drawable.ic_launcher_foreground),
        Course("Jetpack Compose", 10, R.drawable.ic_launcher_foreground),
        Course("UI Layouts", 7, R.drawable.ic_launcher_foreground),
        Course("Data Persistence", 9, R.drawable.ic_launcher_foreground),
        Course("Networking", 5, R.drawable.ic_launcher_foreground),
        Course("Debugging", 6, R.drawable.ic_launcher_foreground),
        Course("Testing", 4, R.drawable.ic_launcher_foreground)
    )
}

// ------------------- MAIN ACTIVITY -------------------
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesGrid(getCourses())
                }
            }
        }
    }
}

// ------------------- GRID UI -------------------
@Composable
fun CoursesGrid(courses: List<Course>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 cột
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(courses) { course ->
            CourseCard(course)
        }
    }
}

// ------------------- CARD ITEM -------------------
@Composable
fun CourseCard(course: Course) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = course.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = course.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${course.lessons} lessons",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseGridPreview() {
    Unit3Theme {
        CoursesGrid(getCourses())
    }
}

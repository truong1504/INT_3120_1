package com.example.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit3.ui.theme.Unit3Theme

// ---------------------- DATA MODEL ----------------------
data class Hero(
    val name: String,
    val description: String,
    val imageRes: Int
)

// ---------------------- SAMPLE DATA ----------------------
fun getHeroes(): List<Hero> = listOf(
    Hero("Batman", "Tỷ phú Bruce Wayne chiến đấu chống tội phạm ở Gotham.", R.drawable.ic_launcher_foreground),
    Hero("Superman", "Người đàn ông thép đến từ hành tinh Krypton.", R.drawable.ic_launcher_foreground),
    Hero("Wonder Woman", "Chiến binh Amazon dũng cảm bảo vệ công lý.", R.drawable.ic_launcher_foreground),
    Hero("Flash", "Người nhanh nhất thế giới, có thể di chuyển với tốc độ ánh sáng.", R.drawable.ic_launcher_foreground),
    Hero("Aquaman", "Vua của Atlantis, có thể điều khiển sinh vật biển.", R.drawable.ic_launcher_foreground),
    Hero("Iron Man", "Thiên tài công nghệ Tony Stark với bộ giáp chiến đấu.", R.drawable.ic_launcher_foreground),
    Hero("Captain America", "Siêu chiến binh biểu tượng của nước Mỹ.", R.drawable.ic_launcher_foreground),
    Hero("Hulk", "Nhà khoa học Bruce Banner biến thành gã khổng lồ xanh khi tức giận.", R.drawable.ic_launcher_foreground)
)

// ---------------------- MAIN ACTIVITY ----------------------
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

// ---------------------- APP UI ----------------------
@Composable
fun SuperHeroesApp() {
    Scaffold(
        topBar = { SuperHeroTopAppBar() }
    ) { innerPadding ->
        HeroList(
            heroes = getHeroes(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}

// ---------------------- TOP BAR ----------------------
@Composable
fun SuperHeroTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Superheroes",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
    )
}

// ---------------------- HERO LIST ----------------------
@Composable
fun HeroList(heroes: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(heroes) { hero ->
            HeroCard(hero = hero)
        }
    }
}

// ---------------------- HERO CARD ----------------------
@Composable
fun HeroCard(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = hero.name,
                modifier = Modifier
                    .size(90.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = hero.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = hero.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroPreview() {
    Unit3Theme {
        SuperHeroesApp()
    }
}

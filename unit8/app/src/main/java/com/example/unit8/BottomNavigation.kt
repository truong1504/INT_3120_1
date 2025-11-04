package com.example.unit8

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.*

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf("home", "course", "profile")
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val current = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(
                selected = current == screen,
                onClick = { navController.navigate(screen) },
                label = { Text(screen.replaceFirstChar { it.uppercase() }) },
                icon = {}
            )
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: androidx.compose.foundation.layout.PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("course") { CourseDetailScreen() }
        composable("profile") { ProfileScreen() }
    }
}

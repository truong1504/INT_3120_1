package com.example.mymaterialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymaterialapp.ui.screens.HomeScreen
import com.example.mymaterialapp.ui.screens.ProfileScreen
import com.example.mymaterialapp.ui.theme.MyMaterialAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMaterialAppTheme {
                val navController = rememberNavController()
                var selectedItem by remember { mutableStateOf("home") }

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = selectedItem == "home",
                                onClick = {
                                    selectedItem = "home"
                                    navController.navigate("home") {
                                        popUpTo(navController.graph.findStartDestination().id)
                                        launchSingleTop = true
                                    }
                                },
                                label = { Text("Home") },
                                icon = { Icon(Icons.Default.Home, contentDescription = null) }
                            )
                            NavigationBarItem(
                                selected = selectedItem == "profile",
                                onClick = {
                                    selectedItem = "profile"
                                    navController.navigate("profile") {
                                        popUpTo(navController.graph.findStartDestination().id)
                                        launchSingleTop = true
                                    }
                                },
                                label = { Text("Profile") },
                                icon = { Icon(Icons.Default.Person, contentDescription = null) }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeScreen() }
                        composable("profile") { ProfileScreen() }
                    }
                }
            }
        }
    }
}

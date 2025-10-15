package com.example.unit4.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unit4.ui.screens.*
import com.example.unit4.viewmodel.OrderViewModel
import com.example.unit4.data.DataSource

// Các màn hình trong app
enum class Screen {
    Start,
    EntreeMenu,
    SideDishMenu,
    AccompanimentMenu,
    Checkout
}

@Composable
fun LunchTrayApp(viewModel: OrderViewModel = viewModel()) {
    var currentScreen by remember { mutableStateOf(Screen.Start) }

    when (currentScreen) {
        Screen.Start -> StartScreen(
            onNext = { currentScreen = Screen.EntreeMenu }
        )

        Screen.EntreeMenu -> EntreeMenuScreen(
            items = DataSource.entreeMenuItems,
            onItemSelected = { viewModel.setEntree(it) },
            onNext = { currentScreen = Screen.SideDishMenu },
            onCancel = { currentScreen = Screen.Start }
        )

        Screen.SideDishMenu -> SideDishMenuScreen(
            items = DataSource.sideDishMenuItems,
            onItemSelected = { viewModel.setSide(it) },
            onNext = { currentScreen = Screen.AccompanimentMenu },
            onCancel = { currentScreen = Screen.EntreeMenu }
        )

        Screen.AccompanimentMenu -> AccompanimentMenuScreen(
            items = DataSource.accompanimentMenuItems,
            onItemSelected = { viewModel.setAccompaniment(it) },
            onNext = { currentScreen = Screen.Checkout },
            onCancel = { currentScreen = Screen.SideDishMenu }
        )

        Screen.Checkout -> CheckoutScreen(
            viewModel = viewModel,
            onRestart = {
                viewModel.resetOrder()
                currentScreen = Screen.Start
            },
            onCancel = { currentScreen = Screen.AccompanimentMenu }
        )
    }
}

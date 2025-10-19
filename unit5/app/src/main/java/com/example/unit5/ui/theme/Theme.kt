package com.example.unit5.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Purple80,
    secondary = Pink80,
    tertiary = PurpleGrey80
)

private val DarkColors = darkColorScheme(
    primary = Purple40,
    secondary = Pink40,
    tertiary = PurpleGrey40
)

@Composable
fun Unit5Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}

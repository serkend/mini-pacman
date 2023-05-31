package com.development.unique_pacman.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = PacmanYellow,
    primaryVariant = PacmanWhite,
    secondary = PacmanBackground,
    secondaryVariant = PacmanMazeColor,
    background = PacmanBackground
)

private val LightColorPalette = lightColors(
    primary = PacmanYellow,
    primaryVariant = PacmanWhite,
    secondary = PacmanBackground,
    background = PacmanBackground

)

@Composable
fun SnakeGameTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = Color.Black
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
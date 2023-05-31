package com.development.unique_pacman.ui.navigation

sealed class Screen(val route: String) {
    object Board : Screen("Board")
    object FinishScreen : Screen("FinishScreen")
    object StartScreen : Screen("StartScreen")

}
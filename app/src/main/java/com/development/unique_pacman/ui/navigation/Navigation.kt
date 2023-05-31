package com.development.unique_pacman.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.development.unique_pacman.ui.screens.Board
import com.development.unique_pacman.ui.screens.StartScreen
import com.development.unique_pacman.ui.viewmodels.GameViewModel

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.StartScreen.route,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.StartScreen.route) {
            StartScreen(navController)
        }
        composable(route = Screen.Board.route) {
            Board(navController = navController)
        }
    }

}


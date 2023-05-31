package com.development.unique_pacman.ui.states

import com.development.unique_pacman.ui.entities.Pacman
import com.development.unique_pacman.ui.utils.FOOD_COUNTER

data class GameState(
    val defeated: Boolean = false,
    val redraw: Boolean = false,
    val winner:Boolean = false,
    val isStarted:Boolean = false,
    val foodCounter: Int = FOOD_COUNTER
)

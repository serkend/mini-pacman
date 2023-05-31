package com.development.unique_pacman.ui.entities

data class PacFood(
    val foodList: MutableList<PacFoodModel>
)

data class PacFoodModel(
    val xPos: Int,
    val yPos: Int,
)

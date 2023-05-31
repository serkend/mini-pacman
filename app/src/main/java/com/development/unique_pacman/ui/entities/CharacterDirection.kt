package com.development.unique_pacman.ui.entities

import androidx.compose.ui.geometry.Offset
import com.development.unique_pacman.ui.utils.DOWN_OFFSET
import com.development.unique_pacman.ui.utils.LEFT_OFFSET
import com.development.unique_pacman.ui.utils.RIGHT_OFFSET
import com.development.unique_pacman.ui.utils.TOP_OFFSET

enum class CharacterDirection(val angle: Float, val offset: Offset) {
    LEFT(180f, LEFT_OFFSET),
    RIGHT(0f, RIGHT_OFFSET),
    BOTTOM(90f, DOWN_OFFSET),
    TOP(270f, TOP_OFFSET),
}
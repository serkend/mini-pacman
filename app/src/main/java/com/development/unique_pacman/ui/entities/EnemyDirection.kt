package com.development.unique_pacman.ui.entities

import androidx.compose.ui.geometry.Offset
import com.development.unique_pacman.ui.utils.DOWN_OFFSET
import com.development.unique_pacman.ui.utils.LEFT_OFFSET
import com.development.unique_pacman.ui.utils.RIGHT_OFFSET
import com.development.unique_pacman.ui.utils.TOP_OFFSET

enum class EnemyDirection(val offset: Offset) {
    LEFT(LEFT_OFFSET),
    RIGHT(RIGHT_OFFSET),
    BOTTOM(DOWN_OFFSET),
    TOP(TOP_OFFSET),
}
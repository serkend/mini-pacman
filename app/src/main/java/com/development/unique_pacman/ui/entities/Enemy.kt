package com.development.unique_pacman.ui.entities

import androidx.compose.ui.geometry.Offset
import com.development.unique_pacman.ui.utils.DOWN_OFFSET
import com.development.unique_pacman.ui.utils.LEFT_OFFSET
import com.development.unique_pacman.ui.utils.RIGHT_OFFSET
import com.development.unique_pacman.ui.utils.TOP_OFFSET

data class Enemy(
    val x: Float,
    val y: Float,
    val enemyDirection: EnemyDirection
)
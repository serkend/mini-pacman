package com.development.unique_pacman.ui.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import com.development.unique_pacman.R
import com.development.unique_pacman.ui.MyApp
import com.development.unique_pacman.ui.entities.Enemy
import com.development.unique_pacman.ui.entities.PacFood
import com.development.unique_pacman.ui.entities.Pacman
import com.development.unique_pacman.ui.theme.PacmanMazeColor
import com.development.unique_pacman.ui.theme.PacmanYellow


fun DrawScope.drawPacman(pacman: Pacman, mouthAnimation: Float) {

    drawArc(
        color = Color.Yellow,
        startAngle = pacman.direction.angle + 45f,
        sweepAngle = mouthAnimation,
        useCenter = true,
        topLeft = Offset(
            pacman.x, pacman.y
        ),
        size = Size(
            PACMAN_SIZE, PACMAN_SIZE
        ),
        style = Fill,
    )
}

fun DrawScope.drawEnemy(enemy: Enemy ,enemyBitmap : ImageBitmap) {
    drawImage(enemyBitmap, topLeft = Offset(x = enemy.x, y = enemy.y))
//    Log.e("TAG", "drawEnemy: $enemy")
}

fun DrawScope.drawOrangeEnemy(enemy: Enemy,enemyBitmap:ImageBitmap) {
    drawImage(enemyBitmap, topLeft = Offset(x = enemy.x, y = enemy.y))
//    Log.e("TAG", "drawOrangeEnemy: $enemy")
}

fun DrawScope.drawFood(pacFood:PacFood) {
    for (food in pacFood.foodList) {
        drawOval(
            color = PacmanYellow,
            style = Fill,
            topLeft = Offset(food.xPos.toFloat(), food.yPos.toFloat()),
            size = Size(30f, 30f)
        )
    }
}

fun DrawScope.drawBoard() {
    val borderPath = Path()
    borderPath.apply {
        lineTo(size.width, 0f)
        lineTo(size.width, size.height)
        lineTo(0f, size.height)
        lineTo(0f, 0f)
    }
    drawPath(
        path = borderPath, color = Color.Blue, style = Stroke(width = 12f)
    )

    val enemySpawnPath = Path()
    enemySpawnPath.apply {
        moveTo((size.width - ENEMY_SPAWN_WIDTH) / 2f, size.height / 2f)
        lineTo((size.width + ENEMY_SPAWN_WIDTH) / 2f, size.height / 2f)
    }

    drawPath(path = enemySpawnPath, color = PacmanMazeColor, style = Stroke(12f))
//
//    for (food in pacFoodState.foodList) {
//        drawOval(
//            color = PacmanYellow,
//            style = Fill,
//            topLeft = Offset(food.xPos.toFloat(), food.yPos.toFloat()),
//            size = Size(30f, 30f)
//        )
//    }
}
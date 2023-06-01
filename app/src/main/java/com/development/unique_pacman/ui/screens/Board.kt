package com.development.unique_pacman.ui.screens

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.development.unique_pacman.R
import com.development.unique_pacman.ui.MyApp
import com.development.unique_pacman.ui.entities.*
import com.development.unique_pacman.ui.theme.PacmanYellow
import com.development.unique_pacman.ui.utils.*
import com.development.unique_pacman.ui.viewmodels.GameViewModel

@Composable
fun Board(navController: NavController) {
    val viewModel: GameViewModel = viewModel()
    val context = MyApp.context
    val orangeBM = createOrangeBM(context)
    val redBM = createRedBM(context)
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pacmanState = viewModel.pacman.collectAsState()
        val enemyState = viewModel.redEnemy.collectAsState()
        val orangeEnemyState = viewModel.orangeEnemy.collectAsState()
        val pacFood = viewModel.pacFoodState.collectAsState()
        val gameState = viewModel.gameState.collectAsState()
        if (gameState.value.defeated) {
            FinishScreen(text = stringResource(R.string.lost), navController)
        } else if (gameState.value.winner) {
            FinishScreen(text = stringResource(R.string.winner), navController)
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(COEF_RATIO_SCREEN)
            ) {
                val infiniteTransition = rememberInfiniteTransition()
                val mouthAnimation by infiniteTransition.animateFloat(
                    initialValue = 360F,
                    targetValue = 280F,
                    animationSpec = infiniteRepeatable(
                        animation = tween(250, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    )
                )
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawPacman(pacmanState.value, mouthAnimation)
                    drawBoard()
                    drawFood(pacFood.value)
                    drawEnemy(enemyState.value, redBM)
                    drawOrangeEnemy(orangeEnemyState.value, orangeBM)
                }
                //    DrawEnemy(enemyState.value)
            }
            DrawButtons { charDir ->
                viewModel.changePacmanDirection(charDir)
            }
        }
    }
}

@Composable
fun DrawButtons(onDirectionalChange: (CharacterDirection) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonBox(
            image = Icons.Default.KeyboardArrowUp,
            charDirection = CharacterDirection.TOP
        ) {
            onDirectionalChange(it)
        }
        Row {
            ButtonBox(
                image = Icons.Default.KeyboardArrowLeft,
                charDirection = CharacterDirection.LEFT
            ) {
                onDirectionalChange(it)
            }
            Spacer(modifier = Modifier.width(BUTTON_SIZE))
            ButtonBox(
                image = Icons.Default.KeyboardArrowRight,
                charDirection = CharacterDirection.RIGHT
            ) {
                onDirectionalChange(it)
            }
        }
        ButtonBox(
            image = Icons.Default.KeyboardArrowDown,
            charDirection = CharacterDirection.BOTTOM
        ) {
            onDirectionalChange(it)
        }
    }
}

@Composable
fun ButtonBox(
    image: ImageVector,
    charDirection: CharacterDirection,
    onDirectionalChange: (CharacterDirection) -> Unit
) {
    val modifier = Modifier.size(BUTTON_SIZE)
    IconButton(
        modifier = modifier.background(PacmanYellow),
        onClick = { onDirectionalChange(charDirection) }
    ) {
        Icon(imageVector = image, contentDescription = null, tint = Color.Black)
    }
}

fun createRedBM(context: Context?): ImageBitmap {

    val bmOriginal = BitmapFactory.decodeResource(
        context?.resources,
        R.drawable.enemy_red
    )
    return Bitmap.createScaledBitmap(bmOriginal, ENEMY_SIZE, ENEMY_SIZE, false).asImageBitmap()
}

fun createOrangeBM(context: Context?): ImageBitmap {
    val bmOriginal = BitmapFactory.decodeResource(
        context?.resources,
        R.drawable.orange_enemy
    )
    return Bitmap.createScaledBitmap(bmOriginal, ENEMY_SIZE, ENEMY_SIZE, false).asImageBitmap()
}

//@Composable
//fun DrawEnemy(enemy: Enemy) {
//    Image(
//        bitmap = ImageBitmap.imageResource(id = R.drawable.enemy_red),
//        modifier = Modifier
//            .size(44.dp)
//            .offset(enemy.x.dp, enemy.y.dp),
//        contentDescription = stringResource(R.string.enemy)
//    )
//}
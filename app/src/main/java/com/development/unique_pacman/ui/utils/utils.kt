package com.development.unique_pacman.ui.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

const val ENEMY_SPAWN_WIDTH = 130f

 val RIGHT_OFFSET = Offset(1f,0f)
 val LEFT_OFFSET = Offset(-1f,0f)
 val TOP_OFFSET = Offset(0f,-1f)
 val DOWN_OFFSET = Offset(0f,1f)

var SCREEN_WIDTH = Resources.getSystem().displayMetrics.widthPixels.toFloat()
var SCREEN_HEIGHT = Resources.getSystem().displayMetrics.heightPixels.toFloat()
var FOOD_COUNTER = 100

var PACMAN_SIZE = 70f
var ENEMY_SIZE = 70

val BUTTON_SIZE = 64.dp

const val initialOffsetX = 200f
const val initialOffsetY = 200f

const val DELAY = 16L

const val COEF_RATIO_SCREEN = 0.75f


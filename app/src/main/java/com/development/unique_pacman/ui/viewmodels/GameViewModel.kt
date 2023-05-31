package com.development.unique_pacman.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.development.unique_pacman.ui.entities.*
import com.development.unique_pacman.ui.states.GameState
import com.development.unique_pacman.ui.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private var _gameState = MutableStateFlow(GameState())
    val gameState = _gameState.asStateFlow()

    var pacman = MutableStateFlow(
        Pacman(
            initialOffsetX,
            initialOffsetY,
            direction = CharacterDirection.RIGHT
        )
    )
    var enemy = MutableStateFlow(
        Enemy(
            x = 1f,
            y = 1f,
            enemyDirection = EnemyDirection.RIGHT
        )
    )
    var pacFoodState = MutableStateFlow(PacFood(mutableListOf()))

    init {
        initialize()
    }

    private fun initialize() {
        initPacFoodList()
        _gameState.value = _gameState.value.copy(isStarted = true)
        move()
        moveEnemy()
    }

    private fun initPacFoodList() {
        viewModelScope.launch(Dispatchers.Default) {
            pacFoodState.value.foodList.clear()
            val list = mutableListOf<PacFoodModel>()
            for (i in 0 until FOOD_COUNTER) {
                val food = PacFoodModel(
                    xPos = Random(System.currentTimeMillis()).nextInt(
                        0,
                        (SCREEN_WIDTH - 100).toInt()
                    ),
                    yPos = Random(System.currentTimeMillis()).nextInt(
                        0,
                        (SCREEN_HEIGHT * 0.68).toInt()
                    )
                )
                list.add(food)
            }
            pacFoodState.value = pacFoodState.value.copy(foodList = list)
        }
    }

    private fun move() {
        viewModelScope.launch(Dispatchers.Default) {
            while (_gameState.value.isStarted) {
                delay(DELAY)
                checkDirection()
                checkFoodCollision()
                movePacmanOffset()
            }
        }
    }

    private fun checkDirection() {
        if (pacman.value.x == 0f) {
            changePacmanDirection(CharacterDirection.RIGHT)
        } else if (pacman.value.x == SCREEN_WIDTH - 100f) {
            changePacmanDirection(CharacterDirection.LEFT)
        }
        if (pacman.value.y == 0f) {
            changePacmanDirection(CharacterDirection.BOTTOM)
        } else if (pacman.value.y >= (SCREEN_HEIGHT * 0.65f)) {
            changePacmanDirection(CharacterDirection.TOP)
        }
    }

    private fun checkFoodCollision() {
        val foodList = pacFoodState.value.foodList
        val foodIterator = foodList.iterator()
        while (foodIterator.hasNext()) {
            val foodModel = foodIterator.next()
            if (foodModel.xPos.toFloat() in pacman.value.x..pacman.value.x + PACMAN_SIZE &&
                foodModel.yPos.toFloat() in pacman.value.y..pacman.value.y + PACMAN_SIZE
            ) {
                foodIterator.remove()
                _gameState.value =
                    _gameState.value.copy(foodCounter = _gameState.value.foodCounter - 1)
                if (_gameState.value.foodCounter == 0) {
                    winGame()
                }
            }
        }
        pacFoodState.value = pacFoodState.value.copy(foodList = foodList)
    }

    private fun winGame() {
        _gameState.value = GameState(winner = true, isStarted = false)
    }

    fun changePacmanDirection(charDir: CharacterDirection) {
        pacman.value = pacman.value.copy(direction = charDir)
    }

    private fun changeEnemyDirection(enemyDir: EnemyDirection) {
        enemy.value = enemy.value.copy(enemyDirection = enemyDir)
    }

    private fun moveEnemy() {
        viewModelScope.launch(Dispatchers.Default) {
            while (_gameState.value.isStarted) {
                delay(DELAY)
                changeEnemyDirection(EnemyDirection.RIGHT)
                while (enemy.value.x < 350f) {
                    moveEnemyOffset()
                    delay(DELAY)
                }

                changeEnemyDirection(EnemyDirection.BOTTOM)
                while (enemy.value.y < (330f)) {
                    moveEnemyOffset()
                    delay(DELAY)
                }
                changeEnemyDirection(EnemyDirection.LEFT)
                while (enemy.value.x > 20f) {
                    moveEnemyOffset()
                    delay(DELAY)
                }
                changeEnemyDirection(EnemyDirection.TOP)
                while (enemy.value.y > 20f) {
                    moveEnemyOffset()
                    delay(DELAY)
                }
            }
        }
    }

    private fun moveEnemyOffset() {
        enemy.value = enemy.value.copy(
            x = enemy.value.x + enemy.value.enemyDirection.offset.x*4,
            y = enemy.value.y + enemy.value.enemyDirection.offset.y*4,
        )
    }

    private fun checkCollision(): Boolean {
        if ((pacman.value.x in enemy.value.x..enemy.value.x + PACMAN_SIZE || pacman.value.x + PACMAN_SIZE in enemy.value.x..enemy.value.x + PACMAN_SIZE)
            && (pacman.value.y in enemy.value.y..enemy.value.y + PACMAN_SIZE || pacman.value.y + PACMAN_SIZE in enemy.value.y..enemy.value.y + PACMAN_SIZE)
        ) {
            return true
        }
        return false
    }

    private fun movePacmanOffset() {
        pacman.value = pacman.value.copy(
            x = pacman.value.x + pacman.value.direction.offset.x * 4,
            y = pacman.value.y + pacman.value.direction.offset.y * 4
        )
        if (checkCollision()) {
            _gameState.value = _gameState.value.copy(defeated = true)
        }
    }
}
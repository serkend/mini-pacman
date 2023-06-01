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
    var redEnemy = MutableStateFlow(
        Enemy(
            x = 1f,
            y = 1f,
            enemyDirection = EnemyDirection.RIGHT
        )
    )
    var orangeEnemy = MutableStateFlow(
        Enemy(
            x = 1f,
            y = 100f,
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
        moveOrangeEnemy()
    }

    private fun initPacFoodList() {
        viewModelScope.launch(Dispatchers.Default) {
            pacFoodState.value.foodList.clear()
            val list = mutableListOf<PacFoodModel>()
            repeat(FOOD_COUNTER) {
                val food = PacFoodModel(
                    xPos = Random(System.currentTimeMillis()).nextInt(
                        0,
                        (SCREEN_WIDTH - 32).toInt()
                    ),
                    yPos = Random(System.currentTimeMillis()).nextInt(
                        0,
                        (SCREEN_HEIGHT * 0.7).toInt()
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
        } else if (pacman.value.y >= (SCREEN_HEIGHT * 0.7)) {
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
        if(redEnemy.value.enemyDirection != enemyDir) {
            redEnemy.value = redEnemy.value.copy(enemyDirection = enemyDir)
        }
    }

    private fun changeOrangeEnemyDirection(enemyDir: EnemyDirection) {
        if(orangeEnemy.value.enemyDirection != enemyDir) {
            orangeEnemy.value = orangeEnemy.value.copy(enemyDirection = enemyDir)
        }
    }

    private fun moveEnemy() {
        viewModelScope.launch(Dispatchers.Default) {
            while (_gameState.value.isStarted) {
                delay(DELAY)
                changeEnemyDirection(EnemyDirection.RIGHT)
                while (redEnemy.value.x < 350f) {
                    moveEnemyOffset()
                    delay(DELAY)
                }
                changeEnemyDirection(EnemyDirection.BOTTOM)
                while (redEnemy.value.y < 330f) {
                    moveEnemyOffset()
                    delay(DELAY)
                }
                changeEnemyDirection(EnemyDirection.LEFT)
                while (redEnemy.value.x > 20f) {
                    moveEnemyOffset()
                    delay(DELAY)
                }
                changeEnemyDirection(EnemyDirection.TOP)
                while (redEnemy.value.y > 20f) {
                    moveEnemyOffset()
                    delay(DELAY)
                }
            }
        }
    }

    private fun moveOrangeEnemy() {
        viewModelScope.launch(Dispatchers.Default) {
            while (_gameState.value.isStarted) {
                delay(DELAY)
                if (orangeEnemy.value.x < pacman.value.x) {
                    changeOrangeEnemyDirection(EnemyDirection.RIGHT)
                    moveOrangeEnemyOffset()
//                    delay(DELAY)
                } else {
                    changeOrangeEnemyDirection(EnemyDirection.LEFT)
                    moveOrangeEnemyOffset()
//                    delay(DELAY)
                }

                if (orangeEnemy.value.y < pacman.value.y) {
                    changeOrangeEnemyDirection(EnemyDirection.BOTTOM)
                    moveOrangeEnemyOffset()
//                    delay(DELAY)
                } else {
                    changeOrangeEnemyDirection(EnemyDirection.TOP)
                    moveOrangeEnemyOffset()
//                    delay(DELAY)
                }
            }
        }
    }

    private fun moveEnemyOffset() {
        redEnemy.value = redEnemy.value.copy(
            x = redEnemy.value.x + redEnemy.value.enemyDirection.offset.x*4,
            y = redEnemy.value.y + redEnemy.value.enemyDirection.offset.y*4,
        )
    }

    private fun moveOrangeEnemyOffset() {
        orangeEnemy.value = orangeEnemy.value.copy(
            x = orangeEnemy.value.x + orangeEnemy.value.enemyDirection.offset.x*2,
            y = orangeEnemy.value.y + orangeEnemy.value.enemyDirection.offset.y*2,
        )
    }

    private fun checkCollision(enemy:Enemy): Boolean {
        if ((pacman.value.x in enemy.x..enemy.x + PACMAN_SIZE || pacman.value.x + PACMAN_SIZE in enemy.x..enemy.x + PACMAN_SIZE)
            && (pacman.value.y in enemy.y..enemy.y + PACMAN_SIZE || pacman.value.y + PACMAN_SIZE in enemy.y..enemy.y + PACMAN_SIZE)
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
        if (checkCollision(redEnemy.value) || checkCollision(orangeEnemy.value) ) {
            _gameState.value = _gameState.value.copy(defeated = true)
        }
    }
}
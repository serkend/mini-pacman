package com.development.unique_pacman.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010\'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f\u00a8\u00061"}, d2 = {"Lcom/development/unique_pacman/ui/viewmodels/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_gameState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/development/unique_pacman/ui/states/GameState;", "gameState", "Lkotlinx/coroutines/flow/StateFlow;", "getGameState", "()Lkotlinx/coroutines/flow/StateFlow;", "orangeEnemy", "Lcom/development/unique_pacman/ui/entities/Enemy;", "getOrangeEnemy", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setOrangeEnemy", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "pacFoodState", "Lcom/development/unique_pacman/ui/entities/PacFood;", "getPacFoodState", "setPacFoodState", "pacman", "Lcom/development/unique_pacman/ui/entities/Pacman;", "getPacman", "setPacman", "redEnemy", "getRedEnemy", "setRedEnemy", "changeEnemyDirection", "", "enemyDir", "Lcom/development/unique_pacman/ui/entities/EnemyDirection;", "changeOrangeEnemyDirection", "changePacmanDirection", "charDir", "Lcom/development/unique_pacman/ui/entities/CharacterDirection;", "checkCollision", "", "enemy", "checkDirection", "checkFoodCollision", "initPacFoodList", "initialize", "move", "moveEnemy", "moveEnemyOffset", "moveOrangeEnemy", "moveOrangeEnemyOffset", "movePacmanOffset", "winGame", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    private kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.states.GameState> _gameState;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.development.unique_pacman.ui.states.GameState> gameState = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Pacman> pacman;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Enemy> redEnemy;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Enemy> orangeEnemy;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.PacFood> pacFoodState;
    
    public GameViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.development.unique_pacman.ui.states.GameState> getGameState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Pacman> getPacman() {
        return null;
    }
    
    public final void setPacman(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Pacman> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Enemy> getRedEnemy() {
        return null;
    }
    
    public final void setRedEnemy(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Enemy> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Enemy> getOrangeEnemy() {
        return null;
    }
    
    public final void setOrangeEnemy(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.Enemy> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.PacFood> getPacFoodState() {
        return null;
    }
    
    public final void setPacFoodState(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.development.unique_pacman.ui.entities.PacFood> p0) {
    }
    
    private final void initialize() {
    }
    
    private final void initPacFoodList() {
    }
    
    private final void move() {
    }
    
    private final void checkDirection() {
    }
    
    private final void checkFoodCollision() {
    }
    
    private final void winGame() {
    }
    
    public final void changePacmanDirection(@org.jetbrains.annotations.NotNull()
    com.development.unique_pacman.ui.entities.CharacterDirection charDir) {
    }
    
    private final void changeEnemyDirection(com.development.unique_pacman.ui.entities.EnemyDirection enemyDir) {
    }
    
    private final void changeOrangeEnemyDirection(com.development.unique_pacman.ui.entities.EnemyDirection enemyDir) {
    }
    
    private final void moveEnemy() {
    }
    
    private final void moveOrangeEnemy() {
    }
    
    private final void moveEnemyOffset() {
    }
    
    private final void moveOrangeEnemyOffset() {
    }
    
    private final boolean checkCollision(com.development.unique_pacman.ui.entities.Enemy enemy) {
        return false;
    }
    
    private final void movePacmanOffset() {
    }
}
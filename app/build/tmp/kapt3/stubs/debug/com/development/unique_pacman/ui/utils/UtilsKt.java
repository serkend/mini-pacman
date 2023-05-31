package com.development.unique_pacman.ui.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\f\"\u0016\u0010\u0012\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u0019\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u001a\u0010\u0005\"\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018\"\u001a\u0010\u001e\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018\"\u0016\u0010!\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\"\u0010\u0005\"\u000e\u0010#\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"DELAY", "", "DOWN_OFFSET", "Landroidx/compose/ui/geometry/Offset;", "getDOWN_OFFSET", "()J", "J", "ENEMY_SIZE", "", "getENEMY_SIZE", "()I", "setENEMY_SIZE", "(I)V", "ENEMY_SPAWN_WIDTH", "", "FOOD_COUNTER", "getFOOD_COUNTER", "setFOOD_COUNTER", "LEFT_OFFSET", "getLEFT_OFFSET", "PACMAN_SIZE", "getPACMAN_SIZE", "()F", "setPACMAN_SIZE", "(F)V", "RIGHT_OFFSET", "getRIGHT_OFFSET", "SCREEN_HEIGHT", "getSCREEN_HEIGHT", "setSCREEN_HEIGHT", "SCREEN_WIDTH", "getSCREEN_WIDTH", "setSCREEN_WIDTH", "TOP_OFFSET", "getTOP_OFFSET", "initialOffsetX", "initialOffsetY", "app_debug"})
public final class UtilsKt {
    public static final float ENEMY_SPAWN_WIDTH = 130.0F;
    private static final long RIGHT_OFFSET = 0L;
    private static final long LEFT_OFFSET = 0L;
    private static final long TOP_OFFSET = 0L;
    private static final long DOWN_OFFSET = 0L;
    private static float SCREEN_WIDTH;
    private static float SCREEN_HEIGHT;
    private static int FOOD_COUNTER = 50;
    private static float PACMAN_SIZE = 70.0F;
    private static int ENEMY_SIZE = 70;
    public static final float initialOffsetX = 200.0F;
    public static final float initialOffsetY = 200.0F;
    public static final long DELAY = 16L;
    
    public static final long getRIGHT_OFFSET() {
        return 0L;
    }
    
    public static final long getLEFT_OFFSET() {
        return 0L;
    }
    
    public static final long getTOP_OFFSET() {
        return 0L;
    }
    
    public static final long getDOWN_OFFSET() {
        return 0L;
    }
    
    public static final float getSCREEN_WIDTH() {
        return 0.0F;
    }
    
    public static final void setSCREEN_WIDTH(float p0) {
    }
    
    public static final float getSCREEN_HEIGHT() {
        return 0.0F;
    }
    
    public static final void setSCREEN_HEIGHT(float p0) {
    }
    
    public static final int getFOOD_COUNTER() {
        return 0;
    }
    
    public static final void setFOOD_COUNTER(int p0) {
    }
    
    public static final float getPACMAN_SIZE() {
        return 0.0F;
    }
    
    public static final void setPACMAN_SIZE(float p0) {
    }
    
    public static final int getENEMY_SIZE() {
        return 0;
    }
    
    public static final void setENEMY_SIZE(int p0) {
    }
}
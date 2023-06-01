package com.development.unique_pacman.ui.screens;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a,\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u001c\u0010\u000b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0011"}, d2 = {"Board", "", "navController", "Landroidx/navigation/NavController;", "ButtonBox", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "charDirection", "Lcom/development/unique_pacman/ui/entities/CharacterDirection;", "onDirectionalChange", "Lkotlin/Function1;", "DrawButtons", "createOrangeBM", "Landroidx/compose/ui/graphics/ImageBitmap;", "context", "Landroid/content/Context;", "createRedBM", "app_debug"})
public final class BoardKt {
    
    @androidx.compose.runtime.Composable()
    public static final void Board(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DrawButtons(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.development.unique_pacman.ui.entities.CharacterDirection, kotlin.Unit> onDirectionalChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ButtonBox(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector image, @org.jetbrains.annotations.NotNull()
    com.development.unique_pacman.ui.entities.CharacterDirection charDirection, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.development.unique_pacman.ui.entities.CharacterDirection, kotlin.Unit> onDirectionalChange) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.ui.graphics.ImageBitmap createRedBM(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.ui.graphics.ImageBitmap createOrangeBM(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
}
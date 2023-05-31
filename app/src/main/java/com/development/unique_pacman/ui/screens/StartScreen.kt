package com.development.unique_pacman.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.development.unique_pacman.R
import com.development.unique_pacman.ui.navigation.Screen
import com.development.unique_pacman.ui.theme.PacmanBackground

@Composable
fun StartScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PacmanBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(modifier = Modifier.size(300.dp),painter = painterResource(id = R.drawable.img) , contentDescription = "Pacman")
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {
            navController.navigate(Screen.Board.route)
        }) {
            Text(text = "Play", modifier = Modifier.padding(20.dp), fontSize = 32.sp)
        }
    }
}
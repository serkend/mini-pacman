package com.development.unique_pacman.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.development.unique_pacman.R
import com.development.unique_pacman.ui.navigation.Screen
import com.development.unique_pacman.ui.theme.PacmanBackground
import com.development.unique_pacman.ui.theme.PacmanYellow
import com.development.unique_pacman.ui.viewmodels.GameViewModel

@Composable
fun FinishScreen(text: String, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PacmanBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text, fontSize = 32.sp, color = PacmanYellow)
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {
            navController.navigate(Screen.Board.route)
        }) {
            Text(
                text = stringResource(R.string.play),
                modifier = Modifier.padding(20.dp),
                fontSize = 32.sp
            )
        }
    }
}
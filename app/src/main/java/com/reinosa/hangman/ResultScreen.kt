package com.reinosa.hangman

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ResultScreen(navController: NavController,attempts: Int) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Congratulations!",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = if (attempts > 0) "You won!" else "You lost!",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate(Routes.GameScreen.route)}) {
                Text(text = "Play again")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate(Routes.MenuScreen.route) }) {
                Text(text = "Menu")
            }
        }
    }
}
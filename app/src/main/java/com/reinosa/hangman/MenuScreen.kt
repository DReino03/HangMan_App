package com.reinosa.hangman

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu(navController: NavController) {
    var selectedText : String by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(true) } // Set expanded to true to show dropdown initially
    val difficulty = listOf("Easy", "Normal", "Difficult", "WTF")
    Column(
        Modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .padding(100.dp)
                .size(200.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.hangmanlogo),
            contentDescription = "Dificultad"
        )

        Column(
            Modifier.fillMaxWidth()
        ) {
            Box(
                Modifier
                    .align(Alignment.CenterHorizontally)

            ) {
                OutlinedTextField(
                    label = { Text(text = "Difficulty") },
                    value = selectedText,
                    onValueChange = { selectedText = it },
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .clickable { expanded = true }
                )
                DropdownMenu(

                    expanded = expanded,
                    onDismissRequest = { expanded = false},
                    modifier = Modifier.fillMaxWidth(0.5f)) {
                    difficulty.forEach { label ->
                        DropdownMenuItem(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),

                            text = { Text(text = label,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                            ) },
                            onClick = {
                                selectedText = label
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                //navigate to game screen
                navController.navigate(Routes.GameScreen.createRoute(selectedText))

            },
            modifier = Modifier
                .padding(100.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Start")
        }

    }

}

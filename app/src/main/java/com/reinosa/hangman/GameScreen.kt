package com.reinosa.hangman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GameScreen(difficulty: String?,navController: NavController) {
    var attempts  by remember{ mutableStateOf(6)}
    var gameWord by remember{ mutableStateOf(getWord(difficulty))}
    var clickedLetter = 'a'
    var encriptedWord by remember{ mutableStateOf("")}
    var updatedWord by remember{ mutableStateOf("")}
    val padding = 50.dp
    var enabled = remember { mutableStateOf(true) }
    encriptedWord = encript(gameWord)
    updatedWord = encriptedWord
    var palabraadivinar = ""
    palabraadivinar = encriptedWord
    var showWord by remember{ mutableStateOf("")}


    println()
    print("Palabra a adivinar: $palabraadivinar")
    print("Palabra a encriptada: $encriptedWord")
    println("palabra $gameWord")
    Spacer(Modifier.size(1.dp))
        Column(
            modifier = Modifier
            .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(

                    text = showWord,
                    fontSize = 30.sp
                )
            }
            Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.hangmanlogo), contentDescription = "hang" )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val abecedario = "abcdef"
                for (i in abecedario){
                    Spacer(modifier = Modifier.width(5.dp))
                    Button(
                        onClick = {
                            clickedLetter = i.toUpperCase()
                            println(clickedLetter)
                            updatedWord = modificadorLetra(clickedLetter, gameWord, updatedWord)
                            showWord = updatedWord
                            if (clickedLetter !in gameWord.toUpperCase()) {
                                attempts--
                            }}){
                        Text(text = "$i")
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val abecedario1 = "ghijkl"
                for (i in abecedario1){
                    Spacer(modifier = Modifier.width(5.dp))
                    Button(onClick = {
                            clickedLetter = i.toUpperCase()
                            println(clickedLetter)
                            updatedWord = modificadorLetra(clickedLetter, gameWord, encriptedWord)
                            showWord = updatedWord

                        if (clickedLetter !in gameWord.toUpperCase()) {
                            attempts--
                             }
                    }) {
                        Text(text = "$i")
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val abecedario2 = "mnopqr"
                for (i in abecedario2){
                    Spacer(modifier = Modifier.width(5.dp))
                    Button(onClick = {
                        clickedLetter = i.toUpperCase()
                        println(clickedLetter)
                        updatedWord = modificadorLetra(clickedLetter, gameWord, encriptedWord)
                        showWord = updatedWord

                        if (clickedLetter !in gameWord.toUpperCase()) {
                            attempts--
                        }
                    }) {
                        Text(text = "$i")
                    }
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val abecedarioN = "stuvw"
                for (i in abecedarioN){
                    Spacer(modifier = Modifier.width(5.dp))

                    Button(onClick = {
                        clickedLetter = i.toUpperCase()
                        println(clickedLetter)
                        updatedWord = modificadorLetra(clickedLetter, gameWord, encriptedWord)
                        showWord = updatedWord

                        if (clickedLetter !in gameWord.toUpperCase()) {
                            attempts--
                        }
                    }) {
                        Text(text = "$i")
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
               ) {
                val abecedario3 = "xyz"
                for (i in abecedario3) {
                    Spacer(modifier = Modifier.width(5.dp))

                    Button(onClick = {
                        clickedLetter = i.toUpperCase()
                        println(clickedLetter)
                        enabled.value = false
                        updatedWord = modificadorLetra(clickedLetter, gameWord, updatedWord)
                        showWord = updatedWord
                        if (clickedLetter !in gameWord.toUpperCase()) {
                            attempts--
                        }
                    },
                    //enabled = enabled.value
                    ) {
                        Text(text = "$i")
                    }
                }
            }
            Spacer(modifier = Modifier.size(padding))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Attempts = $attempts",
                    fontSize = 30.sp
                )
                if (updatedWord == gameWord) {
                    navController.navigate(Routes.ResultScreen.createRoute(attempts))
                }else if (attempts == 0){
                    navController.navigate(Routes.ResultScreen.createRoute(attempts))
                }
            }}
        }


fun modificadorLetra(clickedLetter: Char, gameWord: String, updatedeWord: String): String {
    //Encripted solo barrabajar
    //Updated barrabajas y letras
    var printLetters = ""
    var word = updatedeWord
    var list = word.toCharArray()
    print("-------------ENTRA EN LA FUNCION---------------------")
    print(word)
    for (i in gameWord.indices) {
        print("-------------ITERACON DEL BUCLE---------------------")
        if (clickedLetter == gameWord[i]) {
            print("-------------LETRA CORRECTA---------------------")
            list[i] = clickedLetter
            print(list)
        }
    }

    return list.joinToString("")
}
fun getWord(difficulty: String?): String {
    var gameWord = ""
    when (difficulty) {
        "Easy" -> {
            val easyList = arrayListOf("HOLA", "COCO", "LEGO", "CARS")
            val wordSelected = easyList.random()
            gameWord = wordSelected
        }
        "Normal" -> {
            val mediumList = arrayListOf("MIRAME", "GRACIA", "CABEZA", "COCHES")
            val wordSelected = mediumList.random()
            gameWord = wordSelected

        }
        "Difficult" -> {
            val hardList = arrayListOf("COMPLEJO", "EXCELENTE", "SUSPENDIDO", "HANGMAN")
            val wordSelected = hardList.random()
            gameWord = wordSelected

        }
        "WTF" -> {
            val wtfList = arrayListOf("EXCENTRICO", "IMPERSONAL", "VISUALIZAR", "REGRESION")
            val wordSelected = wtfList.random()
            gameWord = wordSelected

        }
    }
    return gameWord
}


fun encript(gameWord: String): String {
    var encriptedWord = ""
    for (i in gameWord.indices) {
        encriptedWord += "_"
    }
    return encriptedWord
}


package com.reinosa.hangman

sealed class Routes(val route: String) {
    object SplashScreen:Routes("SplashScreen")
    object MenuScreen:Routes("MenuScreen")
    object GameScreen:Routes("GameScreen/{difficulty}"){
        fun createRoute(difficulty:String) = "GameScreen/$difficulty"
    }
    object ResultScreen:Routes("ResultScreen/{attempts}"){
        fun createRoute(attempts:Int) = "ResultScreen/$attempts"
    }
}

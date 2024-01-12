package com.reinosa.hangman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.reinosa.hangman.ui.theme.HangManTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HangManTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavegationGraph()
                }
            }
        }
    }
}
@Composable
fun NavegationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route){
        composable(route = Routes.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(route = Routes.MenuScreen.route){
            MyDropDownMenu(navController)
        }
        composable(route = Routes.GameScreen.route,
            arguments = listOf(navArgument("difficulty") { defaultValue = "" })) {
                backStackEntry -> GameScreen(backStackEntry.arguments?.getString("difficulty")?: "easy", navController = navController)

        }
        composable(route = Routes.ResultScreen.route,
            arguments = listOf(navArgument("attempts") { type = NavType.IntType; defaultValue = 0 })) {
                backStackEntry -> ResultScreen( navController = navController,backStackEntry.arguments?.getInt("attempts")?: 0)

        }
    }
}



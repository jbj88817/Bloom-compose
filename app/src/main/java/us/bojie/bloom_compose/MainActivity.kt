package us.bojie.bloom_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import us.bojie.bloom_compose.ui.LoginPage
import us.bojie.bloom_compose.ui.MainPage
import us.bojie.bloom_compose.ui.WelcomePage
import us.bojie.bloom_compose.ui.theme.*

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            BloomTheme {
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { WelcomePage(navController = navController) }
                    composable("login") { LoginPage(navController = navController) }
                    composable("main") { MainPage(navController = navController) }
                }
            }
        }
    }
}


package com.loylabs.app_with_composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.loylabs.app_with_composable.ui.navigation.AppScreens
import com.loylabs.app_with_composable.ui.navigation.EnterAnimation
import com.loylabs.app_with_composable.ui.screens.first.FirstScreen
import com.loylabs.app_with_composable.ui.screens.first.FirstScreenViewModel
import com.loylabs.app_with_composable.ui.screens.second.SecondScreen
import com.loylabs.app_with_composable.ui.screens.second.SecondScreenViewModel
import com.loylabs.app_with_composable.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    private val firstScreenViewModel: FirstScreenViewModel by viewModels()
    private val secondScreenViewModel: SecondScreenViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = AppScreens.ScreenFirst.name
                ) {
                    composable(AppScreens.ScreenFirst.name) {
                        EnterAnimation {
                            FirstScreen(navController, firstScreenViewModel)
                        }
                    }

                    composable(AppScreens.ScreenSecond.name) {
                        EnterAnimation {
                            SecondScreen(navController, secondScreenViewModel)
                        }
                    }
                }
            }
        }
    }
}
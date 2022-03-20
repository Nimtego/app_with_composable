package com.loylabs.app_with_composable.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.loylabs.app_with_composable.ui.navigation.MainNavigationComponent
import com.loylabs.app_with_composable.ui.theme.ViewModelNavigationComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ViewModelNavigationComposeTheme {
                Scaffold {
                    MainNavigationComponent(navController, it)
                }
            }
//            ComposeTheme {
//                val navController = rememberNavController()
//
//                NavHostScreen(
//                    navController = navController,
//                    screenStartDestination = ScreenFirst
//                ) {
//                    composableScreen(ScreenFirst) {
//                        EnterAnimation {
//                            FirstScreen(navController, firstScreenViewModel)
//                        }
//                    }
//
//                    composableScreen(ScreenSecond) {
//                        EnterAnimation {
//                            SecondScreen(navController, secondScreenViewModel)
//                        }
//                    }
//                }
//            }
        }
    }
}
package com.loylabs.app_with_composable.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.loylabs.app_with_composable.ui.extension.NavHostScreen

@Composable
fun MainNavigationComponent(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHostScreen(
        navController = navHostController,
        screen = FirstScreen,
        modifier = Modifier.padding(paddingValues)
    ) {
        FirstScreen.composable(this, navHostController)
        SecondScreen.composable(this, navHostController)
    }
}
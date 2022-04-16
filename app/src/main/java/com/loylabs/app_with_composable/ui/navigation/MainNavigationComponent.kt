package com.loylabs.app_with_composable.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.loylabs.app_with_composable.ui.extension.NavHostScreen
import com.loylabs.app_with_composable.ui.screens.list.ListScreen

@Composable
fun MainNavigationComponent(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHostScreen(
        navController = navHostController,
        screen = AppScreens.FirstScreen,
        modifier = Modifier.padding(paddingValues)
    ) {
        AppScreens.FirstScreen.composable(this, navHostController)
        AppScreens.SecondScreen.composable(this, navHostController)
        AppScreens.ListScreen.composable(this, navHostController)
    }
}
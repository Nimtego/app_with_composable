package com.loylabs.app_with_composable.ui.common

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.loylabs.app_with_composable.ui.navigation.AppScreens
import com.loylabs.app_with_composable.ui.screens.first.FirstScreenViewModel

@Composable
fun NavigationButton(
    navController: NavController,
    viewModel: FirstScreenViewModel,
    screen: AppScreens<*>,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            Log.i(screen.screenKey, "Navigate to screen 1")
            //viewModel.onEvent()
            navController.navigate(screen.screenKey)
        },
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "Go to ${screen.screenKey}")
    }
}
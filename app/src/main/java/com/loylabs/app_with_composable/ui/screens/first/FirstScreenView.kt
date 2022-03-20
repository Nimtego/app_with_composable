package com.loylabs.app_with_composable.ui.screens.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.loylabs.app_with_composable.ui.common.MyScreenTitle
import com.loylabs.app_with_composable.ui.common.NavigationButton
import com.loylabs.app_with_composable.ui.navigation.AppScreens
import com.loylabs.app_with_composable.ui.theme.ComposeTheme

@Composable
fun FirstScreen(navController: NavController, screen1ViewModel: FirstScreenViewModel) {

    val title = screen1ViewModel.title.collectAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.LightGray)
    ) {
        MyScreenTitle(
            title = title.value
        )
        NavigationButton(
            navController = navController,
            destination = AppScreens.ScreenSecond
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    ComposeTheme {
        val navController = rememberNavController()
        val screen1ViewModel = FirstScreenViewModel()

        FirstScreen(navController, screen1ViewModel)
    }
}
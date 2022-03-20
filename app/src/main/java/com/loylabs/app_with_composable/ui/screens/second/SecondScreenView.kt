package com.loylabs.app_with_composable.ui.screens.second

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
fun SecondScreen(navController: NavController, secondScreenViewModel: SecondScreenViewModel) {

    val title = secondScreenViewModel.title.collectAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Bottom
    ) {
        NavigationButton(
            navController,
            AppScreens.ScreenFirst)
    }
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        MyScreenTitle(title = "Screen 2")
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    ComposeTheme {
        val navController = rememberNavController()
        val secondScreenViewModel = SecondScreenViewModel()

        SecondScreen(navController, secondScreenViewModel)
    }
}
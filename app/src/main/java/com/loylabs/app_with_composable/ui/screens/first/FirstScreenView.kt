package com.loylabs.app_with_composable.ui.screens.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.loylabs.app_with_composable.ui.common.MyScreenTitle
import com.loylabs.app_with_composable.ui.common.PrimaryButton
import com.loylabs.app_with_composable.ui.navigation.MyRouteNavigator
import com.loylabs.app_with_composable.ui.screens.second.SecondScreen
import com.loylabs.app_with_composable.ui.screens.second.SecondScreenViewModel
import com.loylabs.app_with_composable.ui.theme.ComposeTheme

@Composable
fun FirstScreen(screen1ViewModel: FirstScreenViewModel) {

    val title = screen1ViewModel.title.collectAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.LightGray)
    ) {
        MyScreenTitle(
            title = title.value
        )
        PrimaryButton(
            screen1ViewModel::onEvent,
            "Test first title"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    ComposeTheme {
        val viewModel = FirstScreenViewModel(MyRouteNavigator())
        FirstScreen(viewModel)
    }
}
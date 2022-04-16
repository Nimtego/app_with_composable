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
import com.loylabs.app_with_composable.ui.base.BaseEvent
import com.loylabs.app_with_composable.ui.common.MyScreenTitle
import com.loylabs.app_with_composable.ui.common.PrimaryButton
import com.loylabs.app_with_composable.ui.navigation.MyRouteNavigator
import com.loylabs.app_with_composable.ui.theme.ComposeTheme

@Composable
fun SecondScreen(viewModel: SecondScreenViewModel) {

    val title = viewModel.title.collectAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Bottom
    ) {
        PrimaryButton(
            { viewModel.onEvent(BaseEvent.ListCompositeItem) },
            "Test second title"
        )
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
        val viewModel = SecondScreenViewModel(MyRouteNavigator())
        SecondScreen(viewModel)
    }
}
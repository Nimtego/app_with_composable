package com.loylabs.app_with_composable.ui.voyager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.loylabs.app_with_composable.ui.screens.first.FirstScreen
import com.loylabs.app_with_composable.ui.screens.first.FirstScreenViewModel

object SampleScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: SampleViewModel = hiltViewModel()
        ListContent(
            viewModel.flowCompositeItem.collectAsState(initial = emptyList()).value,
            onClick = {
                    //index -> navigator.push(AndroidDetailsScreen(index))
            }
        )
    }
}
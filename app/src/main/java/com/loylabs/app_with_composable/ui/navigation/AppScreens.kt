package com.loylabs.app_with_composable.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.loylabs.app_with_composable.ui.screens.first.FirstScreen
import com.loylabs.app_with_composable.ui.screens.first.FirstScreenViewModel
import com.loylabs.app_with_composable.ui.screens.list.ListScreen
import com.loylabs.app_with_composable.ui.screens.list.ListViewModel
import com.loylabs.app_with_composable.ui.screens.second.SecondScreen
import com.loylabs.app_with_composable.ui.screens.second.SecondScreenViewModel

sealed class AppScreens<RN : RouteNavigator> : NavRoute<RN> {

    object FirstScreen : AppScreens<FirstScreenViewModel>() {
        @Composable
        override fun viewModel(): FirstScreenViewModel = hiltViewModel()

        @Composable
        override fun Content(viewModel: FirstScreenViewModel) = FirstScreen(viewModel)
    }

    object SecondScreen : AppScreens<SecondScreenViewModel>() {
        @Composable
        override fun viewModel(): SecondScreenViewModel = hiltViewModel()

        @Composable
        override fun Content(viewModel: SecondScreenViewModel) = SecondScreen(viewModel)
    }

    object ListScreen : AppScreens<ListViewModel>() {
        @Composable
        override fun viewModel(): ListViewModel = hiltViewModel()

        @Composable
        override fun Content(viewModel: ListViewModel) = ListScreen(viewModel)
    }
}

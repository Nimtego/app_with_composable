package com.loylabs.app_with_composable.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.loylabs.app_with_composable.ui.screens.first.FirstScreen
import com.loylabs.app_with_composable.ui.screens.first.FirstScreenViewModel
import com.loylabs.app_with_composable.ui.screens.second.SecondScreen
import com.loylabs.app_with_composable.ui.screens.second.SecondScreenViewModel

//sealed class AppScreens(val name: String, val title: String) {
//    object ScreenFirst : AppScreens("First", "First screen title")
//    object ScreenSecond : AppScreens("Second", "Second screen title")
//}

sealed class AppScreens<RN : RouteNavigator>(override val screenKey: String) : NavRoute<RN> {
}
object FirstScreen : AppScreens<FirstScreenViewModel>("FirstScreenRoute") {
    @Composable
    override fun viewModel(): FirstScreenViewModel = hiltViewModel()
    @Composable
    override fun Content(viewModel: FirstScreenViewModel) = FirstScreen(viewModel)
}
object SecondScreen : AppScreens<SecondScreenViewModel>("SecondScreenRoute") {
    @Composable
    override fun viewModel(): SecondScreenViewModel = hiltViewModel()
    @Composable
    override fun Content(viewModel: SecondScreenViewModel) = SecondScreen(viewModel)
}

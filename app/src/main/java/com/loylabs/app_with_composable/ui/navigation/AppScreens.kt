package com.loylabs.app_with_composable.ui.navigation

sealed class AppScreens(val name: String, val title: String) {
    object ScreenFirst : AppScreens("First", "First screen title")
    object ScreenSecond : AppScreens("Second", "Second screen title")
}

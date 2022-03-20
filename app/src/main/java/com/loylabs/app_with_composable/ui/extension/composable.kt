package com.loylabs.app_with_composable.ui.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.loylabs.app_with_composable.ui.navigation.AppScreens

fun <S : AppScreens<*>> NavGraphBuilder.composableScreen(
    screens: S,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    this.composable(screens.screenKey, arguments, deepLinks, content)
}

@Composable
fun NavHostScreen(
    navController: NavHostController,
    screen: AppScreens<*>,
    modifier: Modifier = Modifier,
    route: String? = null,
    builder: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = screen.screenKey,
        modifier = modifier,
        route = route,
        builder = builder
    )
}

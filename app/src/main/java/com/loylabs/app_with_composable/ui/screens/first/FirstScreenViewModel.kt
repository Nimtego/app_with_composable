package com.loylabs.app_with_composable.ui.screens.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loylabs.app_with_composable.ui.navigation.RouteNavigator
import com.loylabs.app_with_composable.ui.navigation.SecondScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {

    private val _title: MutableSharedFlow<String> = MutableStateFlow("Screen first: title 0")
    val title: Flow<String> = _title

    init {
        viewModelScope.launch {
            for (i in 1..5) {
                _title.emit("Screen 1: title $i")
                delay(2000)
            }
        }
    }

    fun onEvent() {
        routeNavigator.navigateToRoute(SecondScreen)
    }
}
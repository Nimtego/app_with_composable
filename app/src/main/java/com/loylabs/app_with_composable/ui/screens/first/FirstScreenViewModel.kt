package com.loylabs.app_with_composable.ui.screens.first

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loylabs.app_with_composable.R
import com.loylabs.app_with_composable.ui.base.BaseEvent
import com.loylabs.app_with_composable.ui.base.BaseViewModel
import com.loylabs.app_with_composable.ui.navigation.AppScreens
import com.loylabs.app_with_composable.ui.navigation.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
) : BaseViewModel<BaseEvent>(), RouteNavigator by routeNavigator {

    var stateList: LazyListState? = null
    private val title: MutableSharedFlow<String> = MutableStateFlow("Screen first: title 0")
    val flowTitle: Flow<String> = title

    private val simpleItem = MutableStateFlow<List<SimpleItemModel>>(emptyList())
    val flowSimpleItem: Flow<List<SimpleItemModel>> = simpleItem

    init {
        viewModelScope.launch {
            for (i in 1..5) {
                title.emit("Screen 1: title $i")
                delay(2000)
            }
        }
        viewModelScope.launch {
            for (i in 1..20) {
                simpleItem.value = simpleItem.value + getRand()
                delay(1000)
            }
        }
    }

    override fun onEvent(event: BaseEvent) {
        when(event) {
            BaseEvent.Second -> routeNavigator.navigateToRoute(AppScreens.SecondScreen)
        }
    }

    fun getRand(): List<SimpleItemModel> {
        return listOf(SimpleItemModel(
            id = 3,
            name = "Test ${Random.nextInt(1000)}",
            description = "Description 3",
            imageRes = R.drawable.ic_launcher_background
        ))
    }
}
package com.loylabs.app_with_composable.ui.voyager

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.viewModelScope
import com.loylabs.app_with_composable.R
import com.loylabs.app_with_composable.ui.base.BaseEvent
import com.loylabs.app_with_composable.ui.base.BaseViewModel
import com.loylabs.app_with_composable.ui.navigation.AppScreens
import com.loylabs.app_with_composable.ui.navigation.RouteNavigator
import com.loylabs.app_with_composable.ui.screens.first.SimpleItemModel
import com.loylabs.app_with_composable.ui.screens.list.CompositeItem
import com.loylabs.app_with_composable.ui.screens.list.Type1Model
import com.loylabs.app_with_composable.ui.screens.list.Type2Model
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SampleViewModel @Inject constructor(
    //private val routeNavigator: RouteNavigator
) : BaseViewModel<BaseEvent>() {

    private val compositeItem = MutableStateFlow<List<CompositeItem>>(emptyList())
    val flowCompositeItem: Flow<List<CompositeItem>> = compositeItem

    init {
        viewModelScope.launch {
            for (i in 1..20) {
                compositeItem.value = compositeItem.value + getRand()
                delay(1000)
            }
        }
    }

    fun onEvent() {
        //routeNavigator.navigateToRoute(AppScreens.FirstScreen)
    }

    override fun onEvent(event: BaseEvent) {
        when(event) {
            //BaseEvent.First -> routeNavigator.navigateToRoute(AppScreens.FirstScreen)
        }
    }

    fun getRand(): List<CompositeItem> {
        return listOf(list.random())
    }

    companion object {
        val list = listOf(
            Type1Model("345hda"),
            Type2Model("F465gjhda"),
            Type1Model( "Aj678678jhda"),
            Type2Model("Kjh89890jhda")
        )
    }
}
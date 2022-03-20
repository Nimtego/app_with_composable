package com.loylabs.app_with_composable.ui.screens.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SecondScreenViewModel : ViewModel() {

    private val _title: MutableSharedFlow<String> = MutableStateFlow("Second Screen")
    val title: Flow<String> = _title
    //.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "title1")

    init {
        viewModelScope.launch {
            for (i in 1..5) {
                _title.emit("Screen 2: title $i")
                delay(2000)
            }
        }
    }
}
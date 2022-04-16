package com.loylabs.app_with_composable.ui.screens.list

import androidx.compose.runtime.Composable

data class Type1Model(
    val name: String
) : CompositeItem {
    @Composable
    override fun PrepareView() {
        Type1ItemView(this)
    }
}


package com.loylabs.app_with_composable.ui.screens.list

import androidx.compose.runtime.Composable

data class Type2Model(
    val name: String
) : CompositeItem {
    @Composable
    override fun PrepareView() {
        Type2ItemView(this)
    }
}
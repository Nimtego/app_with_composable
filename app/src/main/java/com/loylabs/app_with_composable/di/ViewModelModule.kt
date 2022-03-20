package com.loylabs.app_with_composable.di

import com.loylabs.app_with_composable.ui.navigation.MyRouteNavigator
import com.loylabs.app_with_composable.ui.navigation.RouteNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun bindRouteNavigator(): RouteNavigator = MyRouteNavigator()
}
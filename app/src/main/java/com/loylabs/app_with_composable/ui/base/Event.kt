package com.loylabs.app_with_composable.ui.base

sealed class Event
abstract class FeatureEvent : Event()

sealed class BaseEvent : FeatureEvent() {
    object First : BaseEvent()
    object Second : BaseEvent()
    object ListCompositeItem : BaseEvent()
}
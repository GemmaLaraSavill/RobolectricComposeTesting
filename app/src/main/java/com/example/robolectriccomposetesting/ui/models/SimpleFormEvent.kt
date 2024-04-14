package com.example.robolectriccomposetesting.ui.models

sealed class SimpleFormEvent {
    data class SwitchToggled(val switchOn:Boolean) : SimpleFormEvent()
}

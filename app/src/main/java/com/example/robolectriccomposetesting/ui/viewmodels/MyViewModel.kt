package com.example.robolectriccomposetesting.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.robolectriccomposetesting.ui.models.SimpleFormEvent
import com.example.robolectriccomposetesting.ui.models.SimpleFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyViewModel : ViewModel() {

    private val _formState = MutableStateFlow(SimpleFormState())
    val formState = _formState.asStateFlow()

    fun onEvent(event: SimpleFormEvent) {
        when (event) {
            is SimpleFormEvent.SwitchToggled -> {
                _formState.update {
                    it.copy(textIsVisible = event.switchOn)
                }
            }
        }
    }
}

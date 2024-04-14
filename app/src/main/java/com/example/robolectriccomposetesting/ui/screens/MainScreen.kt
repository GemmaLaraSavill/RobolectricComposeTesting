package com.example.robolectriccomposetesting.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.robolectriccomposetesting.ui.components.SimpleForm
import com.example.robolectriccomposetesting.ui.models.SimpleFormEvent
import com.example.robolectriccomposetesting.ui.models.SimpleFormState
import com.example.robolectriccomposetesting.ui.theme.RobolectricComposeTestingTheme


@Composable
fun MainScreen(formState: SimpleFormState, onEvent: (SimpleFormEvent) -> Unit) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .testTag("MyScreen")
            .fillMaxSize().padding(top = 400.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleForm(formState = formState, onEvent = onEvent)
    }
}

@PreviewLightDark
@Composable
fun PreviewMyScreenStateActive() {
    RobolectricComposeTestingTheme {
        MainScreen(SimpleFormState(true)) {}
    }
}

@PreviewLightDark
@Composable
fun PreviewMyScreenStateIdle() {
    RobolectricComposeTestingTheme {
        MainScreen(SimpleFormState(false)) {}
    }
}

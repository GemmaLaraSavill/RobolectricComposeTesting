package com.example.robolectriccomposetesting.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.robolectriccomposetesting.ui.models.SimpleFormEvent
import com.example.robolectriccomposetesting.ui.models.SimpleFormState
import com.example.robolectriccomposetesting.ui.theme.RobolectricComposeTestingTheme


@Composable
fun SimpleForm(formState: SimpleFormState, onEvent: (SimpleFormEvent) -> Unit) {
    Column(Modifier.background(MaterialTheme.colorScheme.background)) {
        Switch(
            checked = formState.textIsVisible,
            onCheckedChange = {
                onEvent(SimpleFormEvent.SwitchToggled(it))
            },
            modifier = Modifier.testTag("SimpleFormSwitch")
        )
        if (formState.textIsVisible) {
            Text(
                text = "Hello!",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .testTag("FormActiveText"),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun SimpleFormActivePreview() {
    RobolectricComposeTestingTheme {
        SimpleForm(formState = SimpleFormState(textIsVisible = true)) {}
    }
}

@Composable
@PreviewLightDark
private fun SimpleFormIdlePreview() {
    RobolectricComposeTestingTheme {
        SimpleForm(formState = SimpleFormState(textIsVisible = false)) {}
    }
}


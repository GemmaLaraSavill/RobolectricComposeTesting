package com.example.robolectriccomposetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.robolectriccomposetesting.ui.models.SimpleFormState
import com.example.robolectriccomposetesting.ui.screens.MainScreen
import com.example.robolectriccomposetesting.ui.theme.RobolectricComposeTestingTheme
import com.example.robolectriccomposetesting.ui.viewmodels.MyViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobolectricComposeTestingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val myViewModel: MyViewModel = viewModel()
                    val formState = myViewModel.formState.collectAsState().value
                    MainScreen(formState, myViewModel::onEvent)
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun PreviewMyAppInInitialState() {
    RobolectricComposeTestingTheme {
        MainScreen(SimpleFormState()) {}
    }
}

@PreviewLightDark
@Composable
fun PreviewMyAppInActiveState() {
    RobolectricComposeTestingTheme {
        MainScreen(SimpleFormState(true)) {}
    }
}
package com.example.robolectriccomposetesting.ui.screens

import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.robolectriccomposetesting.ui.components.SimpleForm
import com.example.robolectriccomposetesting.ui.viewmodels.MyViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class ExampleRobolectricTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun `when switch is on then text appears`() {

        composeTestRule.setContent {
            Surface {
                val myViewModel: MyViewModel = viewModel()
                val formState = myViewModel.formState.collectAsState().value
                SimpleForm(formState, myViewModel::onEvent)
            }
        }
        // text is not visible on screen
        composeTestRule.onNodeWithTag("FormActiveText").assertDoesNotExist()
        // switch is toggled to on
        composeTestRule.onNodeWithTag("SimpleFormSwitch").performClick()
        // text is displayed on screen
        composeTestRule.onNodeWithTag("FormActiveText").assertIsDisplayed()
    }
}

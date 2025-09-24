package com.example.mod5unittest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

@Suppress("IllegalIdentifier")
class PasswordFieldText {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPasswordFieldIsPresent() {
        composeTestRule.setContent {
            PasswordField()
        }
        composeTestRule
            .onNodeWithTag(TEST_TAG_PWD_FIELD)
            .assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(
            "Montrer le mot de passe").performClick()
        composeTestRule
            .onNodeWithTag(TEST_TAG_PWD_FIELD)
            .performTextInput("jkgsdfsdf")
        composeTestRule.onNodeWithContentDescription(
            "Masquer le mot de passe"
        ).assertIsDisplayed()
    }
}
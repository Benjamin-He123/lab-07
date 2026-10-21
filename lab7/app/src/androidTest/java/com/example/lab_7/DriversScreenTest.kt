package com.example.lab_7

import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("driversInput")
            .performTextInput("Max")

        // add race location
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Max")
            .assertExists()

        composeTestRule
            .onNodeWithTag("removeAllButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Max")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}



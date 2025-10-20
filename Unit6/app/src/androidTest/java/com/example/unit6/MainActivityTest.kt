package com.example.unit6

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEmptyEmailShowsError() {
        // Click login button without entering email
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if error message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Please enter email")))
    }

    @Test
    fun testEmptyPasswordShowsError() {
        // Enter email only
        Espresso.onView(ViewMatchers.withId(R.id.emailEditText))
            .perform(ViewActions.typeText("test@example.com"))

        // Close soft keyboard
        Espresso.closeSoftKeyboard()

        // Click login button
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if error message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Please enter password")))
    }

    @Test
    fun testSuccessfulLogin() {
        // Enter valid credentials
        Espresso.onView(ViewMatchers.withId(R.id.emailEditText))
            .perform(ViewActions.typeText("test@example.com"))

        Espresso.onView(ViewMatchers.withId(R.id.passwordEditText))
            .perform(ViewActions.typeText("password123"))

        // Close soft keyboard
        Espresso.closeSoftKeyboard()

        // Click login button
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if success message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Login successful!")))
    }

    @Test
    fun testInvalidCredentials() {
        // Enter invalid credentials
        Espresso.onView(ViewMatchers.withId(R.id.emailEditText))
            .perform(ViewActions.typeText("wrong@example.com"))

        Espresso.onView(ViewMatchers.withId(R.id.passwordEditText))
            .perform(ViewActions.typeText("wrongpassword"))

        // Close soft keyboard
        Espresso.closeSoftKeyboard()

        // Click login button
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if error message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Invalid credentials")))
    }
}
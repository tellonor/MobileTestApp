package com.example.testapp

import org.junit.runner.RunWith
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import androidx.test.rule.ActivityTestRule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.*
import androidx.test.espresso.web.webdriver.Locator

class EspressoBuildTest {
    @RunWith(AndroidJUnit4::class)
    class BuildTest{
        @Rule
        @JvmField
        var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


        @Test
        fun executeBuildTest(){
            onView(withId(R.id.button_start))
                .perform(click())

            onView(withId(R.id.userName))
                .perform(click())
                .perform(typeText("admin"))

            onView(withId(R.id.password))
                .perform(click())
                .perform(typeText("12345"))

            onView(withId(R.id.login_button))
                .perform(click())


            //onWebView().forceJavascriptEnabled()

            onWebView(withId(R.id.webView))
                .forceJavascriptEnabled()
                .withElement(findElement(Locator.NAME,"q"))
                .perform(webClick())
                .perform(webKeys("SpareBank 1"))
            Thread.sleep(3000)


        }
    }
}
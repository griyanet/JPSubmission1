package com.example.jpsubmission1.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import com.example.jpsubmission1.utils.DataDummy
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.jpsubmission1.R
import org.junit.Before
import org.junit.Test

class MovieActivityTest {

    private val dummyMovies = DataDummy.generateMovies()

    @Before
    fun setUp() {
        ActivityScenario.launch(MovieActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.fragment_movie)).check(matches(isDisplayed()))
        Thread.sleep(4000)
        onView(withId(R.id.fragment_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }
}
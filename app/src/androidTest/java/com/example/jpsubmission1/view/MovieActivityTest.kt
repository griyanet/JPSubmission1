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

    // test utk melihat apakan Recyclerview ter-display dengan baik dan scroll sampe ke list terbawah
    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
        Thread.sleep(3000)
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }
}
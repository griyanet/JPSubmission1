package com.example.jpsubmission1.view.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.jpsubmission1.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@MediumTest
@RunWith(AndroidJUnit4::class)
class TvShowsFragmentTest {

    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel()
        }

    @Test
    fun loadTvShow() {
        val tvShows = viewModel.getTvShows()
        val tvShow05 = viewModel.getTvShows()[5]
        val tvShowScenario = launchFragmentInContainer<TvShowsFragment>(Bundle(), R.style.Theme_JPSubmission1)
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
//        onView(withId(R.id.item_tv_show_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))
//        onView(withId(R.id.img_tv_show)).check(matches(isDisplayed()))
//        onView(withId(R.id.img_tv_show)).check(matches(withText("${tvShow05.image}")))
    }

    @Test
    fun testNavigationToTvShowDetailScreen() {
        val tvShow05 = viewModel.getTvShows()[5]
        val tvShowScenario = launchFragmentInContainer<TvShowsFragment>(Bundle(), R.style.Theme_JPSubmission1)
        val navController = mock(NavController::class.java)
        tvShowScenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
        Thread.sleep(3000)
        onView(withId(R.id.rv_tvShows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        Thread.sleep(3000)
        verify(navController).navigate(
            TvShowsFragmentDirections.actionTvShowsToTvShowsDetailsFragment(tvShow05)
        )
    }
}
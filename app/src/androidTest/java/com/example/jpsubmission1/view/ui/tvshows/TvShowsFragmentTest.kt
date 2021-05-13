package com.example.jpsubmission1.view.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.jpsubmission1.R
import com.example.jpsubmission1.view.ui.movies.TvShowsAdapter
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
    fun testNavigationToTvShowDetailScreen() {

        val tvShows = viewModel.getTvShows()
        val tvShow01 = viewModel.getTvShows()[0]
        val tvShowScenario = launchFragmentInContainer<TvShowsFragment>(Bundle(), R.style.Theme_JPSubmission1)
        val navController = mock(NavController::class.java)
        tvShowScenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        onView(withId(R.id.tvShow_fragment)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(4000)
        onView(withId(R.id.tvShow_fragment))
            .perform(swipeUp())
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))
            .perform(swipeUp())
            .perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                withText(tvShow01.title), click()
            ))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TvShowsAdapter.TvShowsViewHolder>(0, click()))
        Thread.sleep(4000)
        verify(navController).navigate(
            TvShowsFragmentDirections.actionTvShowsToTvShowsDetailsFragment(tvShow01)
        )
    }
}
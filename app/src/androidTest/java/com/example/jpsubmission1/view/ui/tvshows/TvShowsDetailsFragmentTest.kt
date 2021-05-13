package com.example.jpsubmission1.view.ui.tvshows

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.jpsubmission1.R
import com.example.jpsubmission1.utils.DataDummy
import org.junit.Before
import org.junit.Test

class TvShowsDetailsFragmentTest {

    private val dummyTvShows = DataDummy.generateTVShows()
    private lateinit var viewModel: TvShowDetailViewModel

    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel()
    }

    @Test
    fun testTvShowDetailScreen() {
        val dummyTvShowArgId = dummyTvShows[5].tvshowsId
        viewModel.selectedTvShow(dummyTvShowArgId)
        val tvShows = viewModel.getTvShow()
        val tvShowScenario = launchFragmentInContainer<TvShowsDetailsFragment>(bundleOf("tvShows" to tvShows))
        tvShowScenario.moveToState(Lifecycle.State.CREATED)
        onView(withId(R.id.tvShow_detail_fragment)).check(matches(withEffectiveVisibility(
            Visibility.VISIBLE)))
    }


}
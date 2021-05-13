package com.example.jpsubmission1.view.ui.tvshows

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowsViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShows = viewModel.getTvShows()
        assertNotNull(tvShows)
        assertEquals(20, tvShows.size)
    }
}
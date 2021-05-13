package com.example.jpsubmission1.view.ui.favorites

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FavoritesViewModelTest {

    private lateinit var viewModel: FavoritesViewModel

    @Before
    fun setUp() {
        viewModel = FavoritesViewModel()
    }

    @Test
    fun getFavorites() {
        val favorites = viewModel.getFavorite()
        assertNotNull(favorites)
        assertEquals(13, favorites.size)
    }
}
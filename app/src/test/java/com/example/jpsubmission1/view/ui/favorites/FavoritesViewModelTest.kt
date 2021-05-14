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
        val favorites = viewModel.getFavorites()
        assertNotNull(favorites)
        assertEquals(5, favorites.size)
    }
}
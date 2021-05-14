package com.example.jpsubmission1.view.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jpsubmission1.data.FavoritesMovie
import com.example.jpsubmission1.utils.DataDummy

class FavoriteDetailViewModel: ViewModel() {

    private lateinit var favMovieId: String

    fun selectedFavMovie(favMovieId: String) {
        this.favMovieId = favMovieId
    }

    fun getFavoriteMovies(): FavoritesMovie {
        lateinit var favMovie: FavoritesMovie
        val favMoviesCol = DataDummy.generateFavorites()
        for (FavoritesMovie in favMoviesCol) {
            if (FavoritesMovie.favMovieId == favMovieId) {
                favMovie = FavoritesMovie
            }
        }
        return favMovie
    }
}
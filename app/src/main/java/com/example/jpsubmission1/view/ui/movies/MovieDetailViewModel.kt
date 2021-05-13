package com.example.jpsubmission1.view.ui.movies

import androidx.lifecycle.ViewModel
import com.example.jpsubmission1.data.Movies
import com.example.jpsubmission1.utils.DataDummy

class MovieDetailViewModel: ViewModel() {
    private lateinit var movieId: String

    fun selectedMovie(MovieId: String) {
        this.movieId = MovieId
    }

    fun getMovies(): Movies {
        lateinit var movie: Movies
        val moviesColl = DataDummy.generateMovies()
        for (Movies in moviesColl) {
            if (Movies.movieId == movieId) {
                movie = Movies
            }
        }
        return movie
    }
}
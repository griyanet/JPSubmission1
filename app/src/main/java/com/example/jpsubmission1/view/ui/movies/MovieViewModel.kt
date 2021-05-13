package com.example.jpsubmission1.view.ui.movies

import androidx.lifecycle.ViewModel
import com.example.jpsubmission1.data.Movies
import com.example.jpsubmission1.utils.DataDummy

class MovieViewModel: ViewModel() {

    fun getMovies(): List<Movies> = DataDummy.generateMovies()

}
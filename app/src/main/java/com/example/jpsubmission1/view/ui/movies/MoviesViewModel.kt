package com.example.jpsubmission1.view.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jpsubmission1.data.Movies
import com.example.jpsubmission1.utils.DataDummy

class MoviesViewModel : ViewModel() {

    fun getMovies(): List<Movies> = DataDummy.generateMovies()
}
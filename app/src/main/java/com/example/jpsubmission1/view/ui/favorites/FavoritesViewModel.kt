package com.example.jpsubmission1.view.ui.favorites

import androidx.lifecycle.ViewModel
import com.example.jpsubmission1.data.FavoritesMovie
import com.example.jpsubmission1.data.Movies
import com.example.jpsubmission1.utils.DataDummy

class FavoritesViewModel : ViewModel() {

       fun getFavorite(): List<FavoritesMovie> = DataDummy.generateFavoriteMovies()

}


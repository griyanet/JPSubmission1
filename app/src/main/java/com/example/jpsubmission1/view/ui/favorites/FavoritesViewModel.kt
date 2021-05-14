package com.example.jpsubmission1.view.ui.favorites

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.jpsubmission1.data.FavoritesMovie
import com.example.jpsubmission1.data.Movies
import com.example.jpsubmission1.utils.DataDummy

class FavoritesViewModel : ViewModel() {

       fun getFavorites(): List<FavoritesMovie> = DataDummy.generateFavorites()
}


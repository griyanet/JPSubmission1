package com.example.jpsubmission1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavoritesMovie(
    var movieId: String,
    var original_title: String,
    var release_date: String,
    var overview: String,
    var budget: Double,
    var revenue: Double,
    var image: Int
) : Parcelable

@Parcelize
data class FavoritesTvShow(
    var tvshowsId: String,
    var title: String,
    var release_year: String,
    var overview: String,
    var image: Int
): Parcelable
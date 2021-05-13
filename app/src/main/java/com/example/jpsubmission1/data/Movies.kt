package com.example.jpsubmission1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    var movieId: String,
    var original_title: String,
    var release_date: String,
    var overview: String,
    var budget: Double,
    var revenue: Double,
    var image: Int
    ) : Parcelable


package com.example.jpsubmission1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShows(
    var tvshowsId: String,
    var title: String,
    var release_year: String,
    var overview: String,
    var image: Int
) : Parcelable

package com.example.jpsubmission1.view.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jpsubmission1.data.TvShows
import com.example.jpsubmission1.utils.DataDummy

class TvShowsViewModel : ViewModel() {

    fun getTvShows(): List<TvShows> = DataDummy.generateTVShows()
}
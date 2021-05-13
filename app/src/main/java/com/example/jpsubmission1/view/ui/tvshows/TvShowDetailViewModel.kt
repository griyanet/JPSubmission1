package com.example.jpsubmission1.view.ui.tvshows

import androidx.lifecycle.ViewModel
import com.example.jpsubmission1.data.Movies
import com.example.jpsubmission1.data.TvShows
import com.example.jpsubmission1.utils.DataDummy

class TvShowDetailViewModel: ViewModel() {

    private lateinit var tvShowId: String

    fun selectedTvShow(TvShowId: String) {
        this.tvShowId = TvShowId
    }

    fun getTvShow(): TvShows {
        lateinit var tvShow: TvShows
        val tvShowColl = DataDummy.generateTVShows()
        for (TvShows in tvShowColl) {
            if (TvShows.tvshowsId == tvShowId) {
                tvShow = TvShows
            }
        }
        return tvShow
    }
}
package com.example.jpsubmission1.view.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.jpsubmission1.databinding.FragmentTvShowsDetailsBinding

class TvShowsDetailsFragment : Fragment() {

    private lateinit var tvShowsDetailBinding: FragmentTvShowsDetailsBinding
    private val args by navArgs<TvShowsDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tvShowsDetailBinding = FragmentTvShowsDetailsBinding.inflate(layoutInflater, container, false)
        return tvShowsDetailBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowDetailViewModel::class.java]
        val tvShowId = args.tvShows.tvshowsId
        if (tvShowId != null) {
            viewModel.selectedTvShow(tvShowId)
        }
        val tvShows = viewModel.getTvShow()

        with(tvShowsDetailBinding) {
            imgTvShowsBackdrop.setImageResource(tvShows.image)
            imgTvShowsPoster.setImageResource(tvShows.image)
            tvTvShowsTitle.text = tvShows.title
            tvTvShowsReleaseYear.text = tvShows.release_year
            tvTvShowSynopsis.text = tvShows.overview
        }

    }
}
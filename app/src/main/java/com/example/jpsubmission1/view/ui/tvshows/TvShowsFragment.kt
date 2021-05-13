package com.example.jpsubmission1.view.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jpsubmission1.databinding.FragmentTvshowsBinding
import com.example.jpsubmission1.view.ui.movies.TvShowsAdapter

class TvShowsFragment : Fragment() {

    private lateinit var tvShowsBinding: FragmentTvshowsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        tvShowsBinding = FragmentTvshowsBinding.inflate(layoutInflater, container, false)
        return tvShowsBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowsViewModel::class.java]
        val tvShows = viewModel.getTvShows()

        val tvShowsAdapter = TvShowsAdapter()
        tvShowsAdapter.setTvShows(tvShows)

        with(tvShowsBinding.rvTvShows) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvShowsAdapter
        }

        tvShowsBinding.progressBar.visibility = View.GONE
    }
}
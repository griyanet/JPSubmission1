package com.example.jpsubmission1.view.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.jpsubmission1.R
import com.example.jpsubmission1.data.FavoritesMovie
import com.example.jpsubmission1.databinding.FragmentMovieDetailsBinding
import com.example.jpsubmission1.utils.snack
import com.example.jpsubmission1.view.ui.favorites.FavoritesViewModel

class MovieDetailsFragment : Fragment() {

    private lateinit var movieDetail: FragmentMovieDetailsBinding
    private val args by navArgs<MovieDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        movieDetail = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return movieDetail.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieDetailViewModel::class.java]
        val movieId = args.movies.movieId
        if (movieId != null) {
            viewModel.selectedMovie(movieId)
        }
        val movie = viewModel.getMovies()

        with(movieDetail) {
            imgBackdrop.setImageResource(movie.image)
            imgPoster.setImageResource(movie.image)
            tvMovieTitle.text = movie.original_title
            tvReleaseYear.text = movie.release_date
            tvBudget.text = movie.budget.toString()
            tvRevenue.text = movie.revenue.toString()
            tvSynopsis.text = movie.overview
        }

        movieDetail.fabFavorite.setOnClickListener {
            movieDetail.movieDetail.snack(R.string.addFavorite)
        }
    }



}
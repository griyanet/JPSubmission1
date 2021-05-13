package com.example.jpsubmission1.view.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.jpsubmission1.databinding.FragmentFavoriteDetailBinding

class FavoriteDetailFragment : Fragment() {

    private var _binding:  FragmentFavoriteDetailBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<FavoriteDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[FavoriteDetailViewModel::class.java]

        val favMovieId = args.favmovies.movieId
        if (favMovieId != null) {
            viewModel.selectedFavMovie(favMovieId)
        }
        val favMovies = viewModel.getFavoriteMovies()

        with(binding) {
            imgBackdrop.setImageResource(favMovies.image)
            imgPoster.setImageResource(favMovies.image)
            tvMovieTitle.text = favMovies.original_title
            tvReleaseYear.text = favMovies.release_date
            tvBudget.text = favMovies.budget.toString()
            tvRevenue.text = favMovies.revenue.toString()
        }
    }

}
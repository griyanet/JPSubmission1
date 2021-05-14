package com.example.jpsubmission1.view.ui.favorites

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jpsubmission1.R
import com.example.jpsubmission1.data.FavoritesMovie
import com.example.jpsubmission1.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var favBinding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favBinding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return favBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[FavoritesViewModel::class.java]
        val favMovie = viewModel.getFavorites()

        val favAdapter = FavoriteMoviesAdapter()
        favAdapter.setMovies(favMovie)

        with(favBinding.rvFavorite) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = favAdapter
        }

        favBinding.progressBar.visibility = View.GONE
    }



}
package com.example.jpsubmission1.view.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jpsubmission1.R
import com.example.jpsubmission1.data.Movies
import com.example.jpsubmission1.databinding.ItemsMovieBinding

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var listMovies = ArrayList<Movies>()

    fun setMovies(movies: List<Movies>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size

    class MoviesViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            with(binding) {
                tvTitle.text = movies.original_title
                tvMovieDate.text = movies.release_date
                tvOverview.text = movies.overview
                itemView.setOnClickListener {
                    val toMovieDetails = MoviesFragmentDirections.actionNavigationHomeToMovieDetailsFragment(movies)
                    itemView.findNavController().navigate(toMovieDetails)
                    //Toast.makeText(itemView.context, movies.original_title + "is click", Toast.LENGTH_SHORT).show()
                }
                Glide.with(itemView.context)
                    .load(movies.image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_image_error)
                    .into(imgMovie)
            }
        }
    }
}
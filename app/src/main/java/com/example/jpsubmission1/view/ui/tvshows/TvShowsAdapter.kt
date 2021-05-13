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
import com.example.jpsubmission1.data.TvShows
import com.example.jpsubmission1.databinding.ItemsMovieBinding
import com.example.jpsubmission1.databinding.ItemsTvShowsBinding
import com.example.jpsubmission1.view.ui.tvshows.TvShowsFragmentDirections

class TvShowsAdapter: RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {

    private var listTvShows = ArrayList<TvShows>()

    fun setTvShows(tvShows: List<TvShows>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val itemsTvShowsBinding = ItemsTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsTvShowsBinding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShows = listTvShows[position]
        holder.bind(tvShows)
    }

    override fun getItemCount(): Int = listTvShows.size

    class TvShowsViewHolder(private val binding: ItemsTvShowsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShows) {
            with(binding) {
                tvTvShowTitle.text = tvShows.title
                tvTvShowYear.text = tvShows.release_year
                tvTvShowsOverview.text = tvShows.overview
                itemView.setOnClickListener {
                    val toTvShowsDetails = TvShowsFragmentDirections.actionTvShowsToTvShowsDetailsFragment(tvShows)
                    itemView.findNavController().navigate(toTvShowsDetails)
//                    Toast.makeText(itemView.context, tvShows.title + "is click", Toast.LENGTH_SHORT).show()
                }
                Glide.with(itemView.context)
                    .load(tvShows.image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_image_error)
                    .into(imgTvShow)
            }
        }
    }


}
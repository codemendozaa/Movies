package com.example.movies.ui.movie.adapters.concant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.core.BaseConcatHolder
import com.example.movies.databinding.PopularMovieRowBinding
import com.example.movies.databinding.TopRatedMovieRowBinding
import com.example.movies.ui.movie.adapters.MovieAdapter

class TopReatedConcantAdapter (private val moviesAdapter: MovieAdapter):
    RecyclerView.Adapter<BaseConcatHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding =
            TopRatedMovieRowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder ->holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int =1

    private inner class ConcatViewHolder(val binding: TopRatedMovieRowBinding):
        BaseConcatHolder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter) {
            binding.rvTopRated.adapter =adapter
        }

    }
}
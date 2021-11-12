package com.example.movies.ui.movie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.core.BaseViewHolder
import com.example.movies.data.Movie
import com.example.movies.data.MovieList
import com.example.movies.databinding.MovieItemBinding

class MovieAdapter(private val movieList: List<Movie>,private val itemClickListener:OnMovieClickListener):RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener{
        fun onMovieClick(movie:Movie)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf {it != DiffUtil.DiffResult.NO_POSITION}
                ?: return@setOnClickListener
            itemClickListener.onMovieClick(movieList[position])
        }

        return holder
    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MoviesViewHolder -> holder.bind(movieList[position])
        }
    }



    override fun getItemCount(): Int =movieList.size


    private inner class MoviesViewHolder(val binding: MovieItemBinding,val contex:Context):BaseViewHolder<Movie>(binding.root){
        override fun bind(item: Movie) {
        Glide.with(contex)
            .load("https://image.tmdb.org/t/p/w500/${item.poster_path}")
            .centerCrop()
            .into(binding.imgMovies)

        }

    }
}


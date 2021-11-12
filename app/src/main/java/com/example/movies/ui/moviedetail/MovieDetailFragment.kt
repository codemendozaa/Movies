package com.example.movies.ui.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private lateinit var binding:FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentMovieDetailBinding.bind(view)
        Glide.with(requireContext())
            .load("https://image.tmdb.org/t/p/w500/${args.posterImageUrl}").centerCrop().into(binding.imgMovie)
        Glide.with(requireContext())
            .load("https://image.tmdb.org/t/p/w500/${args.backgraoundImageUrl}").centerCrop().into(binding.imgBackground)

        binding.txtDescription.text = args.overview
        binding.titleMovie.text = args.title
        binding.txtLanguaje.text = "Language ${args.language}"
        binding.txtRating.text = "${args.voteAverage}( ${args.voteCount} Reviews)"
        binding.txtRelesed.text = "Released ${args.releaseDate}"

    }
}
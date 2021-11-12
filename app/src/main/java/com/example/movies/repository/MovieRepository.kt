package com.example.movies.repository

import com.example.movies.data.MovieList

interface MovieRepository {
   suspend fun getUpComingMovies(): MovieList
   suspend fun getTopRatedMovies(): MovieList
   suspend fun getPopularMovies(): MovieList
}
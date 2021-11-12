package com.example.movies.data.remote

import com.example.movies.aplication.AppConstants
import com.example.movies.data.MovieList
import com.example.movies.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpComingMovies(): MovieList = webService.getUpComingMovies(AppConstants.API_KEY)

    suspend fun getTopReatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPoPularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)


}
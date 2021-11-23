package com.example.movies.repository

import com.example.movies.data.MovieList
import com.example.movies.data.remote.RemoteMovieDataSource


class MovieRepositoryImpl(private val dataSourceRemote: RemoteMovieDataSource) : MovieRepository {

    override suspend fun getUpComingMovies(): MovieList = dataSourceRemote.getUpComingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSourceRemote.getTopReatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSourceRemote.getPoPularMovies()

}
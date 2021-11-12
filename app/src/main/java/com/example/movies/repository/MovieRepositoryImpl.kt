package com.example.movies.repository

import com.example.movies.data.MovieList
import com.example.movies.data.remote.MovieDataSource


class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {

    override suspend fun getUpComingMovies(): MovieList = dataSource.getUpComingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopReatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPoPularMovies()

}
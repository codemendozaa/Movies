package com.example.movies.repository

import com.example.movies.core.InternetCheck
import com.example.movies.data.MovieList
import com.example.movies.data.local.LocalMovieDataSource
import com.example.movies.data.remote.RemoteMovieDataSource
import com.example.movies.data.toMovieEntity


class MovieRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getUpComingMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getUpComingMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
            }
            dataSourceLocal.getUpComingMovies()
        } else {
            dataSourceLocal.getUpComingMovies()
        }

    }

    override suspend fun getTopRatedMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getTopReatedMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("toprated"))
            }
            dataSourceLocal.getTopReatedMovies()
        } else {
            dataSourceLocal.getTopReatedMovies()
        }

    }

    override suspend fun getPopularMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getPoPularMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
            }
            dataSourceLocal.getPoPularMovies()
        } else {
            dataSourceLocal.getPoPularMovies()
        }

    }

}
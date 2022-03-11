package com.example.movies.repository

import com.example.movies.data.MovieList
import com.example.movies.data.local.LocalMovieDataSource
import com.example.movies.data.remote.RemoteMovieDataSource
import com.example.movies.data.toMovieEntity


class MovieRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getUpComingMovies(): MovieList {
        dataSourceRemote.getUpComingMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
        }
        return dataSourceLocal.getUpComingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        dataSourceRemote.getTopReatedMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("toprated"))
        }
        return dataSourceLocal.getTopReatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        dataSourceRemote.getPoPularMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
        }
        return dataSourceLocal.getPoPularMovies()
    }

}
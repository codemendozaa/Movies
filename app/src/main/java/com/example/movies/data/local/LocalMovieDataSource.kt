package com.example.movies.data.local

import com.example.movies.aplication.AppConstants
import com.example.movies.data.MovieEntity
import com.example.movies.data.MovieList
import com.example.movies.data.toMovieList

class LocalMovieDataSource(private  val movieDao: MovieDao){

    suspend fun getUpComingMovies(): MovieList {
       return movieDao.getAllMovies().filter { it.movie_type =="upcoming"}.toMovieList()
    }

    suspend fun getTopReatedMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type =="toprated"}.toMovieList()
    }

    suspend fun getPoPularMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type =="popular"}.toMovieList()
    }

    suspend fun saveMovie(movie:MovieEntity){
        movieDao.saveMovie(movie)
    }

}

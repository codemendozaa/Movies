package com.example.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.movies.core.Resource
import com.example.movies.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MovieViewModel(private val repo:MovieRepository): ViewModel() {

    fun fetchScreenMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())

        try {
            emit(Resource.Success(Triple(repo.getUpComingMovies(),repo.getTopRatedMovies(),repo.getPopularMovies())))
        }catch (e:Exception){
            emit((Resource.Failure(e)))
        }
    }


}

class MovieViewModelFactory(private val repo:MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}
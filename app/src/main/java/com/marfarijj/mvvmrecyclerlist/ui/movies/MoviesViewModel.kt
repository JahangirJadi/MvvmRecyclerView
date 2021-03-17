package com.marfarijj.mvvmrecyclerlist.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marfarijj.mvvmrecyclerlist.util.Coroutines
import com.marfarijj.mvvmrecyclerlist.data.repositories.MoviesRepository
import com.marfarijj.mvvmrecyclerlist.data.models.Movie
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private lateinit var job: Job
    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

     fun getMovies() {

        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            {
                _movies.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}
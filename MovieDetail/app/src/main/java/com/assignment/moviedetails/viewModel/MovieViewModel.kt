package com.assignment.moviedetails.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.assignment.moviedetails.api.RepositoryLayer
import com.assignment.moviedetails.data.MovieResponse
import com.assignment.moviedetails.utils.Constant
import kotlinx.coroutines.Dispatchers

class MovieViewModel constructor(private val repository: RepositoryLayer) : ViewModel() {

    var msg = MutableLiveData<String>()
    val API_KEY = "XPvxErn3AzAgApHUCErVSz672jAVdrBQ"

    fun getMovieData() = liveData(Dispatchers.IO) {
        try {
            emit(repository.getMovieData(Constant.API_KEY))
        } catch (exception: Exception) {
           exception.printStackTrace()
        }
    }
}
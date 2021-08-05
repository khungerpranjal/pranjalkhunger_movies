package com.assignment.moviedetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.moviedetails.api.ApiHelper
import com.assignment.moviedetails.api.RepositoryLayer

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(RepositoryLayer(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}
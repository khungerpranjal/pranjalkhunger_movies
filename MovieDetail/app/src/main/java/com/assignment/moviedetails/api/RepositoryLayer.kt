package com.assignment.moviedetails.api

class RepositoryLayer(private val apiHelper: ApiHelper) {

    suspend fun getMovieData(apiKey:String) = apiHelper.getMovieDetails(apiKey)
}
package com.assignment.moviedetails.api

class ApiHelper(private val apiInterface: ApiInterface) {

    suspend fun getMovieDetails(apiKey:String) = apiInterface.getMovieData(apiKey)

}
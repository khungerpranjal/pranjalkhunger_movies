package com.assignment.moviedetails.api

import com.assignment.moviedetails.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("svc/movies/v2/reviews/all.json?")
    suspend fun getMovieData(@Query("api-key")apiKey:String): Response<MovieResponse>
}
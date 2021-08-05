package com.assignment.moviedetails.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    public const val BASE_URL = "https://api.nytimes.com/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiInterface: ApiInterface = getRetrofit().create(ApiInterface::class.java)
}
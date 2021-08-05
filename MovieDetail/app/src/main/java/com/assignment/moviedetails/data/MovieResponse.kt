package com.assignment.moviedetails.data

import com.google.gson.annotations.SerializedName

data class MovieResponse(val status:String, val copyright:String, @SerializedName("has_more")val hasMore: Boolean,
                         @SerializedName("num_results")val numResults: Int, val results: List<Results>)

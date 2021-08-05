package com.assignment.moviedetails.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Link(val type: String, val url: String,@SerializedName("suggested_link_text")val suggestedLinkText: String)

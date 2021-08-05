package com.assignment.moviedetails.data

import com.google.gson.annotations.SerializedName


data class Results(@SerializedName("display_title")val displayTitle: String,
                   @SerializedName("mpaa_rating")val mpaaRating: String,
                   @SerializedName("critics_pick")val criticsPick: Int, val byline: String,
                   val headline: String, @SerializedName("summary_short")val summaryShort: String,
                   val multimedia: Multimedia, @SerializedName("publication_date")val publicationDate: String,
                   @SerializedName("opening_date")val openingDate: String,
                   @SerializedName("date_updated")val dateUpdated: String, val link: Link)



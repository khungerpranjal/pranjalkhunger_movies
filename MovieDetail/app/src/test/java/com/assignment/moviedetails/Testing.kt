package com.assignment.moviedetails

import androidx.lifecycle.liveData
import com.assignment.moviedetails.api.ApiClient
import com.assignment.moviedetails.api.ApiHelper
import com.assignment.moviedetails.api.RepositoryLayer
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Test

/*
* I don't have experience in unit testing and junit
* tried my bit
* */

class Testing {

    lateinit var repository: RepositoryLayer

    @Before
    fun beforeTest() {
        repository = RepositoryLayer(ApiHelper(ApiClient.apiInterface))
    }

    @Test
    @Throws(InterruptedException::class)
    fun checkData() {
        if(test_getData()!=null)
            print("success")
    }
    fun test_getData() = liveData(Dispatchers.IO) {
        try {
            emit(repository.getMovieData("XPvxErn3AzAgApHUCErVSz672jAVdrBQ"))
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}
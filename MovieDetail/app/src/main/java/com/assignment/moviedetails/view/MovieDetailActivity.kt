package com.assignment.moviedetails.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.assignment.moviedetails.R
import com.assignment.moviedetails.utils.Constant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieDetailActivity : AppCompatActivity() {

    lateinit var imgUrl: String
    lateinit var description: String
    lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        if(intent.extras!=null) {
            imgUrl = intent.getStringExtra(Constant.IMAGE_URL).toString()
            title = intent.getStringExtra(Constant.TITLE).toString()
            description = intent.getStringExtra(Constant.DESCRIPTION).toString()
            tv_title.text = title
            tv_description.text = description
            Glide.with(this).load(imgUrl).into(movie_image)
        }
    }


}
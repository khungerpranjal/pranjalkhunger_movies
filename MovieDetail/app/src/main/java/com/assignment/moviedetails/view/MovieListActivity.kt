package com.assignment.moviedetails.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.moviedetails.R
import com.assignment.moviedetails.api.ApiClient
import com.assignment.moviedetails.api.ApiHelper
import com.assignment.moviedetails.data.Results
import com.assignment.moviedetails.listeners.OnMovieItemClicked
import com.assignment.moviedetails.utils.Constant
import com.assignment.moviedetails.view.adapter.MovieListAdapter
import com.assignment.moviedetails.viewModel.MovieViewModel
import com.assignment.moviedetails.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_movie_list.*


class MovieListActivity: AppCompatActivity(), OnMovieItemClicked {

    private lateinit var mViewModel :MovieViewModel
    var dataList:List<Results>?=null
    lateinit var listAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        mViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiClient.apiInterface))
        ).get(MovieViewModel::class.java)
        initRecyclerView()
        setupObservers()

    }
    private fun initRecyclerView() {
        rv_movieList.layoutManager = LinearLayoutManager(this)
        rv_movieList.addItemDecoration(DividerItemDecoration(rv_movieList.context, (rv_movieList.layoutManager as LinearLayoutManager).orientation))
        listAdapter = MovieListAdapter(this,this)
        rv_movieList.adapter = listAdapter
    }

    private fun setupObservers() {
        mViewModel.getMovieData().observe(this, {
            dataList = it.body()?.results
            rv_movieList.visibility=View.VISIBLE
            progressBar.visibility = View.GONE
            it.body()?.results?.let { it1 -> listAdapter.updateList(it1) }
        })
    }

    override fun onMovieItemClicked(movieItem: Results) {
        val description = movieItem.summaryShort
        val imageUrl = movieItem.multimedia.src
        val title = movieItem.displayTitle
        val intent = Intent(this,MovieDetailActivity::class.java)
        intent.putExtra(Constant.IMAGE_URL, imageUrl)
        intent.putExtra(Constant.DESCRIPTION, description)
        intent.putExtra(Constant.TITLE, title)
        startActivity(intent)

    }
}
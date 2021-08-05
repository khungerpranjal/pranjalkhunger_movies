package com.assignment.moviedetails.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.moviedetails.R
import com.assignment.moviedetails.data.Results
import com.assignment.moviedetails.listeners.OnMovieItemClicked
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieListAdapter(var context: Context, var clickItem: OnMovieItemClicked):
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    var movieList= ArrayList<Results>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(movieList[position].multimedia.src).into(holder.itemView.img_movie)
        holder.itemView.movie_title.text = movieList[position].displayTitle
        holder.itemView.setOnClickListener(View.OnClickListener {
            clickItem.onMovieItemClicked(movieList[position])
        })
    }

    override fun getItemCount(): Int {
       return movieList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    fun updateList(list:List<Results>){
        this.movieList.clear()
        this.movieList.addAll(list)
        notifyDataSetChanged()
    }

}
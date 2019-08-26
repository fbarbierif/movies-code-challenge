package com.example.moviescodechallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescodechallenge.R
import com.example.moviescodechallenge.dto.TVShow
import com.facebook.drawee.view.SimpleDraweeView
import java.util.ArrayList

/**
 * Created by fbarbieri on 2019-08-24.
 */
internal class TVShowsAdapter(private val tvShows: ArrayList<TVShow>) : RecyclerView.Adapter<TVShowsAdapter.TVShowsViewHolder>() {

    private val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w200"

    internal class TVShowsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvName: TextView
        var tvRate: TextView
        var tvOverview: TextView
        var imageView: SimpleDraweeView

        init {
            tvName = view.findViewById(R.id.tvName)
            tvRate = view.findViewById(R.id.tvRate)
            tvOverview = view.findViewById(R.id.tvOverview)
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.tv_show_item, parent, false)
        return TVShowsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {

        holder.tvName.text = tvShows[position].name
        holder.tvRate.text = "Rating: " + tvShows[position].voteAverage
        holder.tvOverview.text = tvShows[position].overview

        val imageUrl = BASE_IMAGE_URL + tvShows[position].posterPath
        holder.imageView.setImageURI(imageUrl)

    }

    override fun getItemCount(): Int {
        return tvShows.size - 1
    }

}

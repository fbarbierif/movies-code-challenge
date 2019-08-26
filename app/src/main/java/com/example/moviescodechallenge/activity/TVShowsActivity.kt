package com.example.moviescodechallenge.activity

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescodechallenge.R
import com.example.moviescodechallenge.adapter.TVShowsAdapter
import com.example.moviescodechallenge.dto.TVShow
import com.example.moviescodechallenge.dto.Result
import com.example.moviescodechallenge.presenter.TVShowsPresenter
import com.example.moviescodechallenge.util.EndlessRecyclerViewScrollListener
import com.example.moviescodechallenge.view.TVShowsView
import java.util.ArrayList
import java.util.Objects

class TVShowsActivity : AppCompatActivity(), TVShowsView {

    internal lateinit var TVShowsPresenter: TVShowsPresenter
    private var recyclerTVShows: RecyclerView? = null
    private var TVShowsAdapter: TVShowsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var progressBar: ProgressBar? = null
    private val firstPage = 1
    private val tvShowsList = ArrayList<TVShow>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_shows)

        setupActionBar()

        progressBar = findViewById(R.id.progressBar)
        recyclerTVShows = findViewById(R.id.recyclerview_tv_shows)

        recyclerTVShows!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerTVShows!!.layoutManager = layoutManager

        val dividerItemDecoration = DividerItemDecoration(
                recyclerTVShows!!.context, DividerItemDecoration.VERTICAL)
        recyclerTVShows!!.addItemDecoration(dividerItemDecoration)

        recyclerTVShows!!.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager!!) {
            override fun onLoadMore(page: Int, totalItemsCount: Int,
                                    recyclerView: RecyclerView) {
                TVShowsPresenter.getTVShowsData(page.toString())
            }
        })

        TVShowsPresenter = TVShowsPresenter(this)
        showProgressBar()
        TVShowsPresenter.getTVShowsData(firstPage.toString())
    }

    private fun setupActionBar() {
        Objects.requireNonNull<ActionBar>(supportActionBar)
                .setTitle(R.string.tv_shows_list_activity_title)
    }

    override fun showTVShowsData(result: Result) {

        tvShowsList.addAll(result.tvShows)

        if (TVShowsAdapter == null) {
            TVShowsAdapter = TVShowsAdapter(tvShowsList)
            recyclerTVShows!!.adapter = TVShowsAdapter
        } else {
            TVShowsAdapter!!.notifyDataSetChanged()
        }

        hideProgressBar()
    }

    override fun showProgressBar() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar!!.visibility = View.GONE
    }

}

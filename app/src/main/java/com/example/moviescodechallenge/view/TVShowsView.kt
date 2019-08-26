package com.example.moviescodechallenge.view

import com.example.moviescodechallenge.dto.Result

/**
 * Created by fbarbieri on 2019-08-24.
 */
interface TVShowsView {

    fun showTVShowsData(tvShows: Result)

    fun showProgressBar()

    fun hideProgressBar()
}

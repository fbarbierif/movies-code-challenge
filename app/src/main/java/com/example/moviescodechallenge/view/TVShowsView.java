package com.example.moviescodechallenge.view;

import com.example.moviescodechallenge.dto.Result;

/**
 * Created by fbarbieri on 2019-08-24.
 */
public interface TVShowsView {

    void showTVShowsData(Result tvShows);

    void showProgressBar();

    void hideProgressBar();
}

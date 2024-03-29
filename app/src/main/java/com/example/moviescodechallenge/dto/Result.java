package com.example.moviescodechallenge.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by fbarbieri on 2019-08-25.
 */
public class Result implements Serializable {

    private final ArrayList<TVShow> results;
    private final int page;

    /**
     * @param results the movies list
     */
    public Result(final ArrayList<TVShow> results, final int page) {
        this.results = results;
        this.page = page;
    }

    public ArrayList<TVShow> getTVShows() {
        return results;
    }

    public int getPage() {
        return page;
    }
}
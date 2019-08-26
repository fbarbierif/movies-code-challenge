package com.example.moviescodechallenge.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-08-24.
 */
public class TVShow implements Serializable {

    private final String name;
    @SerializedName("vote_average")
    private final String voteAverage;
    @SerializedName("poster_path")
    private final String posterPath;
    private String overview;

    /**
     *
     * @param name the tv show name
     * @param voteAverage the tv show average
     * @param posterPath the tv show image
     * @param overview the tv show overview
     */
    public TVShow(final String name, final String voteAverage, final String posterPath,
        final String overview) {
        this.name = name;
        this.voteAverage = voteAverage;
        this.posterPath = posterPath;
        this.overview = overview;
    }

    public String getName() {
        return name;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }
}

package com.example.moviescodechallenge.service;

import com.example.moviescodechallenge.dto.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fbarbieri on 2019-08-24.
 */
public interface TVShowsService {

     String URL_MOVIES = "tv/popular";

    /**
     * @return the movies list
     */
    @GET(URL_MOVIES)
    Observable<Result> getMoviesData(@Query("api_key") String apiKey,
        @Query("language") String language, @Query("page") String page);
}

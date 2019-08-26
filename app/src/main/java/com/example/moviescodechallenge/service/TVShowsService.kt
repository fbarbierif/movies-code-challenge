package com.example.moviescodechallenge.service

import com.example.moviescodechallenge.dto.Result
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by fbarbieri on 2019-08-24.
 */
interface TVShowsService {

    /**
     * @return the movies list
     */
    @GET(URL_MOVIES)
    fun getMoviesData(@Query("api_key") apiKey: String,
                      @Query("language") language: String, @Query("page") page: String): Observable<Result>

    companion object {
        const val URL_MOVIES = "tv/popular"
    }
}

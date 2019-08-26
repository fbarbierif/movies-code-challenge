package com.example.moviescodechallenge.model

import com.example.moviescodechallenge.dto.Result
import com.example.moviescodechallenge.service.TVShowsService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by fbarbieri on 2019-08-24.
 */
class TVShowsModel {

    private val service: TVShowsService
        get() {

            val retrofitBuilder = Retrofit.Builder().baseUrl(BASE_URL)
            retrofitBuilder.addConverterFactory(GsonConverterFactory.create())
            retrofitBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            return retrofitBuilder.build().create(TVShowsService::class.java)
        }

    /**
     * Call the endpoint to retrieve the contacts list
     *
     * @return the response containing the contacts
     */
    fun getMoviesData(page: String): Observable<Result> {
        return service.getMoviesData(API_KEY, LANGUAGE, page)
    }

    companion object {

        /**
         * Factory method
         *
         * @return the model's singleton
         */
        val instance = TVShowsModel()

        private val BASE_URL = "https://api.themoviedb.org/3/"
        private val API_KEY = "5d967c7c335764f39b1efbe9c5de9760"
        private val LANGUAGE = "en-US"
    }

}

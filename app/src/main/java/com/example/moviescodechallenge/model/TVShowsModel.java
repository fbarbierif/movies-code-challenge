package com.example.moviescodechallenge.model;

import com.example.moviescodechallenge.dto.Result;
import com.example.moviescodechallenge.service.TVShowsService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by fbarbieri on 2019-08-24.
 */
public class TVShowsModel {

    private static final TVShowsModel INSTANCE = new TVShowsModel();

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "5d967c7c335764f39b1efbe9c5de9760";
    private static final String LANGUAGE = "en-US";

    /**
     * Factory method
     *
     * @return the model's singleton
     */
    public static TVShowsModel getInstance() {
        return INSTANCE;
    }

    private TVShowsService getService() {

        final Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(BASE_URL);
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return retrofitBuilder.build().create(TVShowsService.class);
    }

    /**
     * Call the endpoint to retrieve the contacts list
     *
     * @return the response containing the contacts
     */
    public Observable<Result> getMoviesData(final String page) {
        return getService().getMoviesData(API_KEY, LANGUAGE, page);
    }

}

package com.example.moviescodechallenge.presenter;

import android.util.Log;
import com.example.moviescodechallenge.dto.Result;
import com.example.moviescodechallenge.model.TVShowsModel;
import com.example.moviescodechallenge.view.TVShowsView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fbarbieri on 2019-08-24.
 */
public class TVShowsPresenter {

    final TVShowsView tvShowsView;
    private static final String REQUEST_ERROR = "Request error";

    public TVShowsPresenter(final TVShowsView view){
        tvShowsView = view;
    }

    public void getTVShowsData(final String page){

        final Observable<Result> observable = TVShowsModel.getInstance().getMoviesData(page);
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(new Subscriber<Result>() {
                @Override
                public void onCompleted() {
                    //Nothing to do
                }

                @Override
                public void onError(final Throwable e) {
                    tvShowsView.hideProgressBar();
                    Log.e(REQUEST_ERROR, e.getMessage());
                }

                @Override
                public void onNext(final Result result) {
                    if (result == null) {
                        tvShowsView.hideProgressBar();
                    } else {
                        tvShowsView.showTVShowsData(result);
                    }
                }
            });
    }
}

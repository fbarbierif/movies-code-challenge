package com.example.moviescodechallenge.presenter

import android.util.Log
import androidx.annotation.VisibleForTesting
import com.example.moviescodechallenge.dto.Result
import com.example.moviescodechallenge.model.TVShowsModel
import com.example.moviescodechallenge.view.TVShowsView
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by fbarbieri on 2019-08-24.
 */
class TVShowsPresenter(internal val tvShowsView: TVShowsView) {

    @VisibleForTesting
    fun getTVShowsData(page: String) {

        if(page.equals(FIRST_PAGE)){
            tvShowsView.showProgressBar()
        }

        val observable = TVShowsModel.instance.getMoviesData(page)
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Subscriber<Result>() {
                    override fun onCompleted() {
                        //Nothing to do
                    }

                    override fun onError(e: Throwable) {
                        tvShowsView.hideProgressBar()
                        Log.e(REQUEST_ERROR, e.message)
                    }

                    override fun onNext(result: Result?) {
                        if (result == null) {
                            tvShowsView.hideProgressBar()
                        } else {
                            tvShowsView.showTVShowsData(result)

                        }
                    }
                })
    }

    companion object {
        private val REQUEST_ERROR = "Request error"
        private val FIRST_PAGE = "1"
    }
}

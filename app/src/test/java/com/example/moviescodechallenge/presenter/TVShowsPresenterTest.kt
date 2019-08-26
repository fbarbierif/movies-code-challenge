package com.example.moviescodechallenge.presenter

import com.example.moviescodechallenge.view.TVShowsView
import org.junit.Test
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.times
import org.mockito.Mockito.verify


/**
 * Created by fbarbieri on 2019-08-26.
 */
class TVShowsPresenterTest {

    @Mock
    private val view: TVShowsView? = null
    private var presenter: TVShowsPresenter? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = view?.let { TVShowsPresenter(it) }
    }

    @Test
    @Throws(Exception::class)
    fun testShowProgressBar() {
        presenter?.getTVShowsData("1")
        verify(view, times(1))?.showProgressBar()
    }
}
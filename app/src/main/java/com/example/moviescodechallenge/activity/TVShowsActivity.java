package com.example.moviescodechallenge.activity;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moviescodechallenge.R;
import com.example.moviescodechallenge.adapter.TVShowsAdapter;
import com.example.moviescodechallenge.dto.TVShow;
import com.example.moviescodechallenge.dto.Result;
import com.example.moviescodechallenge.presenter.TVShowsPresenter;
import com.example.moviescodechallenge.util.EndlessRecyclerViewScrollListener;
import com.example.moviescodechallenge.view.TVShowsView;
import java.util.ArrayList;
import java.util.Objects;

public class TVShowsActivity extends AppCompatActivity implements TVShowsView {

    TVShowsPresenter TVShowsPresenter;
    private RecyclerView recyclerTVShows;
    private TVShowsAdapter TVShowsAdapter;
    private LinearLayoutManager layoutManager;
    private ProgressBar progressBar;
    private int firstPage = 1;
    private ArrayList<TVShow> tvShowsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);

        setupActionBar();

        progressBar = findViewById(R.id.progressBar);
        recyclerTVShows = findViewById(R.id.recyclerview_tv_shows);

        recyclerTVShows.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerTVShows.setLayoutManager(layoutManager);

        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
            recyclerTVShows.getContext(), DividerItemDecoration.VERTICAL);
        recyclerTVShows.addItemDecoration(dividerItemDecoration);

        recyclerTVShows.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(final int page, final int totalItemsCount,
                final RecyclerView recyclerView) {
                TVShowsPresenter.getTVShowsData(String.valueOf(page));
            }
        });

        TVShowsPresenter = new TVShowsPresenter(this);
        showProgressBar();
        TVShowsPresenter.getTVShowsData(String.valueOf(firstPage));
    }

    private void setupActionBar() {
        Objects.requireNonNull(getSupportActionBar())
            .setTitle(R.string.tv_shows_list_activity_title);
    }

    @Override
    public void showTVShowsData(final Result result) {

        tvShowsList.addAll(result.getTVShows());

        if(TVShowsAdapter == null){
            TVShowsAdapter = new TVShowsAdapter(tvShowsList);
            recyclerTVShows.setAdapter(TVShowsAdapter);
        } else {
            TVShowsAdapter.notifyDataSetChanged();
        }

        hideProgressBar();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

}

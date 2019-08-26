package com.example.moviescodechallenge.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moviescodechallenge.R;
import com.example.moviescodechallenge.dto.TVShow;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;

/**
 * Created by fbarbieri on 2019-08-24.
 */
public class TVShowsAdapter extends RecyclerView.Adapter<TVShowsAdapter.TVShowsViewHolder> {

    private ArrayList<TVShow> tvShows;
    private String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w200";

    static class TVShowsViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvRate;
        TextView tvOverview;
        SimpleDraweeView imageView;

        TVShowsViewHolder(final View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvRate = view.findViewById(R.id.tvRate);
            tvOverview = view.findViewById(R.id.tvOverview);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    public TVShowsAdapter(final ArrayList<TVShow> tvShows) {
        this.tvShows = tvShows;
    }

    @NonNull
    @Override
    public TVShowsViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view =  LayoutInflater.from(parent.getContext())
            .inflate(R.layout.tv_show_item, parent, false);
        return new TVShowsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TVShowsViewHolder holder, final int position) {

        holder.tvName.setText(tvShows.get(position).getName());
        holder.tvRate.setText("Rating: " + tvShows.get(position).getVoteAverage());
        holder.tvOverview.setText(tvShows.get(position).getOverview());

        final String imageUrl = BASE_IMAGE_URL + tvShows.get(position).getPosterPath();
        holder.imageView.setImageURI(imageUrl);

    }

    @Override
    public int getItemCount() {
        return tvShows.size()-1;
    }

}

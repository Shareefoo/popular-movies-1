package com.udacity.popularmovies1.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.popularmovies1.R;
import com.udacity.popularmovies1.activities.MovieDetailsActivity;
import com.udacity.popularmovies1.models.Movie;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    private Context mContext;

    public MovieAdapter(Activity context, List<Movie> movies) {
        super(context, R.layout.movie_item, movies);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Movie movie = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.movie_item, parent, false);
            viewHolder.imageViewPoster = (ImageView) convertView.findViewById(R.id.imageView_poster);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String posterUrl = "http://image.tmdb.org/t/p/w185/" + movie.posterPath;
        Picasso.get().load(posterUrl).into(viewHolder.imageViewPoster);

        viewHolder.imageViewPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MovieDetailsActivity.class);
                intent.putExtra("movie", movie);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageViewPoster;
    }

}

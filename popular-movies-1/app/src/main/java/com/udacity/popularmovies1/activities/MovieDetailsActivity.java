package com.udacity.popularmovies1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.popularmovies1.R;
import com.udacity.popularmovies1.models.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shareefoo
 */

public class MovieDetailsActivity extends AppCompatActivity {

    @BindView(R.id.imageView_poster)
    ImageView imageViewPoster;

    @BindView(R.id.textView_title)
    TextView textViewTitle;

    @BindView(R.id.textView_date)
    TextView textViewDate;

    @BindView(R.id.textView_vote)
    TextView textViewVote;

    @BindView(R.id.textView_overview)
    TextView textViewOverview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        String posterUrl = "http://image.tmdb.org/t/p/w185/" + movie.posterPath;
        String releaseDate = "(" + movie.releaseDate + ")";

        Picasso.get().load(posterUrl).into(imageViewPoster);

        textViewTitle.setText(movie.title);
        textViewDate.setText(releaseDate);
        textViewVote.setText(String.valueOf(movie.voteAverage));
        textViewOverview.setText(movie.overview);

    }

}

package com.udacity.popularmovies1.activities;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.udacity.popularmovies1.R;
import com.udacity.popularmovies1.adapters.MovieAdapter;
import com.udacity.popularmovies1.api.ApiClient;
import com.udacity.popularmovies1.api.ApiInterface;
import com.udacity.popularmovies1.app.Constants;
import com.udacity.popularmovies1.app.Utils;
import com.udacity.popularmovies1.models.Movie;
import com.udacity.popularmovies1.models.PopularMoviesResponse;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.gridView_movies)
    GridView gridViewMovies;

    private AlertDialog progressDialog;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //
        getPopularMovies(Constants.API_KEY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_popular) {
            getPopularMovies(Constants.API_KEY);
            return true;
        } else if (id == R.id.action_top) {
            getTopRatedMovies(Constants.API_KEY);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getPopularMovies(String apiKey) {
        if (Utils.isNetworkConnected(MainActivity.this)) {
            progressDialog = new SpotsDialog(MainActivity.this, "Loading...");
            progressDialog.show();
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<PopularMoviesResponse> popularMoviesResponseCall = apiService.getPopularMovies(apiKey);
            popularMoviesResponseCall.enqueue(new Callback<PopularMoviesResponse>() {
                @Override
                public void onResponse(@NonNull Call<PopularMoviesResponse> call, @NonNull Response<PopularMoviesResponse> response) {
                    Log.d(TAG, "onResponse: " + response.toString());
                    progressDialog.dismiss();

                    if (response.isSuccessful()) {

                        PopularMoviesResponse popularMoviesResponse = response.body();

                        if (popularMoviesResponse != null) {
                            List<Movie> movies = popularMoviesResponse.movies;
                            movieAdapter = new MovieAdapter(MainActivity.this, movies);
                            gridViewMovies.setAdapter(movieAdapter);
                        }

                    } else {
                        try {
                            JSONObject errorObject = new JSONObject(response.errorBody().string());
                            Log.e(TAG, "onResponse: " + errorObject.toString());
                        } catch (Exception e) {
                            Log.e(TAG, "onResponse: " + e.getMessage());
                        }
                    }

                }

                @Override
                public void onFailure(@NonNull Call<PopularMoviesResponse> call, @NonNull Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                    progressDialog.dismiss();
                }
            });
        } else {
            Toast.makeText(this, "No Internet Connection !", Toast.LENGTH_LONG).show();
        }
    }

    private void getTopRatedMovies(String apiKey) {
        if (Utils.isNetworkConnected(MainActivity.this)) {
            progressDialog = new SpotsDialog(MainActivity.this, "Loading...");
            progressDialog.show();
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<PopularMoviesResponse> popularMoviesResponseCall = apiService.getTopRatedMovies(apiKey);
            popularMoviesResponseCall.enqueue(new Callback<PopularMoviesResponse>() {
                @Override
                public void onResponse(@NonNull Call<PopularMoviesResponse> call, @NonNull Response<PopularMoviesResponse> response) {
                    Log.d(TAG, "onResponse: " + response.toString());
                    progressDialog.dismiss();

                    if (response.isSuccessful()) {

                        PopularMoviesResponse popularMoviesResponse = response.body();

                        if (popularMoviesResponse != null) {
                            List<Movie> movies = popularMoviesResponse.movies;
                            movieAdapter = new MovieAdapter(MainActivity.this, movies);
                            gridViewMovies.setAdapter(movieAdapter);
                        }

                    } else {
                        try {
                            JSONObject errorObject = new JSONObject(response.errorBody().string());
                            Log.e(TAG, "onResponse: " + errorObject.toString());
                        } catch (Exception e) {
                            Log.e(TAG, "onResponse: " + e.getMessage());
                        }
                    }

                }

                @Override
                public void onFailure(@NonNull Call<PopularMoviesResponse> call, @NonNull Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                    progressDialog.dismiss();
                }
            });
        } else {
            Toast.makeText(this, "No Internet Connection !", Toast.LENGTH_LONG).show();
        }
    }

}
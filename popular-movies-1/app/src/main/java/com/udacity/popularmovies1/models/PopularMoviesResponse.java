package com.udacity.popularmovies1.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shareefoo
 */

public class PopularMoviesResponse {

    @SerializedName("page")
    public Integer page;

    @SerializedName("total_results")
    public Integer totalResults;

    @SerializedName("total_pages")
    public Integer totalPages;

    @SerializedName("results")
    public List<Movie> movies = null;

}

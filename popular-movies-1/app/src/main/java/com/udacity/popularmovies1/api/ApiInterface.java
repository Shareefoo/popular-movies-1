package com.udacity.popularmovies1.api;

import com.udacity.popularmovies1.models.PopularMoviesResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shareefoo
 */

public interface ApiInterface {

    @GET("popular")
    Call<PopularMoviesResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("top_rated")
    Call<PopularMoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

}
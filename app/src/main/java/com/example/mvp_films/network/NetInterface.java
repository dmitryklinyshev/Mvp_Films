package com.example.mvp_films.network;

import com.example.mvp_films.model.MovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetInterface {

    @GET("discover/movie")
    Observable<MovieResponse> getFilms(@Query("api_key") String api_key);

    @GET("search/movie")
    Observable<MovieResponse> getMoviesBasedOnQuery(@Query("api_key") String api_key, @Query("query") String q);
}



package com.example.mvp_films.ui;

import com.example.mvp_films.model.MovieResponse;

public interface MainContract {

    void showToast(String s);

    void displayMovies(MovieResponse movieResponse);

    void displayError(String e);
}

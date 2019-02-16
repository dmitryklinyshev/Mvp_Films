package com.example.mvp_films.search;

import com.example.mvp_films.model.MovieResponse;

public interface SearchViewInterface {

    void showToast(String str);
    void displayResult(MovieResponse movieResponse);
    void displayError(String s);
}
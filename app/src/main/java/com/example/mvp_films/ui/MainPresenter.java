package com.example.mvp_films.ui;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.mvp_films.model.MovieResponse;
import com.example.mvp_films.network.NetInterface;
import com.example.mvp_films.network.NetworkClient;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static android.support.constraint.Constraints.TAG;

public class MainPresenter implements MainPresenterInterface {

    MainContract mC;

    public MainPresenter(MainContract mC) {
        this.mC = mC;
    }


    @Override
    public void getFilms() {
        getObservable().subscribeWith(getObserver());

    }

    public Observable<MovieResponse> getObservable() {
        return NetworkClient.getRetrofit().create(NetInterface.class)
                .getFilms("004cbaf19212094e32aa9ef6f6577f22")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<MovieResponse> getObserver() {
        return new DisposableObserver<MovieResponse>() {
            @Override
            public void onNext(MovieResponse movieResponse) {
                Log.d(TAG, "OnNext" + movieResponse.getTotalResults());
                mC.displayMovies(movieResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error" + e);
                e.printStackTrace();
                mC.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}

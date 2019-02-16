package com.example.mvp_films.adapters;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp_films.R;

import com.example.mvp_films.model.Result;

import java.util.List;


public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsHolder>  {

    private final List<Result> filmsList;
    Context context;

    public FilmsAdapter(List<Result> resultList, Context context){
        this.filmsList = resultList;
        this.context = context;
    }


    @Override
    public FilmsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_movies,parent,false);
        FilmsHolder fh = new FilmsHolder(v);
        return fh;
    }


    @Override
    public void onBindViewHolder(FilmsHolder holder, int position) {
        holder.tvTitle.setText(filmsList.get(position).getTitle());
        holder.tvOverview.setText(filmsList.get(position).getOverview());
        holder.tvReleaseDate.setText(filmsList.get(position).getReleaseDate());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+filmsList.get(position).getPosterPath()).into(holder.ivMovie);

    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }



    public class FilmsHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitle,tvOverview,tvReleaseDate;
        ImageView ivMovie;

        public FilmsHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvOverview = v.findViewById(R.id.tvOverView);
            tvReleaseDate =  v.findViewById(R.id.tvReleaseDate);
            ivMovie =  v.findViewById(R.id.ivMovie);
        }
    }

}

package com.dehaat.dehaatassignment.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>{

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder{

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

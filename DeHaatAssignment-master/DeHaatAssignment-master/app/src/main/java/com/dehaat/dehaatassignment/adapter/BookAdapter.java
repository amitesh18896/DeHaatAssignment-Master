package com.dehaat.dehaatassignment.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksViewHolder>{

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BooksViewHolder extends RecyclerView.ViewHolder{

        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

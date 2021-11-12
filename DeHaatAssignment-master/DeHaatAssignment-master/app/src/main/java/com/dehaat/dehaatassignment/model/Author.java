package com.dehaat.dehaatassignment.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.dehaat.dehaatassignment.model.convertor.BooksTypeConverters;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "author")
public class Author {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;

    @SerializedName("author_name")
    private String author_name;

    @SerializedName("author_bio")
    private String author_bio;

    @SerializedName("books")
    @TypeConverters(BooksTypeConverters.class)
    private List<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_bio() {
        return author_bio;
    }

    public void setAuthor_bio(String author_bio) {
        this.author_bio = author_bio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

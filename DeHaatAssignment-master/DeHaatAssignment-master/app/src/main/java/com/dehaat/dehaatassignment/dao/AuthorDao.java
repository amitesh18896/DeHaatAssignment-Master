package com.dehaat.dehaatassignment.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.dehaat.dehaatassignment.model.Author;

import java.util.List;

@Dao
public interface AuthorDao {

    @Query("SELECT * FROM author")
    LiveData<List<Author>> loadPopularArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveArticles(List<Author> articleEntities);

}

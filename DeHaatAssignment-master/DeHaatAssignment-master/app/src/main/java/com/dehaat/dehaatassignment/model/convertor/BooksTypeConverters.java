package com.dehaat.dehaatassignment.model.convertor;

import androidx.room.TypeConverter;

import com.dehaat.dehaatassignment.model.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pallaw Pathak on 16/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class BooksTypeConverters {
    static Gson gson = new Gson();

    @TypeConverter
    public static List<Book> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Book>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<Book> someObjects) {
        return gson.toJson(someObjects);
    }
}

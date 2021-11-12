package com.dehaat.dehaatassignment.rest;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppRestClientService {

    @POST("/dehaat/login")
    Call<JsonElement> login(@Field("email") String email, @Field("password") String password);

    @GET("/dehaat/authors")
    Call<JsonElement> getListOfAuthors();

}

package com.kkk.campusposts.services;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public interface CampusSociety {

    @Headers("Content-Type: application/json")
    @POST("/api/2/email-auth/")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @Headers("Content-Type: application/json")
    @GET("/api/2/search/")
    Call<SearchResponse> search(@Header("Authorization") String token, @Query("sort_by") String sortBy, @Query("page") String page);
}
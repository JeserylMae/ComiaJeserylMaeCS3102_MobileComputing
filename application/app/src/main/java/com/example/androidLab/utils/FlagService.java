package com.example.androidLab.utils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;


public interface FlagService {
    @GET("en/codes.json")
    Call<Map<String, String>> getCountryCodes();
}

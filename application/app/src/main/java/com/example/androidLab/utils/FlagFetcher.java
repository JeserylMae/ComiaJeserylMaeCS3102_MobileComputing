package com.example.androidLab.utils;

import android.util.Log;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlagFetcher {

    private static final String BASE_URL = "https://flagcdn.com/";

    public interface CountryCodeCallback {
        void onCountryCodesFetched(Map<String, String> countryMap);
    }

    public static void fetchCountryCodes(CountryCodeCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlagService flagService = retrofit.create(FlagService.class);
        Call<Map<String, String>> call = flagService.getCountryCodes();

        call.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onCountryCodesFetched(response.body());
                } else {
                    Log.e("FlagFetcher", "Request failed with status code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                Log.e("FlagFetcher", "Request failed", t);
            }
        });
    }
}

package com.example.rahatfilmsapi;

import android.app.Application;

import com.example.rahatfilmsapi.data.remote.FilmsApi;
import com.example.rahatfilmsapi.data.remote.FilmsApiService;
import com.example.rahatfilmsapi.data.remote.RetrofitClient;

public class App extends Application {

    public static FilmsApi filmsApi;
    public static FilmsApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient retrofitClient = new RetrofitClient();
        filmsApi = retrofitClient.filmsApiClient();
        apiService = new FilmsApiService();
    }
}

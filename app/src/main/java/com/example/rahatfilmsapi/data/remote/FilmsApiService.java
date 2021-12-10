package com.example.rahatfilmsapi.data.remote;

import androidx.annotation.NonNull;
import com.example.rahatfilmsapi.App;
import com.example.rahatfilmsapi.data.models.FilmsModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiService {

    public void getFilms(OnFilmsReadyCallback callback) {

        App.filmsApi.getFilms().enqueue(new Callback<List<FilmsModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<FilmsModel>> call, @NonNull Response<List<FilmsModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(response.body());
                } else if (response.code() > 500) {
                    callback.error();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<FilmsModel>> call, @NonNull Throwable t) {
                callback.failure(t.getLocalizedMessage());
            }
        });
    }

     public void getDetailFilms(String id, OnFilmDetailCallback callback) {

         App.filmsApi.getDetailFilms(id).enqueue(new Callback<FilmsModel>() {
             @Override
             public void onResponse(@NonNull Call<FilmsModel> call, @NonNull Response<FilmsModel> response) {
                 if (response.isSuccessful() && response.body() != null) {
                     callback.success(response.body());
                 } else if (response.code() > 500) {
                     callback.error();
                 }
             }

             @Override
             public void onFailure(@NonNull Call<FilmsModel> call, @NonNull Throwable t) {
                 callback.failure(t.getLocalizedMessage());
             }
         });
     }
}

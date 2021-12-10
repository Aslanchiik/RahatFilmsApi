package com.example.rahatfilmsapi.data.remote;

import com.example.rahatfilmsapi.data.models.FilmsModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmsApi {

    @GET("/films")
    Call<List<FilmsModel>> getFilms();

    @GET("/films/{id}")
    Call<FilmsModel> getDetailFilms(
            @Path("id") String id
    );
}

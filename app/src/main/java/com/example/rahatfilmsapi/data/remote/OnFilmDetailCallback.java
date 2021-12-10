package com.example.rahatfilmsapi.data.remote;

import com.example.rahatfilmsapi.data.models.FilmsModel;

public interface OnFilmDetailCallback {

    void success(FilmsModel model);
    void error();
    void failure(String msg);

}

package com.example.rahatfilmsapi.data.remote;

import com.example.rahatfilmsapi.data.models.FilmsModel;

import java.util.List;

public interface OnFilmsReadyCallback {

    void success(List<FilmsModel> list);
    void error();
    void failure(String msg);
}

package com.example.rahatfilmsapi.ui.fragments.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rahatfilmsapi.App;
import com.example.rahatfilmsapi.data.models.FilmsModel;
import com.example.rahatfilmsapi.data.remote.OnFilmDetailCallback;
import com.example.rahatfilmsapi.databinding.FragmentFilmDetailBinding;

public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;
    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        id = FilmDetailFragmentArgs.fromBundle(getArguments()).getPosition();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();

    }

    private void getData() {
        App.apiService.getDetailFilms(id, new OnFilmDetailCallback() {
            @Override
            public void success(FilmsModel model) {
                Log.e("tag", "getData");
                binding.titleProducer.setText(model.getProducer());
                binding.nameOfDirector.setText(model.getDirector());
                binding.timeOfFilm.setText(model.getRunning_time());
                binding.descriptionId.setText(model.getDescription());
            }

            @Override
            public void error() {
                Log.e("tag", "error");
            }

            @Override
            public void failure(String msg) {
                  Log.e("tag", msg);
            }
        });
    }
}
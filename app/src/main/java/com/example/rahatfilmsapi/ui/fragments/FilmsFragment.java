package com.example.rahatfilmsapi.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.rahatfilmsapi.App;
import com.example.rahatfilmsapi.data.models.FilmsModel;
import com.example.rahatfilmsapi.data.remote.OnFilmsReadyCallback;
import com.example.rahatfilmsapi.databinding.FragmentFilmsBinding;
import com.example.rahatfilmsapi.ui.adapters.FilmsAdapter;
import java.util.List;

public class FilmsFragment extends Fragment {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        adapter = new FilmsAdapter();
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
        getData();
        sendDataId();
    }

    private void setupRecyclerView() {
        binding.recView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recView.setAdapter(adapter);

    }

    private void getData() {
        App.apiService.getFilms(new OnFilmsReadyCallback() {
            @Override
            public void success(List<FilmsModel> list) {
                adapter.setFilms(list);
            }

            @Override
            public void error() {
                Toast.makeText(requireContext(), "Данных нет", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(String msg) {
                Log.e("tag", "failure" + msg);
            }
        });
    }

    private void sendDataId() {
        adapter.setOnItemClick(position ->
                Navigation.findNavController(requireView()).navigate(
                      FilmsFragmentDirections.actionFilmsFragmentToFilmDetailFragment(position).setPosition(position)));
    }
}
package com.example.rahatfilmsapi.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rahatfilmsapi.data.models.FilmsModel;
import com.example.rahatfilmsapi.databinding.ItemFilmsBinding;
import com.example.rahatfilmsapi.utils.OnItemClick;
import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<FilmsModel> list = new ArrayList<>();
    public static OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        FilmsAdapter.onItemClick = onItemClick;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFilms(List<FilmsModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsBinding binding = ItemFilmsBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemFilmsBinding binding;

        public ViewHolder(@NonNull ItemFilmsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(FilmsModel filmsModel) {
              binding.itemFilmTitle.setText(filmsModel.getTitle());
              binding.itemFilmRelease.setText(filmsModel.getRelease_date());
              itemView.setOnClickListener(view -> onItemClick.itemClick(filmsModel.getId()));
        }
    }
}

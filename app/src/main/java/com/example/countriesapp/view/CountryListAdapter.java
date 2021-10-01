package com.example.countriesapp.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.countriesapp.databinding.CountryItemBinding;
import com.example.countriesapp.model.CountryModel;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {

    private List<CountryModel> countries;

    public CountryListAdapter(List<CountryModel> countries) {
        this.countries = countries;
    }

    public void updateCountries(List<CountryModel> newCountries) {
        countries.clear();
        countries.addAll(newCountries);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CountryItemBinding binding = CountryItemBinding.inflate(inflater, parent, false);
        return new CountryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }




    class CountryViewHolder extends RecyclerView.ViewHolder {

        private CountryItemBinding binding;

        public CountryViewHolder(@NonNull CountryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        void bind(CountryModel country) {
            binding.country.setText(country.getCountryName());
            binding.capital.setText(country.getCountryCapital());
            Util.loadImage(binding.flag, country.getFlags(), Util.getProgressDrawable(binding.flag.getContext()));

        }
    }
}

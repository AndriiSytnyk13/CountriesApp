package com.example.countriesapp.view;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;

import com.example.countriesapp.databinding.ActivityMainBinding;

import com.example.countriesapp.viewmodel.ListViewModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListViewModel viewModel;
    private CountryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = new ViewModelProvider(this).get(ListViewModel.class);
        viewModel.refresh();

        adapter = new CountryListAdapter(new ArrayList<>());
        binding.countriesList.setLayoutManager(new LinearLayoutManager(this));
        binding.countriesList.setAdapter(adapter);

        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            viewModel.refresh();
            binding.swipeRefreshLayout.setRefreshing(false);
        });


        observerViewModel();


    }

    private void observerViewModel() {
        viewModel.getCountries().observe(this, countryModels -> {
            if (countryModels != null) {
                binding.countriesList.setVisibility(View.VISIBLE);
                adapter.updateCountries(countryModels);
            }
        });

        viewModel.getCountryLoadError().observe(this, isError -> {
            if (isError != null) {
                binding.errorMessage.setVisibility(isError ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                binding.loadingData.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    binding.errorMessage.setVisibility(View.GONE);
                    binding.countriesList.setVisibility(View.GONE);
                }
            }
        });

    }
}
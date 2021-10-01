package com.example.countriesapp.model;


import com.example.countriesapp.di.DaggerApiComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;


public class CountriesService {



    private static CountriesService instance;

    @Inject
    public CountriesApi api;

    public CountriesService() {
        DaggerApiComponent
                .create()
                .inject(this);

    }

    public static CountriesService getInstance() {
        if (instance == null) {
            instance = new CountriesService();
        }
        return instance;
    }

    public Single<List<CountryModel>> getCountries() {
        return api.getCountries();
    }
}

package com.example.countriesapp.di;

import com.example.countriesapp.model.CountriesService;
import com.example.countriesapp.viewmodel.ListViewModel;



import dagger.Component;

@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(CountriesService countriesService);

    void inject(ListViewModel listViewModel);


}

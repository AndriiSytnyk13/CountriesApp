package com.example.countriesapp.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("name")
    public String countryName;

    @SerializedName("capital")
    public String countryCapital;

    @SerializedName("flagPNG")
    public String flags;

    public CountryModel(String countryName, String countryCapital, String flags) {
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.flags = flags;
    }


    public String getCountryName() {
        return countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public String getFlags() {
        return flags;
    }
}

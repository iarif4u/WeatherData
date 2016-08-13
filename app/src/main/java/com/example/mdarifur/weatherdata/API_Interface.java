package com.example.mdarifur.weatherdata;

import com.example.mdarifur.weatherdata.model.currentWeather.CurrentWeather;
import com.example.mdarifur.weatherdata.model.forecast.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * Created by MD.Arifur on 8/12/2016.
 */
public interface API_Interface {

    @GET
    Call<CurrentWeather> getCurrentWeather(@Url String url);


    @GET
    Call<Forecast> getForecastWeather(@Url String url);
}

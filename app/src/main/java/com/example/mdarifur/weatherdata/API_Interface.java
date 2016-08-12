package com.example.mdarifur.weatherdata;

import com.example.mdarifur.weatherdata.model.Channel;
import com.example.mdarifur.weatherdata.model.YahooWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by MD.Arifur on 8/12/2016.
 */
public interface API_Interface {
    @GET("v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json")
    Call<Channel> getWeatherConditions(
    );
}

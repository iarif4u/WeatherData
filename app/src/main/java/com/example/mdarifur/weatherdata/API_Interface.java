package com.example.mdarifur.weatherdata;

import com.example.mdarifur.weatherdata.Conditionson.Condition;
import com.example.mdarifur.weatherdata.model.ForecastTenday.ForecastTenday;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by MD.Arifur on 8/12/2016.
 */
public interface API_Interface {

    @GET("api/{apikey}/forecast10day/q/BD/{city}.json")
    Call<ForecastTenday> getWeatherForecast(
            @Path("apikey") String apikey,
            @Path("city") String city);

}

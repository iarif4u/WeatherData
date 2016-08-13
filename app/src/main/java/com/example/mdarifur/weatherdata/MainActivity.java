package com.example.mdarifur.weatherdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mdarifur.weatherdata.model.currentWeather.CurrentWeather;

import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView title;
    String currentCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.title);
        currentCity = "Dhaka";
        String url = "v1/current.json?key="+Constants.API_KEY+"&q="+currentCity;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API_Interface weatherService = retrofit.create(API_Interface.class);
        Call<CurrentWeather> currentWeatherCall = weatherService.getCurrentWeather(url);
        currentWeatherCall.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                String high = response.body().getLocation().getCountry();
                title.setText("Temp: "+high);
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                title.setText(t.getMessage());
            }
        });


    }
}

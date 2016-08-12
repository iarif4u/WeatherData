package com.example.mdarifur.weatherdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mdarifur.weatherdata.model.Channel;
import com.example.mdarifur.weatherdata.model.Condition;
import com.example.mdarifur.weatherdata.model.YahooWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.title);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API_Interface weatherService = retrofit.create(API_Interface.class);
        Call<Channel> callWeatherConditions = weatherService.getWeatherConditions();
        callWeatherConditions.enqueue(new Callback<Channel>() {
            @Override
            public void onResponse(Call<Channel> call, Response<Channel> response) {
                title.setText("Temp: "+response.body().getLastBuildDate());
            }

            @Override
            public void onFailure(Call<Channel> call, Throwable t) {
                title.setText(t.getMessage());
            }
        });


    }
}

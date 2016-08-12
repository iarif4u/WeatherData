package com.example.mdarifur.weatherdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mdarifur.weatherdata.Conditionson.Condition;
import com.example.mdarifur.weatherdata.Conditionson.DisplayLocation;
import com.example.mdarifur.weatherdata.model.ForecastTenday.ForecastTenday;

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API_Interface weatherService = retrofit.create(API_Interface.class);
        Call<ForecastTenday> callWeatherConditions = weatherService.getWeatherForecast(Constants.API_KEY,currentCity);
        callWeatherConditions.enqueue(new Callback<ForecastTenday>() {
            @Override
            public void onResponse(Call<ForecastTenday> call, Response<ForecastTenday> response) {
                String high = response.body().getForecast().getSimpleforecast().getForecastday().get(0).getHigh().getCelsius();
                title.setText("Temp: "+high);
            }

            @Override
            public void onFailure(Call<ForecastTenday> call, Throwable t) {
                title.setText(t.getMessage());
            }
        });


    }
}

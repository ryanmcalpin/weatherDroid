package com.example.guest.weatherdroid.services;

import android.util.Log;

import com.example.guest.weatherdroid.Constants;
import com.example.guest.weatherdroid.models.DailyForecast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 5/31/17.
 */

public class WeatherService {

    public static void getForecast(String location, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.WEATHER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.WEATHER_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();
        Log.d("url", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<DailyForecast> processResults (Response response){
        ArrayList<DailyForecast> forecasts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()){
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray forecastListJSON = weatherJSON.getJSONArray("list");
                for(int i = 0; i< forecastListJSON.length(); i++){
                    JSONObject forecastJSON = forecastListJSON.getJSONObject(i);
                    String date = forecastJSON.getString("dt");
                    String high = forecastJSON.getJSONObject("temp").getString("max");
                    String low = forecastJSON.getJSONObject("temp").getString("min");
                    String humidity = forecastJSON.getString("humidity");
                    String iconCode = forecastJSON.getJSONObject("weather").getString("icon");
                    String description = forecastJSON.getJSONObject("weather").getString("description");
                    DailyForecast forecast = new DailyForecast(date, iconCode, high, low, humidity, description);
                    forecasts.add(forecast);
                }
            }
        }
    }
}

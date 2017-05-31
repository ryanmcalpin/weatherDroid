package com.example.guest.weatherdroid.models;

import org.parceler.Parcel;

import java.io.Serializable;
import java.util.ArrayList;

@Parcel
public class DailyForecast {
    public String mDate;
    public String mIconCode;
    public String mHigh;
    public String mLow;
    public String mHumidity;
    public String mDescription;

    public DailyForecast() {}

    public DailyForecast(String date, String iconCode, String high, String low, String humidity, String description) {
        this.mDate = date;
        this.mIconCode = iconCode;
        this.mHigh = high;
        this.mLow = low;
        this.mHumidity = humidity;
        this.mDescription = description;
    }

    public String getDate() {
        return mDate;
    }

    public String getImageUrl() {
        return "http://openweathermap.org/img/w/" + mIconCode + ".png";
    }

    public String getHigh() {
        return mHigh;
    }

    public String getLow() {
        return mLow;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public String getDescription() {
        return mDescription;
    }
}

package com.example.guest.weatherdroid.models;

import android.util.Log;

import org.parceler.Parcel;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@Parcel
public class DailyForecast {
    static public String apiLocation;
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
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
        Date currentDate = new Date(Long.valueOf(mDate) * 1000);
        String prettyDate = sdf.format(currentDate);
        return prettyDate;
    }

    public String getImageUrl() {
        return "http://openweathermap.org/img/w/" + mIconCode + ".png";
    }

    public String getHigh() {
        return "High: " + mHigh + " F";
    }

    public String getLow() {
        return "Low: " + mLow + " F";
    }

    public String getHumidity() {
        return "Humidity: " + mHumidity + "%";
    }

    public String getDescription() {
        String cap = mDescription.substring(0, 1).toUpperCase() + mDescription.substring(1);
        return cap;
    }

    String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
}

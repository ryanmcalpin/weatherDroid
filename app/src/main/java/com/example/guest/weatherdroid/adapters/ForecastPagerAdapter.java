package com.example.guest.weatherdroid.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.weatherdroid.models.DailyForecast;
import com.example.guest.weatherdroid.ui.SingleDayFragment;

import java.util.ArrayList;

public class ForecastPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<DailyForecast> mForecasts;

    public ForecastPagerAdapter(FragmentManager fm, ArrayList<DailyForecast> forecasts){
        super(fm);
        mForecasts = forecasts;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mForecasts.get(position).getDate();
    }

    @Override
    public Fragment getItem(int position) {
        return SingleDayFragment.newInstance(mForecasts.get(position));
    }

    @Override
    public int getCount() {
        return mForecasts.size();
    }
}

package com.example.guest.weatherdroid.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.weatherdroid.R;
import com.example.guest.weatherdroid.models.DailyForecast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>{
    private ArrayList<DailyForecast> forecasts = new ArrayList<>();
    private Context context;

    public ForecastListAdapter(Context context, ArrayList<DailyForecast> forecasts){
        this.context = context;
        this.forecasts = forecasts;
    }

    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastListAdapter.ForecastViewHolder holder, int position){
        holder.bindForecast(forecasts.get(position));
    }

    @Override
    public int getItemCount(){
        return forecasts.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.dateTextView) TextView dateView;
        @Bind(R.id.highLowTextView) TextView highLowView;
        @Bind(R.id.humidityTextView) TextView humidityView;
        @Bind(R.id.descriptionTextView) TextView descriptionView;
        @Bind(R.id.iconView) ImageView iconView;

        private Context context;

        public ForecastViewHolder (View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
        
        public void bindForecast(DailyForecast forecast){
            Picasso.with(context).load(forecast.getImageUrl()).into(iconView);
            dateView.setText(forecast.getDate());
            highLowView.setText(forecast.getHigh() + "\n" + forecast.getLow());
            humidityView.setText(forecast.getHumidity());
            descriptionView.setText(forecast.getDescription());
        }
    }
}

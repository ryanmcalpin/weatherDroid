package com.example.guest.weatherdroid.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.weatherdroid.R;
import com.example.guest.weatherdroid.models.DailyForecast;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleDayFragment extends Fragment {
    @Bind(R.id.dateTextView) TextView dateView;
    @Bind(R.id.highLowTextView) TextView highLowView;
    @Bind(R.id.humidityTextView) TextView humidityView;
    @Bind(R.id.descriptionTextView) TextView descriptionView;
    @Bind(R.id.iconView) ImageView iconView;

    private DailyForecast mDailyForecast;

    public static SingleDayFragment newInstance(DailyForecast dailyForecast) {
        SingleDayFragment singleDayFragment = new SingleDayFragment();
        Bundle args = new Bundle();
        args.putParcelable("forecast", Parcels.wrap(dailyForecast));
        singleDayFragment.setArguments(args);
        return singleDayFragment;
    }

    public SingleDayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDailyForecast = Parcels.unwrap(getArguments().getParcelable("forecast"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_day, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mDailyForecast.getImageUrl()).into(iconView);

        dateView.setText(mDailyForecast.getDate());
        highLowView.setText(mDailyForecast.getHigh() + "\n" + mDailyForecast.getLow());
        humidityView.setText(mDailyForecast.getHumidity());
        descriptionView.setText(mDailyForecast.getDescription());

        return view;
    }

}

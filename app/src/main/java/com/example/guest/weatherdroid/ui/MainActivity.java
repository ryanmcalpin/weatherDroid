package com.example.guest.weatherdroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.weatherdroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.editText) EditText mLocationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        String location = mLocationText.getText().toString();
        if(location.trim().length() != 0){
            Intent intent = new Intent(MainActivity.this, ForecastActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        } else{
            mLocationText.setError("Must pick a location");
            mLocationText.setText("");
        }

    }
}



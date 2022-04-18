package com.example.healthyklan.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_HealthyKlan);
        setContentView(R.layout.activity_main);
    }
}


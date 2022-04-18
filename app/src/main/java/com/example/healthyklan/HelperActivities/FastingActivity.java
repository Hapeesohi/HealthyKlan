package com.example.healthyklan.HelperActivities;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;

public class FastingActivity extends AppCompatActivity {

    ImageView ivBacktoHome;
    TimePicker starting, ending;
    TextView btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasting);

        ivBacktoHome = findViewById(R.id.ivBackToHomeFasting);
        starting = findViewById(R.id.timePickerFasting);
        ending = findViewById(R.id.timePickerFasting2);
        btnSave = findViewById(R.id.tvSaveFasting);
        starting.setIs24HourView(true);
        ending.setIs24HourView(true);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour, minute;
                int ehour,eminute;
                String eam_pm;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = starting.getHour();
                    minute = starting.getMinute();
                }
                else{
                    hour = starting.getCurrentHour();
                    minute = starting.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }
                if (Build.VERSION.SDK_INT >= 23 ){
                    ehour = ending.getHour();
                    eminute = ending.getMinute();
                }
                else{
                    ehour = ending.getCurrentHour();
                    eminute = ending.getCurrentMinute();
                }
                if(hour > 12) {
                    eam_pm = "PM";
                    ehour = ehour - 12;
                }
                else
                {
                    eam_pm="AM";
                }

                Toast.makeText(FastingActivity.this, "Fasting time added!", Toast.LENGTH_LONG).show();
            }
        });


        ivBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
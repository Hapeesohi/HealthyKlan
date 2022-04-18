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

public class SleepTrackerActivity extends AppCompatActivity {

    ImageView ivBacktoHoem;
    TimePicker starting, ending;
    TextView btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracker);

        ivBacktoHoem = findViewById(R.id.ivBackToHome);
        starting = findViewById(R.id.timePicker);
        ending = findViewById(R.id.timePicker2);
        btnSave = findViewById(R.id.tvSaveTime);

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

                Toast.makeText(SleepTrackerActivity.this, "Sleeping time added!", Toast.LENGTH_LONG).show();
            }
        });


        ivBacktoHoem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
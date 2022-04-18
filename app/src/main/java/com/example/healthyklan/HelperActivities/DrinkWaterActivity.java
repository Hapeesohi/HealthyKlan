package com.example.healthyklan.HelperActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;

public class DrinkWaterActivity extends AppCompatActivity {

    ImageView ivBacktoHome;
    ImageView ivShare;
    ImageView ivAdd;
    ImageView ivMinus;
    TextView tvCount, goToHome, detailWater;

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_water);

        ivBacktoHome = findViewById(R.id.ivBackToHome);
        ivShare = findViewById(R.id.ivShare);
        ivAdd = findViewById(R.id.ivAddWater);
        ivMinus = findViewById(R.id.ivRemoveWater);
        tvCount = findViewById(R.id.tvCount);
        goToHome = findViewById(R.id.tvHomeWater);
        detailWater = findViewById(R.id.tvDetailWater);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                String cnt = String.valueOf(count);
                if(count >10){
                    Toast.makeText(DrinkWaterActivity.this, "Congratulations you have completed you drinking task.", Toast.LENGTH_LONG).show();
                }
                tvCount.setText(cnt);
            }
        });

        ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 0){
                    count--;
                    String cnt = String.valueOf(count);
                    tvCount.setText(cnt);
                }else{
                    Toast.makeText(DrinkWaterActivity.this, "Sorry cant go below zero", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ivBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        detailWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DrinkWaterActivity.this, "You have consumed "+(count)+" Glasses of water out of 11", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
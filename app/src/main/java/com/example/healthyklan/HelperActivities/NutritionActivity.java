package com.example.healthyklan.HelperActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;
import com.example.healthyklan.activity.HomeActivity;
import com.example.healthyklan.nutrition.AddMealActivity;

public class NutritionActivity extends AppCompatActivity {

    ImageView ivBackButton;
    ImageView ivShareButton;
    ImageView ivAddBreakfast, ivAddLunch, ivAddDinner, ivAddSnacks;
    TextView tvHome, tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        setResources();

        ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ivAddBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NutritionActivity.this, AddMealActivity.class);
                intent.putExtra("MEAL","BREAKFAST");
                startActivity(intent);
            }
        });

        ivAddLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NutritionActivity.this, AddMealActivity.class);
                intent.putExtra("MEAL","LUNCH");
                startActivity(intent);
            }
        });

        ivAddDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NutritionActivity.this, AddMealActivity.class);
                intent.putExtra("MEAL","DINNER");
                startActivity(intent);
            }
        });

        ivAddSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NutritionActivity.this, AddMealActivity.class);
                intent.putExtra("MEAL","SNACKS");
                startActivity(intent);
            }
        });

        tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NutritionActivity.this, HomeActivity.class));
            }
        });

    }

    private void setResources() {

        ivBackButton = findViewById(R.id.ivBackToHome);
        ivShareButton = findViewById(R.id.ivShare);
        ivAddBreakfast= findViewById(R.id.ivAddBreakFAst);
        ivAddLunch= findViewById(R.id.ivAddLunch);
        ivAddDinner= findViewById(R.id.ivAddDinner);
        ivAddSnacks= findViewById(R.id.ivAddSnacks);
        tvHome = findViewById(R.id.tvHome);
        tvDetail = findViewById(R.id.tvDetail);
    }
}
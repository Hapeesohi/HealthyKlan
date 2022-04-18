package com.example.healthyklan.nutrition;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.healthyklan.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AddMealActivity extends AppCompatActivity {

    TabLayout tabLayoutMeals;
    ViewPager2 viewPagerMeals;
    ImageView ivBackToMeal, ivPdf;
    TextView tvAddMeal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        tabLayoutMeals = findViewById(R.id.tabLayoutAddMeal);
        viewPagerMeals = findViewById(R.id.viewPagerAddMeal);
        ivBackToMeal = findViewById(R.id.ivBackMeals);
        ivPdf = findViewById(R.id.ivPdf);
        tvAddMeal = findViewById(R.id.tvAddMeal);

        tabLayoutMeals.addTab(tabLayoutMeals.newTab().setText(R.string.text_my_meal));
        tabLayoutMeals.addTab(tabLayoutMeals.newTab().setText(R.string.text_search));
        tabLayoutMeals.setTabGravity(TabLayout.GRAVITY_FILL);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("My Meals");
        arrayList.add("Search");

        ivPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddMealActivity.this, "PDF is created and saved to the files.", Toast.LENGTH_SHORT).show();
            }
        });

        MealAdapter adapter = new MealAdapter(this.getSupportFragmentManager(), getLifecycle());
        viewPagerMeals.setAdapter(adapter);

        tabLayoutMeals.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerMeals.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ivBackToMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("MEAL");
//            Toast.makeText(this, "value is : "+value, Toast.LENGTH_SHORT).show();
            if (value.equals("BREAKFAST")) {
                tvAddMeal.setText("Breakfast");
                new MealType("Breakfast");
            } else if (value.equals("LUNCH")) {
                tvAddMeal.setText("Lunch");
            } else if (value.equals("DINNER")) {
                tvAddMeal.setText("Dinner");
            } else {
                tvAddMeal.setText("Snacks");
            }
        }

    }
}
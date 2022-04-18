package com.example.healthyklan.HelperActivities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;

public class WeightTrackerActivity extends AppCompatActivity {

    EditText etCurrent, etGoal;
    TextView tvSave, wayToGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker);

        etCurrent = findViewById(R.id.tvCurrent);
        etGoal = findViewById(R.id.tvGoal);
        tvSave = findViewById(R.id.tvSave);
        wayToGo = findViewById(R.id.tvWayToGo);



         tvSave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(etCurrent.getText().toString().isEmpty() || etGoal.getText().toString().isEmpty()){
                     Toast.makeText(WeightTrackerActivity.this, "Something is missing!", Toast.LENGTH_SHORT).show();
                 }else{
                     int goal =  Integer.parseInt(etCurrent.getText().toString());
                     int weight = Integer.parseInt(etGoal.getText().toString());
                     if(goal>weight){
                         int wei = goal-weight;

                         wayToGo.setText(String.valueOf(wei)+" more kgs to Go!");
                     }else{
                         int wei = weight-goal;
                         wayToGo.setText(String.valueOf(wei)+" more kgs to Go!");
                     }
                     Toast.makeText(WeightTrackerActivity.this, "Info is saved!", Toast.LENGTH_LONG).show();
                 }
                 }

         });

        fetchFromPref();

    }

    private void fetchFromPref() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String weight = sharedPreferences.getString("weight","100");
    }


}
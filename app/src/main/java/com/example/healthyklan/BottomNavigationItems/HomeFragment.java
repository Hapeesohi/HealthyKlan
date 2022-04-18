package com.example.healthyklan.BottomNavigationItems;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.healthyklan.HelperActivities.DrinkWaterActivity;
import com.example.healthyklan.HelperActivities.FastingActivity;
import com.example.healthyklan.HelperActivities.NutritionActivity;
import com.example.healthyklan.HelperActivities.SleepTrackerActivity;
import com.example.healthyklan.HelperActivities.StepCountActivity;
import com.example.healthyklan.HelperActivities.WeightTrackerActivity;
import com.example.healthyklan.HelperActivities.WorkoutActivity;
import com.example.healthyklan.R;


public class HomeFragment extends Fragment {

    LinearLayout llWater;
    LinearLayout llSleep;
    LinearLayout llWeight;
    LinearLayout llSteps;
    LinearLayout llFasting;
    ImageView ivNutririnAdd;
    ImageView ivWorkoutAdd, ivAddNotesHome;
    EditText etNotesHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ivNutririnAdd = view.findViewById(R.id.ivNutritionHomeAdd);
        ivWorkoutAdd = view.findViewById(R.id.ivWorkoutHomeAdd);
        llWater = view.findViewById(R.id.llWaterHome);
        llSleep = view.findViewById(R.id.llSleepHome);
        llWeight = view.findViewById(R.id.llWeightHome);
        llSteps = view.findViewById(R.id.llStepsHome);
        llFasting = view.findViewById(R.id.llFastingHome);
        ivAddNotesHome = view.findViewById(R.id.ivAddNoteHome);
        etNotesHome = view.findViewById(R.id.etHomeNotes);



        ivNutririnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NutritionActivity.class));
            }
        });

        ivWorkoutAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WorkoutActivity.class));
            }
        });

        llWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DrinkWaterActivity.class));
            }
        });

        llSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StepCountActivity.class));
            }
        });

        llSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SleepTrackerActivity.class));
            }
        });

        llWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WeightTrackerActivity.class));
            }
        });

        llFasting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FastingActivity.class));
            }
        });

        ivAddNotesHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = etNotesHome.getText().toString();
                if(note.isEmpty()){
                    Toast.makeText(getContext(), "Note is empty!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), " Note : "+note+" is added.", Toast.LENGTH_LONG).show();
                    etNotesHome.setText("");
                }

            }
        });

        return view;
    }
}
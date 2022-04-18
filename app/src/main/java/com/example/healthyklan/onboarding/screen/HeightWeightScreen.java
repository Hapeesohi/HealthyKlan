package com.example.healthyklan.onboarding.screen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.healthyklan.R;

public class HeightWeightScreen extends Fragment {

    EditText etWeight;
    EditText etHeight;
    EditText etWeightGoal;
    TextView tvFinish;

    int weight = 0;
    int height = 0;
    int weightGoal = 0;

    int good = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_height_weight, container, false);

        etWeight = view.findViewById(R.id.etWeight);
        etHeight = view.findViewById(R.id.etHeight);
        etWeightGoal = view.findViewById(R.id.etWeightGoal);
        tvFinish = view.findViewById(R.id.tvFinish);

        tvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String weightL = etWeight.getText().toString();
                String heightL = etHeight.getText().toString();
                String weightGoalL = etWeightGoal.getText().toString();

                if (weightL.isEmpty()) {
                    good--;
                    etWeight.setError("Enter valid weight!");
                } else {
                    good++;
                    weight = Integer.parseInt(weightL);
                }
                if (heightL.isEmpty()) {
                    good--;
                    etHeight.setError("Enter valid height!");
                } else {
                    good++;
                    height = Integer.parseInt(heightL);
                }
                if (weightGoalL.isEmpty()) {
                    good--;
                    etWeightGoal.setError("Enter valid number!");
                } else {
                    good++;
                    weightGoal = Integer.parseInt(weightGoalL);
                }

                if(good == 3){
                    good = 0;
                    finishOnBoarding();
                    Navigation.findNavController(view).navigate(R.id.action_viewPagerFragment_to_signUpActivity);

                }
            }
        });
        return view;
    }

    private void finishOnBoarding(){
        SharedPreferences sp  = getContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("WEIGHT",weight);
        editor.putInt("HEIGHT",height);
        editor.putInt("WEIGHTGOAL",weightGoal);
        editor.putBoolean("ONBOARDED",true);
        //editor.apply();
        editor.commit();
    }
}
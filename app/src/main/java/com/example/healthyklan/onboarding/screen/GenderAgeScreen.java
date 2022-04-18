package com.example.healthyklan.onboarding.screen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthyklan.R;
import com.google.android.material.textfield.TextInputEditText;

public class GenderAgeScreen extends Fragment {

    TextView tvMale;
    TextView tvFemale;
    TextInputEditText tietAge;
    TextView tvNext;
    int gen = -1;
    int age = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gender_age, container, false);

        //get id from resource
        tvMale = view.findViewById(R.id.tvGenderMale);
        tvFemale = view.findViewById(R.id.tvGenderFemale);
        tietAge = view.findViewById(R.id.textInputETAge);
        tvNext = view.findViewById(R.id.tvActivityNextHeightWeight);

        tvMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gen == -1 || gen == 1){
                    gen = 0;
                    tvMale.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                    tvFemale.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }else if(gen == 0){
                    gen = -1;
                    tvMale.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }
            }
        });

        tvFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gen == -1 || gen == 0){
                    gen = 1;
                    tvFemale.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                    tvMale.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }else if(gen == 1){
                    gen = -1;
                    tvMale.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }
            }
        });

        ViewPager2 viewPager2 = getActivity().findViewById(R.id.viewPagerOnboard);

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageL = tietAge.getText().toString();
                if(!ageL.isEmpty()){
                    age = Integer.parseInt(ageL);
                    setGenderAge();
                    //Toast.makeText(view.getContext(), "age is : "+age+" gender is : "+gen , Toast.LENGTH_SHORT).show();
                    viewPager2.setCurrentItem(3);
                }else{ 
                    tietAge.setError("Enter valid age!");
                }

            }
        });

        return view;
    }

    private void setGenderAge(){
        SharedPreferences sp  = getContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("AGE",age);
        editor.putInt("GENDER",gen);
        editor.commit();
    }
}
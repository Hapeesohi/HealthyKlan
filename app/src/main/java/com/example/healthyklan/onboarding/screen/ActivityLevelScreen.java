package com.example.healthyklan.onboarding.screen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.healthyklan.R;

public class ActivityLevelScreen extends Fragment {

    LinearLayout llActivityOne;
    LinearLayout llActivityTwo;
    LinearLayout llActivityThree;
    LinearLayout llActivityFour;
    TextView tvActivityNext;

    //setting boolean for all the selection to false
    boolean levelOneSelected = false;
    boolean levelTwoSelected = false;
    boolean levelThreeSelected = false;
    boolean levelFourSelected = false;

    int activityLevel = 0;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity_level, container, false);

        // get id
        llActivityOne = view.findViewById(R.id.llActivityOne);
        llActivityTwo = view.findViewById(R.id.llActivityTwo);
        llActivityThree = view.findViewById(R.id.llActivityThree);
        llActivityFour = view.findViewById(R.id.llActivityFour);
        tvActivityNext = view.findViewById(R.id.tvActivityNextGenderAge);

        //calling setSelection() when the user will select the level of activity they perform
        //which further will assign the values to the boolean for each activity

        llActivityOne.setOnClickListener(view1 -> setSelection(llActivityOne));

        llActivityTwo.setOnClickListener(view14 -> setSelection(llActivityTwo));

        llActivityThree.setOnClickListener(view13 -> setSelection(llActivityThree));

        llActivityFour.setOnClickListener(view12 -> setSelection(llActivityFour));

        //Next button to take user to next fragment (Gender age screen)
        tvActivityNext.setOnClickListener(view15 -> {

        });

        ViewPager2 viewPager2 = getActivity().findViewById(R.id.viewPagerOnboard);

        tvActivityNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(levelOneSelected) activityLevel = 1;
                if(levelTwoSelected) activityLevel = 2;
                if(levelThreeSelected) activityLevel = 3;
                if(levelFourSelected) activityLevel = 4;

                setActivityLevel();

                viewPager2.setCurrentItem(2);
            }
        });

        return view;
    }

    private void setSelection( LinearLayout layout){


        if(layout == llActivityOne){
            if(levelOneSelected){
                levelOneSelected = false;
                llActivityOne.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
            }else{
                levelOneSelected = true;
                levelTwoSelected = false;
                levelThreeSelected = false;
                levelFourSelected = false;
                llActivityTwo.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityThree.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityFour.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityOne.setBackgroundResource(R.drawable.bg_onboard_activity_selected);
            }
        }else if(layout == llActivityTwo){
            if(levelTwoSelected){
                levelTwoSelected = false;
                llActivityTwo.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
            }else{
                levelOneSelected = false;
                levelTwoSelected = true;
                levelThreeSelected = false;
                levelFourSelected = false;
                llActivityTwo.setBackgroundResource(R.drawable.bg_onboard_activity_selected);
                llActivityThree.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityFour.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityOne.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
            }
        }else if(layout == llActivityThree){
            if(levelThreeSelected){
                levelThreeSelected = false;
                llActivityThree.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
            }else{
                levelOneSelected = false;
                levelTwoSelected = false;
                levelThreeSelected = true;
                levelFourSelected = false;
                llActivityTwo.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityThree.setBackgroundResource(R.drawable.bg_onboard_activity_selected);
                llActivityFour.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityOne.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
            }
        }else if(layout == llActivityFour){
            if(levelFourSelected){
                levelFourSelected = false;
                llActivityFour.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
            }else{
                levelOneSelected = false;
                levelTwoSelected = false;
                levelThreeSelected = false;
                levelFourSelected = true;
                llActivityTwo.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityThree.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
                llActivityFour.setBackgroundResource(R.drawable.bg_onboard_activity_selected);
                llActivityOne.setBackgroundResource(R.drawable.bg_onboard_activity_not_selected);
            }
        }
    }

    private void setActivityLevel(){
        SharedPreferences sp  = getContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("ACTIVITY",activityLevel);
        editor.commit();
    }
}
package com.example.healthyklan.onboarding.screen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthyklan.R;

public class GoalsScreen extends Fragment {

    private TextView tvGoalOne;
    private TextView tvGoalTwo;
    TextView tvGoalThree;
    TextView tvGoalFour;
    TextView tvGoalFive;
    TextView tvGoalSix;
    TextView tvGoalSeven;
    TextView tvNext;

    private int selectionSum = 0;
    boolean ifGoalOne = false;
    boolean ifGoalTwo = false;
    boolean ifGoalThree = false;
    boolean ifGoalFour = false;
    boolean ifGoalFive = false;
    boolean ifGoalSix = false;
    boolean ifGoalSeven = false;

    int arr[] = {0,0,0,0,0,0,0};
    String goals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_goals, container, false);

        //get refrences
        tvGoalOne = view.findViewById(R.id.tvGoalOne);
        tvGoalTwo = view.findViewById(R.id.tvGoalTwo);
        tvGoalThree = view.findViewById(R.id.tvGoalThree);
        tvGoalFour = view.findViewById(R.id.tvGoalFour);
        tvGoalFive = view.findViewById(R.id.tvGoalFive);
        tvGoalSix = view.findViewById(R.id.tvGoalSix);
        tvGoalSeven = view.findViewById(R.id.tvGoalSeven);
        tvNext = view.findViewById(R.id.tvActivityNextActivityLevel);

        tvGoalOne.setOnClickListener(view1 -> {
            if(ifGoalOne){
                if(selectionSum>0)
                    selectionSum--;
                ifGoalOne = false;
                tvGoalOne.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
            }else{
                if(selectionSum != 3){
                    selectionSum++;
                    ifGoalOne = true;
                    tvGoalOne.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                }

            }
        });

        tvGoalTwo.setOnClickListener(view12 -> {
            if(ifGoalTwo){
                if(selectionSum>0)
                    selectionSum--;
                ifGoalTwo = false;
                tvGoalTwo.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
            }else{
                if(selectionSum != 3){
                    selectionSum++;
                    ifGoalTwo = true;
                    tvGoalTwo.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                }

            }
        });

        tvGoalThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifGoalThree){
                    if(selectionSum>0)
                        selectionSum--;
                    ifGoalThree = false;
                    tvGoalThree.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }else{
                    if(selectionSum != 3){
                        selectionSum++;
                        ifGoalThree = true;
                        tvGoalThree.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                    }

                }
            }
        });

        tvGoalFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifGoalFour){
                    if(selectionSum>0)
                        selectionSum--;
                    ifGoalFour = false;
                    tvGoalFour.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }else{
                    if(selectionSum != 3){
                        selectionSum++;
                        ifGoalFour = true;
                        tvGoalFour.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                    }

                }
            }
        });
        tvGoalFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifGoalFive){
                    if(selectionSum>0)
                        selectionSum--;
                    ifGoalFive = false;
                    tvGoalFive.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }else{
                    if(selectionSum != 3){
                        selectionSum++;
                        ifGoalFive = true;
                        tvGoalFive.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                    }

                }
            }
        });
        tvGoalSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifGoalSix){
                    if(selectionSum>0)
                        selectionSum--;
                    ifGoalSix = false;
                    tvGoalSix.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }else{
                    if(selectionSum != 3){
                        selectionSum++;
                        ifGoalSix = true;
                        tvGoalSix.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                    }

                }
            }
        });
        tvGoalSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifGoalSeven){
                    if(selectionSum>0)
                        selectionSum--;
                    ifGoalSeven = false;
                    tvGoalSeven.setBackgroundResource(R.drawable.bg_onboard_goal_not_selected);
                }else{
                    if(selectionSum != 3){
                        selectionSum++;
                        ifGoalSeven = true;
                        tvGoalSeven.setBackgroundResource(R.drawable.bg_onboard_goal_selected);
                    }

                }
            }
        });



        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager2 viewPager2 = getActivity().findViewById(R.id.viewPagerOnboard);

                if(ifGoalOne) arr[0] = 1;
                if(ifGoalTwo) arr[1] = 1;
                if(ifGoalThree) arr[2] = 1;
                if(ifGoalFour) arr[3] = 1;
                if(ifGoalFive) arr[4] = 1;
                if(ifGoalSix) arr[5] = 1;
                if(ifGoalSeven) arr[6] = 1;

                goals = arr.toString();

                //Toast.makeText(getActivity(), "string is : "+goals, Toast.LENGTH_SHORT).show();
                setGoals();
                viewPager2.setCurrentItem(1);
            }
        });

        return view;
    }

    private void setGoals(){
        SharedPreferences sp  = getContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("GOALS",goals);
        editor.commit();
    }
}
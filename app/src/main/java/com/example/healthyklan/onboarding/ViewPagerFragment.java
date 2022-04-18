package com.example.healthyklan.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.healthyklan.R;
import com.example.healthyklan.activity.SignUpActivity;
import com.example.healthyklan.onboarding.screen.ActivityLevelScreen;
import com.example.healthyklan.onboarding.screen.GenderAgeScreen;
import com.example.healthyklan.onboarding.screen.GoalsScreen;
import com.example.healthyklan.onboarding.screen.HeightWeightScreen;

import java.util.ArrayList;

public class ViewPagerFragment extends Fragment {

    private ViewPager2 viewPager;
    private TextView tvGoToLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        viewPager = view.findViewById(R.id.viewPagerOnboard);
        tvGoToLogin = view.findViewById(R.id.tvalreadyAUser);

        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new GoalsScreen());
        fragmentList.add(new ActivityLevelScreen());
        fragmentList.add(new GenderAgeScreen());
        fragmentList.add(new HeightWeightScreen());


        ViewPagerAdapter adapter = new ViewPagerAdapter(
                fragmentList,
                requireActivity().getSupportFragmentManager(),
                getLifecycle()
        );

        viewPager.setAdapter(adapter);

        tvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), SignUpActivity.class));

            }
        });

        return view;
    }
}
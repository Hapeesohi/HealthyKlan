package com.example.healthyklan.BottomNavigationItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.healthyklan.R;
import com.example.healthyklan.nutrition.NutritionAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class NutritionFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition, container, false);

        tabLayout = view.findViewById(R.id.tabLayoutNutrition);
        viewPager = view.findViewById(R.id.viewPagerNutrition);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.text_calories));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.text_macros));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Calories");
        arrayList.add("Macros");

        NutritionAdapter adapter = new NutritionAdapter(getActivity().getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
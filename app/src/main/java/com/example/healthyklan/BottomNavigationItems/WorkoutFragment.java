package com.example.healthyklan.BottomNavigationItems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.healthyklan.R;
import com.example.healthyklan.Workout.WorkoutAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class WorkoutFragment extends Fragment {

    TabLayout tabLayoutWorkout;
    ViewPager2 viewPagerWorkout;
    FloatingActionButton fabAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout, container, false);

        tabLayoutWorkout = view.findViewById(R.id.tabLayoutWorkout);
        viewPagerWorkout = view.findViewById(R.id.viewPagerWorkout);
        fabAdd= view.findViewById(R.id.btnWorkoutAdd);

        tabLayoutWorkout.addTab(tabLayoutWorkout.newTab().setText(R.string.text_most_used));
        tabLayoutWorkout.addTab(tabLayoutWorkout.newTab().setText(R.string.text_my_excercise));
        tabLayoutWorkout.addTab(tabLayoutWorkout.newTab().setText(R.string.text_browse_all));
        tabLayoutWorkout.setTabGravity(TabLayout.GRAVITY_FILL);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Most Used");
        arrayList.add("My Excercise");
        arrayList.add("Browse All");

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "No workout found in the data base yet!", Toast.LENGTH_LONG).show();
            }
        });

        WorkoutAdapter adapter = new WorkoutAdapter(getActivity().getSupportFragmentManager(),getLifecycle());
        viewPagerWorkout.setAdapter(adapter);

        tabLayoutWorkout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerWorkout.setCurrentItem(tab.getPosition());
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
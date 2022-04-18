package com.example.healthyklan.Workout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WorkoutAdapter extends FragmentStateAdapter {
    public WorkoutAdapter(FragmentManager supportFragmentManager, Lifecycle lifecycle) {
        super(supportFragmentManager,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new MostUsedFragment();
        }else if(position == 1){
            return new MyExcerciseFragment();
        }else if(position ==2){
            return new BrowsAllFragment();
        }

        return new MostUsedFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

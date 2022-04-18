package com.example.healthyklan.Diary;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyTabAdapter extends FragmentStateAdapter {

    public MyTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 0){
            return new NutritionDiaryFragment();
        }else if(position == 1){
            return new WorkoutDiaryFragment();
        }

        return new NutritionDiaryFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

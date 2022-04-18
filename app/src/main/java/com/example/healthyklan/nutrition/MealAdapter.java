package com.example.healthyklan.nutrition;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MealAdapter extends FragmentStateAdapter {
    public MealAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new MyMealFragment();
        }else if(position == 1){
            return new SearchMealFragment();
        }

        return new MyMealFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

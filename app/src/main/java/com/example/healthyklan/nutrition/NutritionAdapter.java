package com.example.healthyklan.nutrition;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NutritionAdapter extends FragmentStateAdapter {

    public NutritionAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new CaloriesFragment();
        }else if(position == 1){
            return new MacrosFragment();
        }

        return new CaloriesFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

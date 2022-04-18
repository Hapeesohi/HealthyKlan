package com.example.healthyklan.fargment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.healthyklan.R;
import com.example.healthyklan.activity.HomeActivity;
import com.example.healthyklan.activity.SignUpActivity;


public class SplashFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        Handler handler = new Handler();
        if(OnBoarded()){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(OnSignUp()){
                        startActivity(new Intent(getContext(), HomeActivity.class));
                    }else{
                        startActivity(new Intent(getContext(),SignUpActivity.class));
                    }
                }
            },1000);
            //getActivity().finish();
        }else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(OnSignUp()){
                        startActivity(new Intent(getContext(), HomeActivity.class));
                        //getActivity().finish();
                    }else{
                        Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_viewPagerFragment);
                    }
                }
            },1000);
        }



        return view;
    }

    private boolean OnBoarded(){
        SharedPreferences sp = getContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        return sp.getBoolean("ONBOARDED",false);
    }
    private boolean OnSignUp(){
        SharedPreferences sptwo = getContext().getSharedPreferences("onSignup", Context.MODE_PRIVATE);
        return sptwo.getBoolean("SIGNUP",false);
    }
}
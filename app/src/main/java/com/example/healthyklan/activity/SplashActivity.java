package com.example.healthyklan.activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyklan.R;

/*
This activity will be used to display splash screen
xml file linked to this file is activity_splash
After showing the splash screen next screen will be either home page or survey screen
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // to hide the action bar and open the activity in full screen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        Handler handler = new Handler();
//        if(OnBoarded()){
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if(OnSignUp()){
//                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
//                    }else{
//                        startActivity(new Intent(SplashActivity.this,SignUpActivity.class));
//                    }
//                }
//            },1000);
//
//            finish();
//        }



    }

//    private boolean OnBoarded(){
//        SharedPreferences sp = getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
//        return sp.getBoolean("ONBOARDED",false);
//    }
//    private boolean OnSignUp(){
//        SharedPreferences sptwo = getSharedPreferences("onSignup", Context.MODE_PRIVATE);
//        return sptwo.getBoolean("SIGNUP",false);
//    }

}
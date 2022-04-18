package com.example.healthyklan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.healthyklan.BottomNavigationItems.AccountFragment;
import com.example.healthyklan.BottomNavigationItems.DiaryFragment;
import com.example.healthyklan.BottomNavigationItems.HomeFragment;
import com.example.healthyklan.BottomNavigationItems.NutritionFragment;
import com.example.healthyklan.BottomNavigationItems.WorkoutFragment;
import com.example.healthyklan.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity{

    // Navigation Drawer Menu
    NavigationView nav;
    ActionBarDrawerToggle barDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    // BOttom NAvigation
    BottomNavigationView bottomNavigationView;
    NavController navController;
    AppBarConfiguration appBarConfiguration;
    FrameLayout frameLayout;

    FirebaseDatabase fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();

         //Navigation drawer
        nav = findViewById(R.id.nv_menu);
        drawerLayout = findViewById(R.id.nav_drawer);
        toolbar = findViewById(R.id.toolbarHome);


        // Bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.frame_layout);
//
//        fAuth = FirebaseDatabase.getInstance();
//        fAuth.getReference("Users").

//        appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment,
//                R.id.diaryFragment,
//                R.id.nutritionFragment,
//                R.id.workoutFragment,
//                R.id.accountFragment
//        ).setOpenableLayout(drawerLayout)
//                .build();


        setSupportActionBar(toolbar);
//        navController = Navigation. findNavController(this, R.id.nav_host_fragment);

        //NavigationUI.setupWithNavController(nav,navController);
//        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        barDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(barDrawerToggle);
        barDrawerToggle.syncState();

            nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()  {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment temp = null;
                    switch (item.getItemId()){
                        case R.id.menu_home:
                            temp = new HomeFragment();
                            toolbar.setTitle(R.string.text_title_home);
                            break;
                        case R.id.menu_diary:
                            temp = new DiaryFragment();
                            toolbar.setTitle(R.string.text_title_diary);
                            break;
                        case R.id.menu_nutri:
                            temp = new NutritionFragment();
                            toolbar.setTitle(R.string.text_title_nutri);
                            break;
                        case R.id.menu_workout:
                            temp = new WorkoutFragment();
                            toolbar.setTitle(R.string.text_title_workout);
                            break;
                        case R.id.menu_setting:
                            temp = new AccountFragment();
                            toolbar.setTitle(R.string.text_title_account);
                            break;
                        case R.id.menu_signout:
                            SharedPreferences sp = getSharedPreferences("onSignup", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putBoolean("SIGNUP",false);
                            Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,temp).commit();

                    return true;

                }
            });


            bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment temp = null;
                    switch (item.getItemId()){
                        case R.id.btm_menu_home:
                            temp = new HomeFragment();
                            toolbar.setTitle(R.string.text_title_home);
                            break;
                        case R.id.btm_menu_diary:
                            temp = new DiaryFragment();
                            toolbar.setTitle(R.string.text_title_diary);
                            break;
                        case R.id.btm_menu_nutri:
                            temp = new NutritionFragment();
                            toolbar.setTitle(R.string.text_title_nutri);
                            break;
                        case R.id.btm_menu_workout:
                            temp = new WorkoutFragment();
                            toolbar.setTitle(R.string.text_title_workout);
                            break;
                        case R.id.btm_account:
                            temp = new AccountFragment();
                            toolbar.setTitle(R.string.text_title_account);
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,temp).commit();

                    return true;
                }
            });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
package com.kenjiro.tokolaptop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bottomNavbar = findViewById(R.id.bottomNav);
//        bottomNavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Activity activity = null;
//                switch (item.getItemId()){
//                    case R.id.navHome:
//                        activity = new DashboardActivity();
//                        break;
////                    case R.id.navFavorite:
////                        activity = new DashboardActivity();
////                        break;
//                    case R.id.navAccount:
//                        activity = new LoginActivity();
//                        break;
//                }
////                getSupportParentActivityIntent().
//                return true;
//            }
//        });
    }
}
package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class SuccessActivity extends AppCompatActivity {

    TextView btnDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_success);

        btnDashboard = findViewById(R.id.btnDashboard);
        btnDashboard.setOnClickListener(view -> {
            Intent intent = new Intent(SuccessActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
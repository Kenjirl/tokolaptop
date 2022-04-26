package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView btnLogout;
    LinearLayout detailProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final TextView nameDashboard = findViewById(R.id.textUsername);
        nameDashboard.setText(getIntent().getStringExtra("Username"));

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view ->  {
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        detailProduct = findViewById(R.id.layoutBest1);
        detailProduct.setOnClickListener(view -> {
            Intent intent = new Intent(DashboardActivity.this, DetailProductActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
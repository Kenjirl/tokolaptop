package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    ImageView icAccount;
    ImageView icHome;
    LinearLayout detailProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final TextView nameDashboard = findViewById(R.id.textUsername);
        nameDashboard.setText(getIntent().getStringExtra("Username"));

        icAccount = findViewById(R.id.icAccount);
        icAccount.setOnClickListener(view ->  {
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        icHome = findViewById(R.id.icHome);
        icHome.setOnClickListener(view ->  {
            Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
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
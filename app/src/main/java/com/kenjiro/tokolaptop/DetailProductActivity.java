package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailProductActivity extends AppCompatActivity {

    ImageView btnBack;
    ImageView icAccount;
    ImageView icHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(DetailProductActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        icAccount = findViewById(R.id.icAccount);
        icAccount.setOnClickListener(view ->  {
            Intent intent = new Intent(DetailProductActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        icHome = findViewById(R.id.icHome);
        icHome.setOnClickListener(view ->  {
            Intent intent = new Intent(DetailProductActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
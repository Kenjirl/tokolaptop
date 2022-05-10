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
    LinearLayout listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final TextView nameDashboard = findViewById(R.id.textUsername);
        Intent intent = getIntent();
        if (intent.hasExtra("Username")) {
            nameDashboard.setText(getIntent().getStringExtra("Username"));
        } else {
            nameDashboard.setText("User");
        }

        icAccount = findViewById(R.id.icAccount);
        icAccount.setOnClickListener(view ->  {
            Intent intents = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(intents);
            finish();
        });

        icHome = findViewById(R.id.icHome);
        icHome.setOnClickListener(view ->  {
            Intent intents = new Intent(DashboardActivity.this, DashboardActivity.class);
            startActivity(intents);
            finish();
        });

        detailProduct = findViewById(R.id.layoutBest1);
        detailProduct.setOnClickListener(view -> {
            Intent intents = new Intent(DashboardActivity.this, DetailProductActivity.class);
            startActivity(intents);
            finish();
        });

        listProduct = findViewById(R.id.layoutAsus);
        listProduct.setOnClickListener(view -> {
            Intent intents = new Intent(DashboardActivity.this, ListProdukActivity.class);
            startActivity(intents);
            finish();
        });
    }
}
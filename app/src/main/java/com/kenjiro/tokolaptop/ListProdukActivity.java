package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Objects;

public class ListProdukActivity extends AppCompatActivity {

    ImageView btnBack;
    LinearLayout productOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_list_produk);

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(ListProdukActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        productOne = findViewById(R.id.productOne);
        productOne.setOnClickListener(view -> {
            Intent intent = new Intent(ListProdukActivity.this, DetailProductActivity.class);
            startActivity(intent);
        });
    }
}
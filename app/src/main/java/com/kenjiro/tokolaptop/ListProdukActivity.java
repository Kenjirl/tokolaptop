package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ListProdukActivity extends AppCompatActivity {

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produk);

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(ListProdukActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
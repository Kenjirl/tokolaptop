package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class DetailProductActivity extends AppCompatActivity {

    ImageView btnBack;
    ImageView icFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_detail_product);

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(DetailProductActivity.this, ListProdukActivity.class);
            startActivity(intent);
            finish();
        });

        AtomicBoolean colorRed = new AtomicBoolean(false);

        icFav = (ImageView) findViewById(R.id.icFav);
        icFav.setOnClickListener(view -> {
            if(!colorRed.get()){
                icFav.setColorFilter(getResources().getColor(R.color.red));
                Toast.makeText(DetailProductActivity.this, "Ditambahkan ke Favorite", Toast.LENGTH_SHORT).show();
                colorRed.set(true);
            }else {
                icFav.setColorFilter(getResources().getColor(R.color.black));
                Toast.makeText(DetailProductActivity.this, "Dihapus dari Favorite", Toast.LENGTH_SHORT).show();
                colorRed.set(false);
            }
        });
    }

    public void addToCart(View view) {
        Toast.makeText(DetailProductActivity.this, "Ditambahkan ke Keranjang", Toast.LENGTH_SHORT).show();
    }
}
package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class DetailProductActivity extends AppCompatActivity {

    ImageView btnBack, viewImage;
    TextView deskripsiFgBtn, tokoFgBtn, viewNama, viewHarga;
    int res_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_detail_product);
        Bundle extras = getIntent().getExtras();

        // Set fragment awal
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fragmentLayout,new DeskripsiFragment());
        FT.commit();

        // terima extra
        viewImage = findViewById(R.id.productImage);
        viewNama = findViewById(R.id.productNama);
        viewHarga = findViewById(R.id.productHarga);

        res_image = extras.getInt("image");
        viewImage.setImageResource(res_image);
        viewNama.setText(getIntent().getStringExtra("nama"));
        viewHarga.setText(getIntent().getStringExtra("harga"));

        // on click listener button back
        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(DetailProductActivity.this, ListProdukActivity.class);
            startActivity(intent);
            finish();
        });

        // on click listener untuk mengganti fragment yang terlihat
        deskripsiFgBtn = findViewById(R.id.fragmentDeskripsiBtn);
        tokoFgBtn = findViewById(R.id.fragmentTokoBtn);

        deskripsiFgBtn.setOnClickListener(view -> replaceFragment(new DeskripsiFragment()));

        tokoFgBtn.setOnClickListener(view -> replaceFragment(new TokoFragment()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fragmentLayout,fragment);
        FT.commit();
    }

    public void addToCart(View view) {
        String textNama = viewNama.getText().toString();
        String textHarga = viewHarga.getText().toString();

        Toast.makeText(DetailProductActivity.this, "Ditambahkan ke Keranjang", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(DetailProductActivity.this, KeranjangActivity.class);
        intent.putExtra("image", res_image);
        intent.putExtra("nama", textNama);
        intent.putExtra("harga", textHarga);
        startActivity(intent);
        finish();
    }
}
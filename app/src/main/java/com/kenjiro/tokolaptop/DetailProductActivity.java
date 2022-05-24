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
//import java.util.concurrent.atomic.AtomicBoolean;

public class DetailProductActivity extends AppCompatActivity {

    ImageView btnBack;
//    ImageView icFav;
    TextView deskripsiFgBtn, tokoFgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_detail_product);

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fragmentLayout,new DeskripsiFragment());
        FT.commit();

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(DetailProductActivity.this, ListProdukActivity.class);
            startActivity(intent);
            finish();
        });

//        AtomicBoolean colorRed = new AtomicBoolean(false);
//
//        icFav = (ImageView) findViewById(R.id.icFav);
//        icFav.setOnClickListener(view -> {
//            if(!colorRed.get()){
//                icFav.setColorFilter(getResources().getColor(R.color.red));
//                Toast.makeText(DetailProductActivity.this, "Ditambahkan ke Favorite", Toast.LENGTH_SHORT).show();
//                colorRed.set(true);
//            }else {
//                icFav.setColorFilter(getResources().getColor(R.color.black));
//                Toast.makeText(DetailProductActivity.this, "Dihapus dari Favorite", Toast.LENGTH_SHORT).show();
//                colorRed.set(false);
//            }
//        });

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
        Toast.makeText(DetailProductActivity.this, "Ditambahkan ke Keranjang", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DetailProductActivity.this, KeranjangActivity.class);
        startActivity(intent);
        finish();
    }
}
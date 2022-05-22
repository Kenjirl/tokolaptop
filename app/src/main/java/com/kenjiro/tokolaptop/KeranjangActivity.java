package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Objects;

public class KeranjangActivity extends AppCompatActivity {

    ImageView btnBack;
//    LinearLayout icHome;
//    LinearLayout icKeranjang;
//    LinearLayout icAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_keranjang);

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(KeranjangActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });

//        icHome = findViewById(R.id.icHome);
//        icHome.setOnClickListener(view ->  {
//            Intent intents = new Intent(KeranjangActivity.this, DashboardActivity.class);
//            startActivity(intents);
//            finish();
//        });
//
//        icKeranjang = findViewById(R.id.icKeranjang);
//        icKeranjang.setOnClickListener(view ->  {
//            Intent intents = new Intent(KeranjangActivity.this, KeranjangActivity.class);
//            startActivity(intents);
//            finish();
//        });
//
//        icAccount = findViewById(R.id.icAccount);
//        icAccount.setOnClickListener(view ->  {
//            Intent intents = new Intent(KeranjangActivity.this, AkunActivity.class);
//            startActivity(intents);
//            finish();
//        });
    }
}
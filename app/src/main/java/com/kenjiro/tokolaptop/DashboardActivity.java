package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout icAccount, icHome, icKeranjang, listProduct, layoutBest1, layoutBest2, layoutBest3, layoutBest4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_dashboard);

        final TextView nameDashboard = findViewById(R.id.textUsername);
        String user = "User";
        Intent intent = getIntent();
        if (intent.hasExtra("Username")) {
            nameDashboard.setText(getIntent().getStringExtra("Username"));
        } else {
            nameDashboard.setText(user);
        }

        icAccount = findViewById(R.id.icAccount);
        icAccount.setOnClickListener(view ->  {
            Intent intents = new Intent(DashboardActivity.this, AkunActivity.class);
            startActivity(intents);
        });

        icHome = findViewById(R.id.icHome);
        icHome.setOnClickListener(view ->  {
            Intent intents = new Intent(DashboardActivity.this, DashboardActivity.class);
            startActivity(intents);
        });

        icKeranjang = findViewById(R.id.icKeranjang);
        icKeranjang.setOnClickListener(view ->  {
            Intent intents = new Intent(DashboardActivity.this, KeranjangActivity.class);
            startActivity(intents);
        });

        listProduct = findViewById(R.id.layoutAsus);
        listProduct.setOnClickListener(view -> {
            Intent intents = new Intent(DashboardActivity.this, ListProdukActivity.class);
            startActivity(intents);
        });

        layoutBest1 = findViewById(R.id.layoutBest1);
        layoutBest1.setOnClickListener(view -> {
            String iDImage = "asusimg_1";
            int intDrawImg = getResources().getIdentifier(iDImage, "drawable", getPackageName());

            Intent intents = new Intent(DashboardActivity.this, DetailProductActivity.class);
            intents.putExtra("image", intDrawImg);
            intents.putExtra("nama", "Asus F412D");
            intents.putExtra("harga", "Rp 5.000.000");
            startActivity(intents);
        });

        layoutBest2 = findViewById(R.id.layoutBest2);
        layoutBest2.setOnClickListener(view -> {
            String iDImage = "acer_aspire_a515";
            int intDrawImg = getResources().getIdentifier(iDImage, "drawable", getPackageName());

            Intent intents = new Intent(DashboardActivity.this, DetailProductActivity.class);
            intents.putExtra("image", intDrawImg);
            intents.putExtra("nama", "Aspire A515");
            intents.putExtra("harga", "Rp 10.750.000");
            startActivity(intents);
        });

        layoutBest3 = findViewById(R.id.layoutBest3);
        layoutBest3.setOnClickListener(view -> {
            String iDImage = "macbook_air_2017";
            int intDrawImg = getResources().getIdentifier(iDImage, "drawable", getPackageName());

            Intent intents = new Intent(DashboardActivity.this, DetailProductActivity.class);
            intents.putExtra("image", intDrawImg);
            intents.putExtra("nama", "Mac Air 2017");
            intents.putExtra("harga", "Rp 11.999.000");
            startActivity(intents);
        });

        layoutBest4 = findViewById(R.id.layoutBest4);
        layoutBest4.setOnClickListener(view -> {
            String iDImage = "hp_pavilion_15";
            int intDrawImg = getResources().getIdentifier(iDImage, "drawable", getPackageName());

            Intent intents = new Intent(DashboardActivity.this, DetailProductActivity.class);
            intents.putExtra("image", intDrawImg);
            intents.putExtra("nama", "hp Pavilion 15");
            intents.putExtra("harga", "Rp 8.399.000");
            startActivity(intents);
        });
    }
}
package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class KeranjangActivity extends AppCompatActivity {

    ImageView btnBack, viewImage;
    TextView viewNama, viewHarga, textSubTotal, textOngkir, textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_keranjang);

        Bundle extras = getIntent().getExtras();

        viewImage = findViewById(R.id.cartProductImg);
        viewNama = findViewById(R.id.cartProductName);
        viewHarga = findViewById(R.id.cartProductPrice);

        int res_image = extras.getInt("image");
        viewImage.setImageResource(res_image);
        viewNama.setText(getIntent().getStringExtra("nama"));
        viewHarga.setText(getIntent().getStringExtra("harga"));

        NumberFormat formatter = new DecimalFormat("#,###");

        String strHarga = viewHarga.getText().toString();
        strHarga = strHarga.replace("Rp ", "");
        strHarga = strHarga.replace(".", "");
        double subtotal = Double.parseDouble(strHarga);

        String strSubtotal = formatter.format(subtotal);
        strSubtotal = "Rp " + strSubtotal;

        double ongkir = 100000;
        String strOngkir = formatter.format(ongkir);
        strOngkir = "Rp " + strOngkir;

        double total = subtotal + ongkir;
        String strTotal = formatter.format(total);
        strTotal = "Rp " + strTotal;

        textSubTotal = findViewById(R.id.textSubTotal);
        textSubTotal.setText(strSubtotal);
        textOngkir = findViewById(R.id.textOngkir);
        textOngkir.setText(strOngkir);
        textTotal = findViewById(R.id.textTotal);
        textTotal.setText(strTotal);

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intents = new Intent(KeranjangActivity.this, DashboardActivity.class);
            startActivity(intents);
            finish();
        });
    }
}
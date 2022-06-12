package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

public class KeranjangActivity extends AppCompatActivity {

    ImageView btnBack, viewImage;
    TextView viewNama, viewHarga, textSubTotal, textOngkir, textTotal, btnCheckout;
    LinearLayout linearLayout;
    ArrayList<Checkout> list;
    LinearLayout []lLayout;
    TextView []tvNama;
    TextView []tvHarga;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_keranjang);

        Intent intent = getIntent();
        list = (ArrayList<Checkout>) intent.getSerializableExtra("Checkout");

//      jika 1 produk yang dipilih, dari halaman detail
        if (intent.hasExtra("nama")){
            Bundle extras = getIntent().getExtras();

            linearLayout = findViewById(R.id.cartProductLayout0);
            viewImage = findViewById(R.id.cartProductImg0);
            viewNama = findViewById(R.id.cartProductName0);
            viewHarga = findViewById(R.id.cartProductPrice0);

            linearLayout.setVisibility(View.VISIBLE);
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
        }
//      jika banyak produk yang dipilih, dari halaman list
        else {
            lLayout = new LinearLayout[6];
            tvNama = new TextView[6];
            tvHarga = new TextView[6];
            for (int i=0; i<6; i++){
                int idLayout = getResources().getIdentifier("cartProductLayout" + i, "id", getBaseContext().getPackageName());
                lLayout[i] = findViewById(idLayout);
                int idTextNama = getResources().getIdentifier("cartProductName" + i, "id", getBaseContext().getPackageName());
                tvNama[i] = findViewById(idTextNama);
                int idTextHarga = getResources().getIdentifier("cartProductPrice" + i, "id", getBaseContext().getPackageName());
                tvHarga[i] = findViewById(idTextHarga);
            }

            size = list.size();
            double subtotal = 0;
            for (int i=0; i<size; i++){
                lLayout[i+1].setVisibility(View.VISIBLE);
                tvNama[i+1].setText(list.get(i).getNama());
                tvHarga[i+1].setText(list.get(i).getHarga());

                String strHarga = list.get(i).getHarga();
                strHarga = strHarga.replace("Rp ", "");
                strHarga = strHarga.replace(".", "");
                subtotal += Double.parseDouble(strHarga);
            }
            double ongkir = 100000;
            double total = subtotal + ongkir;

            NumberFormat formatter = new DecimalFormat("#,###");
            String strSubtotal = formatter.format(subtotal);
            strSubtotal = "Rp " + strSubtotal;
            String strOngkir = formatter.format(ongkir);
            strOngkir = "Rp " + strOngkir;
            String strTotal = formatter.format(total);
            strTotal = "Rp " + strTotal;

            textSubTotal = findViewById(R.id.textSubTotal);
            textSubTotal.setText(strSubtotal);
            textOngkir = findViewById(R.id.textOngkir);
            textOngkir.setText(strOngkir);
            textTotal = findViewById(R.id.textTotal);
            textTotal.setText(strTotal);
        }

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intents = new Intent(KeranjangActivity.this, DashboardActivity.class);
            startActivity(intents);
            finish();
        });

        btnCheckout = findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(view -> {
            Intent intents = new Intent(KeranjangActivity.this, SuccessActivity.class);
            startActivity(intents);
            finish();
        });
    }
}
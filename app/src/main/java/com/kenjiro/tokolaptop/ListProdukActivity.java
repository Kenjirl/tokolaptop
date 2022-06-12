package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class ListProdukActivity extends AppCompatActivity {

    ImageView btnBack;
    ImageView btnCart;
    ArrayList<Checkout> list;
    Checkout data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_list_produk);

        boolean[] selected = new boolean[7];
        list = new ArrayList<>();

        // Click button back
        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(ListProdukActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        // Click Event untuk setiap layout Image yang ada.
        for (int i=1; i<7; i++){
            int idProduk = getResources().getIdentifier("product_" + i, "id", getBaseContext().getPackageName());
            LinearLayout produkLayout = findViewById(idProduk);
            int finalI_1 = i;
            produkLayout.setOnClickListener(view -> {
                String iDImage = "asusimg_" + finalI_1;
                int intDrawImg = getResources().getIdentifier(iDImage, "drawable", getPackageName());

                int iDNama = getResources().getIdentifier("nama_" + finalI_1, "id", getBaseContext().getPackageName());
                TextView nama = findViewById(iDNama);
                String textNama = nama.getText().toString();

                int iDHarga = getResources().getIdentifier("harga_" + finalI_1, "id", getBaseContext().getPackageName());
                TextView harga = findViewById(iDHarga);
                String textHarga = harga.getText().toString();

                // Start intent.
                Intent intent = new Intent(ListProdukActivity.this, DetailProductActivity.class);
                intent.putExtra("image", intDrawImg);
                intent.putExtra("nama", textNama);
                intent.putExtra("harga", textHarga);
                startActivity(intent);
                finish();
            });

            int final_2 = i;
            produkLayout.setOnLongClickListener(view -> {
                int iDNama = getResources().getIdentifier("nama_" + final_2, "id", getBaseContext().getPackageName());
                TextView nama = findViewById(iDNama);
                String textNama = nama.getText().toString();

                int iDHarga = getResources().getIdentifier("harga_" + final_2, "id", getBaseContext().getPackageName());
                TextView harga = findViewById(iDHarga);
                String textHarga = harga.getText().toString();

                if (!selected[final_2]) {
                    produkLayout.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.gray));
                    selected[final_2] = true;
                    data = new Checkout(textNama, textHarga);
                    list.add(data);
                }
                else {
                    produkLayout.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.white));
                    selected[final_2] = false;
                    data = new Checkout(textNama, textHarga);
                    list.remove(data);
                }
                return true;
            });
        }

        // Click button cart
        btnCart = findViewById(R.id.icCart);
        btnCart.setOnClickListener(view -> {
            Toast.makeText(ListProdukActivity.this, "Ditambahkan ke Keranjang", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ListProdukActivity.this, KeranjangActivity.class);
            intent.putExtra("Checkout", list);
            startActivity(intent);
            finish();
        });
    }
}
package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import java.util.ArrayList;
import java.util.Objects;

public class ListProdukActivity extends AppCompatActivity {

    ImageView btnBack;
//    ImageView btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_list_produk);

//        ArrayList<String> produkArrayList = new ArrayList<String>();
//        boolean[] selected = new boolean[7];

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
//                String strDrawImg = String.valueOf(intDrawImg);

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
            });

//            int final_2 = i;
//            produkLayout.setOnLongClickListener(view -> {
//                if (!selected[final_2]) {
//                    produkLayout.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.gray));
//                    selected[final_2] = true;
//                }
//                else {
//                    produkLayout.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.white));
//                    selected[final_2] = false;
//                }
//
//                produkArrayList.clear();
//                for (int j = 1; j < 7; j++){
//                    if (selected[j]){
//                        produkArrayList.add(j);
//                    }
//                }
//                return true;
//            });
        }

        // Click button cart
//        btnCart = findViewById(R.id.icCart);
//        btnCart.setOnClickListener(view -> {
//            System.out.println(produkArrayList);
//            Intent intent = new Intent(ListProdukActivity.this, ProdukDetail.class);
//            intent.putStringArrayListExtra("nama", (ArrayList<String>) produkArrayList );
//            startActivity(intent);
//        });
    }
}
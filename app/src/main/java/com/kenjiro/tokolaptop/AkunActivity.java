package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class AkunActivity extends AppCompatActivity {

    LinearLayout icHome;
    LinearLayout icKeranjang;
    LinearLayout icAccount;
    TextView btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_akun);

        icHome = findViewById(R.id.icHome);
        icHome.setOnClickListener(view ->  {
            Intent intents = new Intent(AkunActivity.this, DashboardActivity.class);
            startActivity(intents);
            finish();
        });

        icKeranjang = findViewById(R.id.icKeranjang);
        icKeranjang.setOnClickListener(view ->  {
            Intent intents = new Intent(AkunActivity.this, KeranjangActivity.class);
            startActivity(intents);
            finish();
        });

        icAccount = findViewById(R.id.icAccount);
        icAccount.setOnClickListener(view ->  {
            Intent intents = new Intent(AkunActivity.this, AkunActivity.class);
            startActivity(intents);
            finish();
        });

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view -> {
            Intent intents = new Intent(AkunActivity.this, LoginActivity.class);
            startActivity(intents);
            Toast.makeText(AkunActivity.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
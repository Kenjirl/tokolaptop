package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    TextView txtRegister;
    TextView btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_login);

        txtRegister = findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });

        // menerima username dan password dari halaman Register
        final TextInputEditText Lusername = findViewById(R.id.edtSignInName);
        final TextInputEditText Lpassword = findViewById(R.id.edtSignInPassword);

        Lusername.setText(getIntent().getStringExtra("Username"));
        Lpassword.setText(getIntent().getStringExtra("Password"));

        String Rusername = "Kenji";
        String Rpassword = "passkenji";

        if (getIntent().hasExtra("Username") && getIntent().hasExtra("Password")) {
            Rusername = getIntent().getStringExtra("Username");
            Rpassword = getIntent().getStringExtra("Password");
        }

        btnLogin = findViewById(R.id.btnLogin);
        String finalRusername = Rusername;
        String finalRpassword = Rpassword;
        btnLogin.setOnClickListener(view ->  {
            // Cek input agar tidak boleh null
            String strUsername = Objects.requireNonNull(Lusername.getText()).toString();
            if(TextUtils.isEmpty(strUsername)){
                Lusername.setError("Username tidak boleh kosong");
                return;
            }
            String strPassword = Objects.requireNonNull(Lpassword.getText()).toString();
            if(TextUtils.isEmpty(strPassword)){
                Lpassword.setError("Password tidak boleh kosong");
                return;
            }

            // Cek kesesuaian username dan password
            if (Objects.requireNonNull(Lusername.getText()).toString().equals(finalRusername) && Objects.requireNonNull(Lpassword.getText()).toString().equals(finalRpassword)){
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                intent.putExtra("Username", Objects.requireNonNull(Lusername.getText()).toString());
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(LoginActivity.this, "Username atau Password tidak sesuai", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
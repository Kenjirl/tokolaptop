package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    TextView txtLogin;
    TextView btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_register);

        final TextInputEditText Rusername  = findViewById(R.id.edtSignUpName);
        final TextInputEditText Remail     = findViewById(R.id.editSignUpEmail);
        final TextInputEditText Rpassword  = findViewById(R.id.edtSignUpPassword);
        final TextInputEditText Rcpassword = findViewById(R.id.editSignUpConfirmPassword);

        txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(view -> {
            // Cek input agar tidak boleh null
            String strUsername = Objects.requireNonNull(Rusername.getText()).toString();
            if(TextUtils.isEmpty(strUsername)){
                Rusername.setError("Username tidak boleh kosong");
                return;
            }
            String strEmail = Objects.requireNonNull(Remail.getText()).toString();
            if(TextUtils.isEmpty(strEmail)){
                Remail.setError("Email tidak boleh kosong");
                return;
            }
            String strPassword = Objects.requireNonNull(Rpassword.getText()).toString();
            if(TextUtils.isEmpty(strPassword)){
                Rpassword.setError("Password tidak boleh kosong");
                return;
            }
            String strcPassword = Objects.requireNonNull(Rcpassword.getText()).toString();
            if(!strcPassword.matches(strPassword)){
                Rcpassword.setError("Konfirmasi Password harus sama");
                return;
            }

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            intent.putExtra("Username", strUsername);
            intent.putExtra("Password", strPassword);
            startActivity(intent);
            finish();
        });
    }
}
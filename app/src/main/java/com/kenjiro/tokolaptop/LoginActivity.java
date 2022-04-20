package com.kenjiro.tokolaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    TextView txtRegister;
    TextView btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtRegister = findViewById(R.id.txtRegister);
        btnLogin = findViewById(R.id.btnLogin);
        final TextInputEditText Lusername = findViewById(R.id.edtSignInName);
        final TextInputEditText Lpassword = findViewById(R.id.edtSignInPassword);

        // menerima username dan password dari halaman Register
        Lusername.setText(getIntent().getStringExtra("Username"));
        Lpassword.setText(getIntent().getStringExtra("Password"));

        txtRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });

        btnLogin.setOnClickListener(view ->  {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.putExtra("Username", Objects.requireNonNull(Lusername.getText()).toString());
            startActivity(intent);
            finish();
        });
    }
}
package com.example.Travelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class registerActivity extends AppCompatActivity {

    Button btnLoginA;
    Button btnRegisterM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent logintent = new Intent(registerActivity.this, loginActivity.class);
        Intent regintent = new Intent(registerActivity.this, mainActivity.class);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLoginA = findViewById(R.id.btnLoginA);
        btnRegisterM = findViewById(R.id.btnRegisterM);

        btnLoginA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if(!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()){
                registerActivity.this.startActivity(logintent);
                //}


            }
        });

        btnRegisterM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if(!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()){
                registerActivity.this.startActivity(regintent);
                //}


            }
        });
    }
}
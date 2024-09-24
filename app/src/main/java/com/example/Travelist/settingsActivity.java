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

public class settingsActivity extends AppCompatActivity {

    Button btnReturnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent returnIntent = new Intent(settingsActivity.this, mainActivity.class);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnReturnS = findViewById(R.id.btnReturnS);

        btnReturnS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if(!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()){
                settingsActivity.this.startActivity(returnIntent);
                //}


            }
        });
    }
}
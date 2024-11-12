package com.example.TicTacToe;

import static com.example.TicTacToe.fBaseAuth.CreateUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.xml.validation.Validator;

public class registerActivity extends AppCompatActivity {

    Button btnLoginA;
    Button btnRegisterM;
    private InputValidator validator;
    private fBaseAuth CreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent logintent = new Intent(registerActivity.this, loginActivity.class);

        validator = new InputValidator();
        auth = FirebaseAuth.getInstance();


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
                registerActivity.this.startActivity(logintent);

            }
        });

        EditText etEmail = findViewById(R.id.etEmailR);
        EditText etPassword = findViewById(R.id.etPasswordR);
        EditText etPassword2 = findViewById(R.id.etPasswordR2);
        CreateUser = new fBaseAuth();



        btnRegisterM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String password2= etPassword2.getText().toString();

                if (!validator.isValidEmail(email)) {
                    etEmail.setError("This email is not valid");
                }
                else if (!validator.isValidPassword(password)) {
                    etPassword.setError("Password must contain at least 6 letters");
                }
                else if (!validator.isValidPassword2(password,password2)) {
                    etPassword2.setError("Passwords must be identical");
                }
                else {
                    CreateUser(email, password,registerActivity.this);
                }
            }
        });




    }
}
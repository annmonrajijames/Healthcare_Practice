package com.example.annmonshealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
EditText edUsername, edemail, edPassword, edConfirm;
Button btn;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUsername);
        edemail = findViewById(R.id.editTextRegemailid);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonReg);
        tv = findViewById(R.id.textViewAlreadyaccount);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edemail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm) == 0) {

                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }
        public static boolean isValid(String passwordhere) {
            int f1=0, f2=0, f3=0;
            if (passwordhere.length()<0) {
                return false;
            } else {
                for (int p=0; p<passwordhere.length(); p++){
                    if (Character.isLetter(passwordhere.charAt(p))) {
                        f1=1;
                    }
                }
                for (int r=0; r<passwordhere.length(); r++){
                    if (Character.isDigit(passwordhere.charAt(r))) {
                        f2=1;
                    }
                }
                for (int s=0; s<passwordhere.length(); s++){
                    if (Character.isLetter(passwordhere.charAt(s))) {
                        f3=1;
                    }
                }
                if (f1==1 && f2==1 && f3==1)
                    return true;
                return false;

            }
        }
    }
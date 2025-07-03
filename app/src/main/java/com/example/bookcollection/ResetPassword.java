package com.example.bookcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class ResetPassword extends AppCompatActivity {

    EditText newPasswordInput, confirmPasswordInput;
    Button resetPasswordBtn;

    // Simulated storage (replace with secure SharedPreferences or DB in real app)
    public static String savedPassword = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        newPasswordInput = findViewById(R.id.newPasswordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        resetPasswordBtn = findViewById(R.id.resetPasswordBtn);

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPass = newPasswordInput.getText().toString();
                String confirmPass = confirmPasswordInput.getText().toString();

                if (newPass.isEmpty() || confirmPass.isEmpty()) {
                    Toast.makeText(ResetPassword.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!newPass.equals(confirmPass)) {
                    Toast.makeText(ResetPassword.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    savedPassword = newPass; // Simulated password reset
                    Toast.makeText(ResetPassword.this, "Password successfully reset", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ResetPassword.this, LogIn.class));
                    finish();
                }
            }
        });
    }
}
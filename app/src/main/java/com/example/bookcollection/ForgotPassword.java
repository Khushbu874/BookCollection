package com.example.bookcollection;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import java.util.Random;

public class ForgotPassword extends AppCompatActivity {

    EditText phoneInput, otpInput;
    Button sendOtpBtn, verifyOtpBtn;

    private static final int SMS_PERMISSION_CODE = 100;
    final long OTP_VALIDITY_DURATION = 60 * 1000; // 1 minute

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        phoneInput = findViewById(R.id.phoneInput);
        otpInput = findViewById(R.id.otpInput);
        sendOtpBtn = findViewById(R.id.sendOtpBtn);
        verifyOtpBtn = findViewById(R.id.verifyOtpBtn);

        verifyOtpBtn.setEnabled(false); // Disable verify button initially

        sendOtpBtn.setOnClickListener(v -> {
            String phone = phoneInput.getText().toString().trim();
            if (phone.length() == 10) {
                // Check SMS permission first
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CODE);
                } else {
                    sendOtp(phone);
                }
            } else {
                Toast.makeText(this, "Enter valid 10-digit phone number", Toast.LENGTH_SHORT).show();
            }
        });

        verifyOtpBtn.setOnClickListener(v -> {
            String enteredOtp = otpInput.getText().toString();
            if (OTPGenerator.isOtpExpired()) {
                Toast.makeText(this, "OTP expired. Try again.", Toast.LENGTH_SHORT).show();
                OTPGenerator.invalidateOtp();
                verifyOtpBtn.setEnabled(false);
            } else if (OTPGenerator.isOtpValid(enteredOtp)) {
                Toast.makeText(this, "OTP verified!", Toast.LENGTH_SHORT).show();
                OTPGenerator.invalidateOtp();
                // Go to reset password screen
                startActivity(new Intent(ForgotPassword.this, ResetPassword.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid OTP. Try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendOtp(String phone) {
        OTPGenerator.generateOtp();  // generates and stores OTP internally
        OTPGenerator.sendOtp(this, phone); // sends SMS with "+91" prefix internally
        verifyOtpBtn.setEnabled(true); // enable verify OTP button
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == SMS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String phone = phoneInput.getText().toString().trim();
                if (phone.length() == 10) {
                    sendOtp(phone);
                }
            } else {
                Toast.makeText(this, "SMS permission denied. Cannot send OTP.", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
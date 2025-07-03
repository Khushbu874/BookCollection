package com.example.bookcollection;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class OTPGenerator {

    private static String currentOtp = "";
    private static long otpTimestamp = 0;
    private static final long OTP_VALIDITY = 60 * 1000; // 1 minute

    public static void requestSmsPermission(Activity activity, int requestCode) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.SEND_SMS}, requestCode);
        }
    }

    public static String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        currentOtp = String.valueOf(otp);
        otpTimestamp = System.currentTimeMillis();
        Log.d("OTPGenerator", "Generated OTP: " +currentOtp);
        return currentOtp;
    }

    public static void sendOtp(Activity activity, String phoneNumber) {
        try {
            String fullNumber = phoneNumber.startsWith("+") ? phoneNumber : "+91" + phoneNumber;
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(fullNumber, null, "Your OTP is: " + currentOtp, null, null);
            Toast.makeText(activity, "OTP sent to " + fullNumber, Toast.LENGTH_SHORT).show();
            Toast.makeText(activity, "DEBUG: OTP is: " + currentOtp, Toast.LENGTH_LONG).show();
            Log.d("OTPGenerator", "OTP sent to: " + fullNumber);
        } catch (Exception e) {
            Toast.makeText(activity, "Failed to send OTP: " + e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("OTPGenerator", "Failed to send OTP", e);
        }
    }

    public static boolean isOtpValid(String enteredOtp) {
        long currentTime = System.currentTimeMillis();
        return currentOtp.equals(enteredOtp) && (currentTime - otpTimestamp) <= OTP_VALIDITY;
    }

    public static boolean isOtpExpired() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - otpTimestamp) > OTP_VALIDITY;
    }

    public static void invalidateOtp() {
        currentOtp = "";
        otpTimestamp = 0;
    }
}
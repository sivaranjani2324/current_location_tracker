package com.example.drone_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    private EditText otpEditText;
    private Button verifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        otpEditText = findViewById(R.id.otpEditText);
        verifyButton = findViewById(R.id.verifyButton);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredOTP = otpEditText.getText().toString();

                // Replace with the actual OTP received
                String generatedOTP = "1234";

                if (enteredOTP.equals(generatedOTP)) {
                    Toast.makeText(VerificationActivity.this, "Drone fetch your location soon", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(VerificationActivity.this,MapActivity.class);

                    // Start the activity
                    startActivity(i);

                    // Proceed with further actions
                } else {
                    Toast.makeText(VerificationActivity.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

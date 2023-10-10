package com.example.spotit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmailVerification extends AppCompatActivity {

    private TextView[] pinTextViews = new TextView[5]; // Array to hold the TextViews for displaying the PIN
    private int currentPinIndex = 0; // Variable to keep track of the current PIN index

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        // Initialize the TextViews for displaying the PIN
        pinTextViews[0] = findViewById(R.id.pin1);
        pinTextViews[1] = findViewById(R.id.pin2);
        pinTextViews[2] = findViewById(R.id.pin3);
        pinTextViews[3] = findViewById(R.id.pin4);
        pinTextViews[4] = findViewById(R.id.pin5);

        // Set up click listeners for dialpad buttons
        Button[] dialpadButtons = new Button[10]; // Array to hold the dialpad buttons
        dialpadButtons[0] = findViewById(R.id.btn0);
        dialpadButtons[1] = findViewById(R.id.btn1);
        dialpadButtons[2] = findViewById(R.id.btn2);
        dialpadButtons[3] = findViewById(R.id.btn3);
        dialpadButtons[4] = findViewById(R.id.btn4);
        dialpadButtons[5] = findViewById(R.id.btn5);
        dialpadButtons[6] = findViewById(R.id.btn6);
        dialpadButtons[7] = findViewById(R.id.btn7);
        dialpadButtons[8] = findViewById(R.id.btn8);
        dialpadButtons[9] = findViewById(R.id.btn9);

        for (Button button : dialpadButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String digit = button.getText().toString();
                    if (currentPinIndex < 5) {
                        pinTextViews[currentPinIndex].setText(digit);
                        currentPinIndex++;
                    }
                }
            });
        }
    }
}

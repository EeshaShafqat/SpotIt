package com.example.spotit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VoiceCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_call);

        Button endCall = findViewById(R.id.endCallButton);
        endCall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
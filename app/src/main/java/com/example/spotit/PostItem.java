package com.example.spotit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PostItem extends AppCompatActivity {

    LinearLayout uploadImage, uploadVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);

        uploadImage = findViewById(R.id.uploadImage);
        uploadVideo = findViewById(R.id.uploadVideo);


        //change this to uploadPhotoFragment and video fragment
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostItem.this, Upload.class);
                startActivity(intent);
            }
        });


        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostItem.this, Upload.class);
                startActivity(intent);
            }
        });



    }



}
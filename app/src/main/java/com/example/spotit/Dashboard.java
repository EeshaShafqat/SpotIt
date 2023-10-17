package com.example.spotit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //loading fragment

        Intent intent = getIntent();

        if (intent.hasExtra("FRAGMENT_TO_LOAD")) {
            String fragmentToLoad = intent.getStringExtra("FRAGMENT_TO_LOAD");

            Fragment selected = null;

            // Check the value of fragmentToLoad and load the corresponding fragment
            if ("home".equals(fragmentToLoad)) {
                // Load the HomeFragment
                selected = new HomeFragment();

            } else if ("profile".equals(fragmentToLoad)) {
                // Load another fragment
                selected = new ProfileFragment();
            }

            if(selected!=null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView5,selected).commit();
            }
        }



            //switching fragments with click
        BottomNavigationView navbar = findViewById(R.id.navbar);
        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected = null;
                int itemId = item.getItemId();

                if (itemId == R.id.home_layout) {

                    selected = new HomeFragment();

                } else if (itemId == R.id.search_layout) {

                    selected = new SearchFragment();
                }

                //post item screen
                else if (itemId == R.id.add_icon) {

                    Intent intent = new Intent(Dashboard.this, PostItem.class);
                    startActivity(intent);

                } else if (itemId == R.id.chat_layout) {

                    selected = new ChatFragment();

                    //profile page
                } else if (itemId == R.id.profile_layout) {

                    selected = new ProfileFragment();
                }

                if(selected!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView5,selected).commit();
                }

                return true;

            }
        });



    }
}
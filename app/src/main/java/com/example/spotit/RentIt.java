package com.example.spotit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

public class RentIt extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout sliderDotsPanel;

    private int dots_count;
    private ImageView[] dots;

    TextView Report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_it);

        Report = findViewById(R.id.report);

        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RentIt.this, Report.class);
                startActivity(intent);
            }
        });








        //slider code
        viewPager = findViewById(R.id.viewPager);

        sliderDotsPanel = (LinearLayout) findViewById(R.id.slider_dots);

        ViewPagerAdapter  viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        dots_count = viewPagerAdapter.getCount();
        dots = new ImageView[dots_count];



        for( int i=0; i<dots_count; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotsPanel.addView(dots[i],params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i=0; i<dots_count; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimertask(), 2000,4000);


    }

    public class MyTimertask extends TimerTask {

        @Override
        public void run() {

            RentIt.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }

    }

    void calculateRent(){
        //eenie meenie efkjjfhjerhhjh ebfjrfjrejhbr
        //dhsdvhbvhfdhv
        //vhfrwvjhehjrvgjhvhf
        //efgwegvhgvvjhdbjh vbdsh
    }
    Integer sumAll(){
        //eenie meenie efkjjfhjerhhjh ebfjrfjrejhbr
        //dhsdvhbvhfdhv
        //vhfrwvjhehjrvgjhvhf
        //efgwegvhgvvjhdbjh vbdsh
        //hueheuruwfhrgjhsdhvcbhbdbv;vjkfvjfdb
        return 1;
    }



}
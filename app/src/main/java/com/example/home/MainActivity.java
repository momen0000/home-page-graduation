package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    //profile edite text


    //to go to another activity (all service)
    public void allservice(View v) {
        Intent intent = new Intent(MainActivity.this, allservice.class);
        startActivity(intent);
    }
   // to go to another activity (profile)
    public void profile(View v) {
        Intent intent = new Intent(MainActivity.this, profile.class);
        startActivity(intent);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager;
        viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);




       // profile_activity edite text






            }












            };





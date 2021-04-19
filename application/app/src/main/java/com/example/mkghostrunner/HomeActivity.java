package com.example.mkghostrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView userTxt, distTxt, calTxt;
    Button dateBtn, logoutBtn, homeBtn, runBtn, foodBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Context context = this;

        userTxt = findViewById(R.id.home_welcome_user);
        distTxt = findViewById(R.id.home_daily_dist_val);
        calTxt = findViewById(R.id.home_daily_cal_val);
        dateBtn = findViewById(R.id.home_date_btn);
        logoutBtn = findViewById(R.id.home_logout_btn);
        homeBtn = findViewById(R.id.home_home_btn);
        runBtn = findViewById(R.id.home_run_btn);
        foodBtn = findViewById(R.id.home_food_btn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO figure out the date stuff
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //do nothing we're already in home
            }
        });
        runBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, RunActivity.class);
                startActivity(intent);
                finish();
            }
        });
        foodBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
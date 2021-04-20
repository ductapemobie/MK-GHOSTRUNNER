package com.example.mkghostrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodActivity extends AppCompatActivity {

    Context context = this;
    Button homeBtn, runBtn, foodBtn;
    String username, dayKey;
    Intent loginIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        homeBtn = findViewById(R.id.home_home_btn);
        runBtn = findViewById(R.id.home_run_btn);
        foodBtn = findViewById(R.id.home_food_btn);

        loginIntent = getIntent();
        String[] vals = loginIntent.getStringExtra(Intent.EXTRA_TEXT).split(" ");
        username = vals[0];
        dayKey = vals[1];

        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, username);
                startActivity(intent);
                finish();
            }
        });
        runBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, RunActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, username+ " " + dayKey);
                startActivity(intent);
                finish();
            }
        });
        foodBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //do nothing, we are already here
            }
        });
    }
}
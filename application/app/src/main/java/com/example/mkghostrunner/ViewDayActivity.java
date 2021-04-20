package com.example.mkghostrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewDayActivity extends AppCompatActivity {
    private Context context = this;
    private Button homeBtn, foodBtn;
    private TextView date, dist, time, cals, carbs, protein, fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_day);

        homeBtn = findViewById(R.id.return_home_btn);
        foodBtn = findViewById(R.id.view_food_btn);
        date = findViewById(R.id.day_date);
        dist = findViewById(R.id.day_dist_ran);
        time = findViewById(R.id.day_time_ran);
        cals = findViewById(R.id.day_calories);
        carbs = findViewById(R.id.day_carbs);
        protein = findViewById(R.id.day_protein);
        fat = findViewById(R.id.day_fat);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        foodBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewFoodActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
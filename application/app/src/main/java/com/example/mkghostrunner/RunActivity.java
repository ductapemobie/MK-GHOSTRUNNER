package com.example.mkghostrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RunActivity extends AppCompatActivity {
    final int RUNNING_ACTIVITY_REQUEST_CODE = 1;
    private Context context = this;
    private Button startRunBtn, homeBtn, runBtn, foodBtn;
    private TextView distTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        startRunBtn = findViewById(R.id.run_start_btn);
        homeBtn = findViewById(R.id.home_home_btn);
        runBtn = findViewById(R.id.home_run_btn);
        foodBtn = findViewById(R.id.home_food_btn);
        distTxt = findViewById(R.id.run_dist_val);


        startRunBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(context, RunningActivity.class);
                startActivityForResult(intent, RUNNING_ACTIVITY_REQUEST_CODE);
            }
        });

        //navigation buttons

        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        runBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //do nothing we are already here
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RUNNING_ACTIVITY_REQUEST_CODE) {
            if (resultCode == -1){
                String[] retVals = data.getStringExtra(Intent.EXTRA_TEXT).split(" ");

                distTxt.setText("hi");
            }
        }
    }
}

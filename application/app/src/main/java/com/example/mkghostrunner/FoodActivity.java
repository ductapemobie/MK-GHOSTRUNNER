package com.example.mkghostrunner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodActivity extends AppCompatActivity {

    Context context = this;
    TextView calTxt, carbTxt, proTxt, fatTxt;
    String username, dayKey;
    Intent loginIntent;
    DatabaseReference mDatabase;
    Button homeBtn, runBtn, foodBtn, addFoodBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        homeBtn = findViewById(R.id.home_home_btn);
        runBtn = findViewById(R.id.home_run_btn);
        foodBtn = findViewById(R.id.home_food_btn);
        addFoodBtn = findViewById(R.id.food_new_btn);


        calTxt = findViewById(R.id.food_cal_val);
        carbTxt = findViewById(R.id.food_carb_val);
        proTxt = findViewById(R.id.food_protein_val);
        fatTxt = findViewById(R.id.food_fat_val);

        loginIntent = getIntent();
        String[] vals = loginIntent.getStringExtra(Intent.EXTRA_TEXT).split(" ");
        username = vals[0];
        dayKey = vals[1];

        updateVals();


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

        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, AddFood.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void updateVals(){
        mDatabase.child("users").child(username).child("date").child(dayKey).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    calTxt.setText(String.valueOf("Error! Check your internet connection."));
                    carbTxt.setText(String.valueOf("Error! Check your internet connection."));
                    proTxt.setText(String.valueOf("Error! Check your internet connection."));
                    fatTxt.setText(String.valueOf("Error! Check your internet connection."));
                } else {
                    Iterable<DataSnapshot> keyIterator = task.getResult().child("food").getChildren();
                    int totalCal = 0;
                    int totalCarb = 0;
                    int totalProtein = 0;
                    int totalFat = 0;
                    for (DataSnapshot keySnap : keyIterator){
                        totalCal += ((int) keySnap.child("calories").getValue());
                        totalCarb += ((int) keySnap.child("carbs").getValue());
                        totalProtein += ((int) keySnap.child("protein").getValue());
                        totalFat += ((int) keySnap.child("fat").getValue());
                    }
                    calTxt.setText(String.valueOf(totalCal));
                    carbTxt.setText(String.valueOf(totalCarb) + " g");
                    proTxt.setText(String.valueOf(totalCarb) + " g");
                    fatTxt.setText(String.valueOf(totalCarb) + " g");
                }
            }
        });

    }
}
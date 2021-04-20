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

import java.time.LocalDate;

public class HomeActivity extends AppCompatActivity {

    TextView userTxt, distTxt, calTxt, dateTxt;
    Button dateBtn, logoutBtn, homeBtn, runBtn, foodBtn;
    Intent loginIntent;
    String username, dayKey;
    DayData dayData;
    DatabaseReference mDatabase;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        Context context = this;

        loginIntent = getIntent();
        username = loginIntent.getStringExtra(Intent.EXTRA_TEXT);

        dateTxt = findViewById(R.id.home_daily_values_title);
        userTxt = findViewById(R.id.home_welcome_user);
        distTxt = findViewById(R.id.home_daily_dist_val);
        calTxt = findViewById(R.id.home_daily_cal_val);
        dateBtn = findViewById(R.id.home_date_btn);
        logoutBtn = findViewById(R.id.home_logout_btn);
        homeBtn = findViewById(R.id.home_home_btn);
        runBtn = findViewById(R.id.home_run_btn);
        foodBtn = findViewById(R.id.home_food_btn);

        userTxt.setText(username);

        //mDatabase.child("users").child(username).child("date").getChil

        mDatabase.child("users").child(username).child("date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    distTxt.setText(String.valueOf("Error! Check your internet connection."));
                }
                else {
                    if (task.getResult().getValue()==null) {
                        dayKey = mDatabase.child("users").child(username).child("date").push().getKey();
                        dayData = new DayData(LocalDate.now(), dayKey);
                        mDatabase.child("users").child(username).child("date").child(dayKey).child("date").setValue(dayData.getDay().toString());
                        updateVals();
                    }
                    else {
                        Iterable<DataSnapshot> keyIterator = task.getResult().getChildren();
                        for (DataSnapshot keySnap : keyIterator){
                            if (LocalDate.now().toString().equals(String.valueOf(keySnap.child("date").getValue()))){
                                dayKey = keySnap.getKey();
                                dayData = new DayData(LocalDate.now(), dayKey);
                                updateVals();
                                return;
                            }
                        }
                        //date not found
                        dayKey = mDatabase.child("users").child(username).child("date").push().getKey();
                        dayData = new DayData(LocalDate.now(), dayKey);
                        mDatabase.child("users").child(username).child("date").child(dayKey).child("date").setValue(dayData.getDay().toString());
                        updateVals();
                    }
                }
            }
        });



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
                intent.putExtra(Intent.EXTRA_TEXT, username + " " + dayKey);
                startActivity(intent);
                finish();
            }
        });
        foodBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, username + " " + dayKey);
                startActivity(intent);
                finish();
            }
        });
    }

    private void updateVals(){
        dateTxt.setText("Today's date: " + String.valueOf(dayData.getDay()));
        //have username and dayKey
        mDatabase.child("users").child(username).child("date").child(dayKey).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    distTxt.setText(String.valueOf("Error! Check your internet connection."));
                    calTxt.setText(String.valueOf("Error! Check your internet connection."));
                } else {
                    calTxt.setText(String.valueOf(task.getResult().getValue()));
                    Iterable<DataSnapshot> keyIterator;
                    int totalCals = 0;
                    float totalDist = 0;
                    keyIterator = task.getResult().child("food").getChildren();
                    for (DataSnapshot keySnap : keyIterator){
                           totalCals+= 3;//Integer.parseInt(String.valueOf(keySnap.child("calories").getValue()));
                    }
                    keyIterator = task.getResult().child("run").getChildren();
                    for (DataSnapshot keySnap : keyIterator){
                        userTxt.setText(String.valueOf(Float.parseFloat(String.valueOf(keySnap.child("dist").getValue()))));
                        totalDist +=  Float.parseFloat(String.valueOf(keySnap.child("dist").getValue()));
                    }
                    calTxt.setText(String.valueOf(totalCals) + " calories");
                    distTxt.setText(String.valueOf(totalDist) + " meters");
                }
            }
        });
    }

}
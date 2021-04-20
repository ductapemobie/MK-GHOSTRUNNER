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

public class RunActivity extends AppCompatActivity {
    final int RUNNING_ACTIVITY_REQUEST_CODE = 1;
    private Context context = this;
    private Button startRunBtn, homeBtn, runBtn, foodBtn;
    private TextView distTxt, timeTxt, speedTxt, speedMphTxt;
    String username, dayKey;
    Intent loginIntent;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        startRunBtn = findViewById(R.id.run_start_btn);
        homeBtn = findViewById(R.id.home_home_btn);
        runBtn = findViewById(R.id.home_run_btn);
        foodBtn = findViewById(R.id.home_food_btn);
        distTxt = findViewById(R.id.run_dist_val);
        timeTxt = findViewById(R.id.run_time_val);
        speedTxt = findViewById(R.id.run_speed_val);
        speedMphTxt = findViewById(R.id.run_speed_mph_val);

        loginIntent = getIntent();
        String[] vals = loginIntent.getStringExtra(Intent.EXTRA_TEXT).split(" ");
        username = vals[0];
        dayKey = vals[1];

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
                intent.putExtra(Intent.EXTRA_TEXT, username);
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
                intent.putExtra(Intent.EXTRA_TEXT, username + " " + dayKey);
                startActivity(intent);
                finish();
            }
        });
        updateVals();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RUNNING_ACTIVITY_REQUEST_CODE) {
            if (resultCode == -1){
                String[] retVals = data.getStringExtra(Intent.EXTRA_TEXT).split(" ");

                distTxt.setText(String.valueOf(retVals));
            }
        }
    }

    private void updateVals(){
        mDatabase.child("users").child(username).child("date").child(dayKey).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    distTxt.setText(String.valueOf("Error! Check your internet connection."));
                    timeTxt.setText(String.valueOf("Error! Check your internet connection."));
                    speedTxt.setText(String.valueOf("Error! Check your internet connection."));
                    speedMphTxt.setText(String.valueOf("Error! Check your internet connection."));
                } else {
                    Iterable<DataSnapshot> keyIterator = task.getResult().child("run").getChildren();
                    float totalDist = 0;
                    long totalTime = 0;
                    for (DataSnapshot keySnap : keyIterator){
                        totalDist += ((float) keySnap.child("dist").getValue());
                        totalTime += ((long) keySnap.child("time").getValue());
                    }
                    float speed;

                    if (totalTime>0) {
                        speed = 1000 * totalDist / totalTime;
                    }else{
                        speed = 0;
                    }
                    distTxt.setText(String.valueOf(totalDist) + " meters");
                    timeTxt.setText(String.valueOf(totalDist) + " meters");
                    speedTxt.setText(String.valueOf(speed) + "m/s");
                    speedMphTxt.setText(String.valueOf(speed / 0.44704) + "mph");
                }
            }
        });

    }
}

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

public class ViewDayActivity extends AppCompatActivity {
    private Context context = this;
    private Button homeBtn;
    private TextView date, dist, time, cals, carbs, protein, fat;
    Intent loginIntent;
    String username, dayKey;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_day);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        loginIntent = getIntent();
        String[] vals = loginIntent.getStringExtra(Intent.EXTRA_TEXT).split(" ");
        username = vals[0];
        dayKey = vals[1];

        homeBtn = findViewById(R.id.return_home_btn);
        date = findViewById(R.id.day_date);
        dist = findViewById(R.id.day_dist_ran);
        time = findViewById(R.id.day_time_ran);
        cals = findViewById(R.id.day_calories);
        carbs = findViewById(R.id.day_carbs);
        protein = findViewById(R.id.day_protein);
        fat = findViewById(R.id.day_fat);

        mDatabase.child("users").child(username).child("date").child(dayKey).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    date.setText(String.valueOf("Error! Check your internet connection."));
                } else {
                    Iterable<DataSnapshot> keyIterator = task.getResult().child("food").getChildren();
                    int totalCal = 0;
                    int totalCarb = 0;
                    int totalProtein = 0;
                    int totalFat = 0;
                    for (DataSnapshot keySnap : keyIterator){
                        totalCal += Integer.parseInt(String.valueOf(keySnap.child("calories").getValue()));
                        totalCarb += Integer.parseInt(String.valueOf(keySnap.child("carbs").getValue()));
                        totalProtein += Integer.parseInt(String.valueOf(keySnap.child("protein").getValue()));
                        totalFat += Integer.parseInt(String.valueOf(keySnap.child("fat").getValue()));
                    }
                    keyIterator = task.getResult().child("run").getChildren();
                    float totalDist = 0;
                    long totalTime = 0;
                    for (DataSnapshot keySnap : keyIterator){
                        totalDist += Float.parseFloat(String.valueOf(keySnap.child("dist").getValue()));
                        totalTime += Long.parseLong(String.valueOf(keySnap.child("time").getValue()));
                    }
                    date.setText(String.valueOf(task.getResult().child("date").getValue()));
                    dist.setText(String.valueOf(String.format("%.2f" , totalDist)) + " meters");
                    time.setText(String.valueOf(totalTime / 1000) + " seconds");
                    cals.setText(String.valueOf(totalCal));
                    carbs.setText(String.valueOf(totalCarb) + " g");
                    protein.setText(String.valueOf(totalProtein) + " g");
                    fat.setText(String.valueOf(totalFat) + " g");
                }
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
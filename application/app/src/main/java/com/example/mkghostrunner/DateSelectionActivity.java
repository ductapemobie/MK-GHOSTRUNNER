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
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;

public class DateSelectionActivity extends AppCompatActivity {

    Intent loginIntent;
    String username, dayKey;
    Button selectBtn, cancelBtn;
    TextView errorTxt;
    DatePicker datePicker;
    DatabaseReference mDatabase;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        loginIntent = getIntent();
        String[] vals = loginIntent.getStringExtra(Intent.EXTRA_TEXT).split(" ");
        username = vals[0];
        dayKey = vals[1];


        selectBtn = findViewById(R.id.date_pick);
        cancelBtn = findViewById(R.id.date_cancel);
        errorTxt = findViewById(R.id.date_error_msg);
        datePicker = findViewById(R.id.simpleDatePicker);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onClick(View v) {
                int year = datePicker.getYear();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                LocalDate localDate =  LocalDate.of(year, month, day);
                check_day(localDate);
            }
        });
    }

    private void check_day(LocalDate localDate){
        errorTxt.setText(String.valueOf("Error! Check your internet connection."));
        mDatabase.child("users").child(username).child("date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    errorTxt.setText(String.valueOf("Error! Check your internet connection."));
                }
                else {
                    if (task.getResult().getValue()==null) {
                        errorTxt.setText(String.valueOf("Error! No data on this day"));
                    }
                    else {
                        Iterable<DataSnapshot> keyIterator = task.getResult().getChildren();
                        for (DataSnapshot keySnap : keyIterator){
                            if (localDate.toString().equals(String.valueOf(keySnap.child("date").getValue()))){
                                String newDayKey = keySnap.getKey();
                                Intent intent = new Intent(context, ViewDayActivity.class);
                                intent.putExtra(Intent.EXTRA_TEXT, username + " " + newDayKey);
                                startActivity(intent);
                                finish();
                                return;
                            }
                        }
                        errorTxt.setText(String.valueOf("Error! no data on this day"));
                    }
                }
            }
        });

    }
}
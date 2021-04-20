package com.example.mkghostrunner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class AddFood extends AppCompatActivity {

    private Button homeBtn, runBtn, foodBtn, addFoodBtn;
    EditText nameTxt, calorieTxt, carbTxt, proteinTxt, fatTxt;
    TextView loginTxt;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        //mDatabase = FirebaseDatabase.getInstance().getReference();
        nameTxt = findViewById(R.id.name_input);
        calorieTxt = findViewById(R.id.calorie_input);
        carbTxt = findViewById(R.id.carb_input);
        proteinTxt = findViewById(R.id.protein_input);
        fatTxt = findViewById(R.id.fat_input);



        homeBtn = findViewById(R.id.home_home_btn);
        runBtn = findViewById(R.id.home_run_btn);
        foodBtn = findViewById(R.id.home_food_btn);
        addFoodBtn = findViewById(R.id.add_food_btn);


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
}
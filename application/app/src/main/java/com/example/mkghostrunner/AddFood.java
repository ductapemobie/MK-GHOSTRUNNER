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

    private Button addFoodBtn, cancelFoodBtn;
    EditText nameTxt, calorieTxt, carbTxt, proteinTxt, fatTxt;
    TextView errTxt;
    Context context = this;
    DatabaseReference mDatabase;
    Intent loginIntent;
    String username, dayKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        loginIntent = getIntent();
        String[] vals = loginIntent.getStringExtra(Intent.EXTRA_TEXT).split(" ");
        username = vals[0];
        dayKey = vals[1];

        nameTxt = findViewById(R.id.name_input);
        calorieTxt = findViewById(R.id.calorie_input);
        carbTxt = findViewById(R.id.carb_input);
        proteinTxt = findViewById(R.id.protein_input);
        fatTxt = findViewById(R.id.fat_input);
        errTxt = findViewById(R.id.add_food_error_msg);

        addFoodBtn = findViewById(R.id.add_food_btn);
        cancelFoodBtn = findViewById(R.id.cancel_food_btn);

        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (nameTxt.getText().length() == 0) {
                    errTxt.setText(String.valueOf("Please input a name"));
                    return;
                }
                if (calorieTxt.getText().length() == 0) {
                    errTxt.setText(String.valueOf("Please input calorie content"));
                    return;
                }
                if (carbTxt.getText().length() == 0) {
                    errTxt.setText(String.valueOf("Please input carb content"));
                    return;
                }
                if (proteinTxt.getText().length() == 0) {
                    errTxt.setText(String.valueOf("Please input protein content"));
                    return;
                }
                if (fatTxt.getText().length() == 0) {
                    errTxt.setText(String.valueOf("Please input fat content"));
                    return;
                }

                int calories, carbs, protein, fat;

                String foodName = String.valueOf(nameTxt.getText());
                try{
                    calories = Integer.parseInt(String.valueOf(calorieTxt.getText()));
                }catch(Exception  e){
                    errTxt.setText(String.valueOf("Please input a number for calories"));
                    return;
                }
                try{
                    carbs = Integer.parseInt(String.valueOf(carbTxt.getText()));
                }catch(Exception  e){
                    errTxt.setText(String.valueOf("Please input a number for carbs"));
                    return;
                }
                try{
                    protein = Integer.parseInt(String.valueOf(proteinTxt.getText()));
                }catch(Exception  e){
                    errTxt.setText(String.valueOf("Please input a number for protein"));
                    return;
                }
                try{
                    fat = Integer.parseInt(String.valueOf(fatTxt.getText()));
                }catch(Exception  e){
                    errTxt.setText(String.valueOf("Please input a number for fat"));
                    return;
                }

                String foodKey = mDatabase.child("users").child(username).child("date").child(dayKey).child("run").push().getKey();
                FoodData foodData = new FoodData(calories, carbs, protein, fat, foodName, foodKey);
                mDatabase.child("users").child(username).child("date").child(dayKey).child("food").child(foodKey).setValue(foodData);

                finish();
            }
        });

        cancelFoodBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
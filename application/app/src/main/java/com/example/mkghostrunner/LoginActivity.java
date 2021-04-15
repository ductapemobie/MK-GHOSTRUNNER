package com.example.mkghostrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void register_click(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void login_click(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
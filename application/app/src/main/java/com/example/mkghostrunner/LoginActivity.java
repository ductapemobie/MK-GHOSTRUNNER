package com.example.mkghostrunner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.UUID;

public class LoginActivity extends AppCompatActivity {

    EditText userTxt, passTxt;
    TextView loginTxt;
    private DatabaseReference mDatabase;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        userTxt = findViewById(R.id.login_username_input);
        passTxt = findViewById(R.id.login_password_input);
        loginTxt = findViewById(R.id.login_error_msg);
    }

    public void register_click(View v){
        String username = userTxt.getText().toString();
        String password = passTxt.getText().toString();

        if (username.isEmpty()){
            loginTxt.setText(String.valueOf("Please input a username"));
            return;
        }

        if (password.length() < 8){
            loginTxt.setText(String.valueOf("Password must be 8 characters or longer"));
            return;
        }

        //checking if username already taken
        mDatabase.child("users").child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    loginTxt.setText(String.valueOf("Error! Check your internet connection."));
                }
                else {
                    if (task.getResult().getValue()==null)
                        register_user(username, password);
                    else
                        loginTxt.setText("Username Already Taken");
                }
            }
        });
    }

    private void register_user(String username, String password){
        String key = UUID.randomUUID().toString();
        UserData newUser = new UserData(username, password, key);
        mDatabase.child("users").child(key).setValue(newUser);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, key);
        startActivity(intent);
    }

    public void login_click(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
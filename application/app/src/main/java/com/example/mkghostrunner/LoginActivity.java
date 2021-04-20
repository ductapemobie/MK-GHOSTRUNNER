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

public class LoginActivity extends AppCompatActivity {

    EditText userTxt, passTxt;
    TextView loginTxt, loginTitle;
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
        loginTitle = findViewById(R.id.login_title);
    }

    public void register_click(View v){
        String username = userTxt.getText().toString();
        String password = passTxt.getText().toString();

        if (username.equals("RESET")){//debugging MUST REMOVE LATER
            mDatabase.child("users").setValue(null);
            return;
        }

        if (username.isEmpty()){
            loginTxt.setText(String.valueOf("Please input a username"));
            return;
        }

        if (password.length() < 8){
            loginTxt.setText(String.valueOf("Password must be 8 characters or longer"));
            return;
        }

        mDatabase.child("users").child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    loginTxt.setText(String.valueOf("Error! Check your internet connection."));
                }
                else {
                    if (task.getResult().getValue()==null) {
                        register_user(username, password);
                    }
                    else
                        loginTxt.setText(String.valueOf("Error! Username already taken"));
                }
            }
        });
    }

    private void register_user(String username, String password){
        loginTxt.setText("");
        UserData newUser = new UserData(username, password);

        mDatabase.child("users").child(username).setValue(newUser);
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, username);
        startActivity(intent);
    }

    public void login_click(View v){
        String username = userTxt.getText().toString();
        String password = passTxt.getText().toString();

        if (username.isEmpty()){
            loginTxt.setText(String.valueOf("Please input a username"));
            return;
        }

        if (password.isEmpty()){
            loginTxt.setText(String.valueOf("Please input a password"));
            return;
        }

        mDatabase.child("users").child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    loginTxt.setText(String.valueOf("Error! Check your internet connection."));
                }
                else {
                    if (task.getResult().getValue()==null) {
                        loginTxt.setText(String.valueOf("Error! Username or Password incorrect"));
                    }
                    else
                        if (password.equals(task.getResult().child("password").getValue())){
                            validateLogin(username);
                        }else
                            loginTxt.setText(String.valueOf("Error! Username or Password incorrect"));
                }
            }
        });
    }

    public void validateLogin(String username){
        loginTxt.setText("");
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, username);
        startActivity(intent);
    }
}
package com.example.mkghostrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;

public class LoginActivity extends AppCompatActivity {

    EditText userTxt, passTxt;
    TextView loginTxt;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        //TODO replace with database search
        String[] files = context.fileList();
        for (String file : files) {
            if (file.equals(username)) {
                //username already taken
                loginTxt.setText(String.valueOf("Username Already Taken"));
                return;
            }
        }

        try(FileOutputStream fox = context.openFileOutput(username, Context.MODE_PRIVATE)){
            //foawijaefw
        }catch(Exception e){
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, "username");
        startActivity(intent);
    }

    public void login_click(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
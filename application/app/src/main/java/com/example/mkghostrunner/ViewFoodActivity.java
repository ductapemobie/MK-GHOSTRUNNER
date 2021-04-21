package com.example.mkghostrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewFoodActivity extends AppCompatActivity {
<<<<<<< HEAD
/*
*   DID NOT IMPLEMENT THIS, JUST A PLACEHOLDER EXAMPLE OF WHAT VIEW FOOD WOULD LOOK LIKE
* */
=======
    private Context context = this;
    private Button returnBtn;

>>>>>>> 90dc567cb0663aab1f57f08064289feb36485a06
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);

<<<<<<< HEAD


=======
        returnBtn = findViewById(R.id.return_btn);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
>>>>>>> 90dc567cb0663aab1f57f08064289feb36485a06
    }
}
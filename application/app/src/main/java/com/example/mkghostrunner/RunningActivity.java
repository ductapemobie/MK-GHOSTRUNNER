package com.example.mkghostrunner;

import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RunningActivity extends Activity implements LocationListener {
    protected LocationManager locationManager;
    TextView distTxt, timeTxt, speedTxt, speedMphTxt;
    Button finishBtn, cancelBtn;
    float distanceTraveled;
    Location oldLoc;
    long startTime;
    DatabaseReference mDatabase;
    String username, dayKey;
    Intent loginIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        loginIntent = getIntent();
        String[] vals = loginIntent.getStringExtra(Intent.EXTRA_TEXT).split(" ");
        username = vals[0];
        dayKey = vals[1];

        oldLoc = null;
        startTime = SystemClock.uptimeMillis();

        distTxt = findViewById(R.id.running_dist_val);
        timeTxt = findViewById(R.id.running_time_val);
        speedTxt = findViewById(R.id.running_speed_val);
        speedMphTxt = findViewById(R.id.running_speed_mph_val);
        finishBtn = findViewById(R.id.running_finish_btn);
        cancelBtn = findViewById(R.id.running_cancel_btn);

        distanceTraveled = 0;

        finishBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                long timePassed = SystemClock.uptimeMillis() - startTime;
                String runKey = mDatabase.child("users").child(username).child("date").child(dayKey).child("run").push().getKey();
                RunData runData = new RunData(timePassed, distanceTraveled, runKey);
                mDatabase.child("users").child(username).child("date").child(dayKey).child("run").child(runKey).setValue(runData);

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: implement perm checking
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
    }
    @Override
    public void onLocationChanged(Location location) {
        float speed;
        long timePassed = SystemClock.uptimeMillis() - startTime;
        if (timePassed>0) {
            speed = 1000 * distanceTraveled / timePassed;
        }else{
            speed = 0;
        }
        if (oldLoc != null){
            distanceTraveled += location.distanceTo(oldLoc);
        }
        distTxt.setText(String.valueOf(String.format("%.2f", distanceTraveled)));
        timeTxt.setText(String.valueOf(timePassed/1000));
        speedTxt.setText(String.valueOf(String.format("%.2f" ,speed)));
        speedMphTxt.setText(String.valueOf(String.format("%.2f" ,speed/0.44704)));
        oldLoc = location;
    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
}
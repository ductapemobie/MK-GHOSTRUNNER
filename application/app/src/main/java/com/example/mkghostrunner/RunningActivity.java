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
import android.widget.Button;
import android.widget.TextView;

public class RunningActivity extends Activity implements LocationListener {
    protected LocationManager locationManager;
    TextView distTxt, timeTxt, speedTxt, speedMphTxt;
    Button finishBtn, cancelBtn;
    float distanceTraveled;
    Location oldLoc;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
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
                Intent intent = new Intent();
                String retStr = String.valueOf(distanceTraveled) + " " + String.valueOf(SystemClock.uptimeMillis() - startTime);
                intent.putExtra(Intent.EXTRA_TEXT, retStr);
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
        distTxt.setText(String.valueOf(distanceTraveled));
        timeTxt.setText(String.valueOf(timePassed/1000));
        speedTxt.setText(String.valueOf(speed));
        speedMphTxt.setText(String.valueOf(speed/0.44704));
        oldLoc = location;
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }
}
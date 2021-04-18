package com.example.mkghostrunner;

import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

public class RunningActivity extends Activity implements LocationListener {
    protected LocationManager locationManager;
    TextView distTxt, timeTxt;
    float distanceTraveled;
    Location oldLoc;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
        oldLoc = null;
        startTime = SystemClock.uptimeMillis();

        distTxt = findViewById(R.id.running_dist);
        timeTxt = findViewById(R.id.running_time);

        distanceTraveled = 0;

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
    }
    @Override
    public void onLocationChanged(Location location) {
        long timePassed = SystemClock.uptimeMillis() - startTime;
        if (oldLoc != null){
            distanceTraveled += location.distanceTo(oldLoc);
        }
        distTxt = (TextView) findViewById(R.id.running_dist);
        distTxt.setText(String.valueOf(distanceTraveled));
        timeTxt.setText(String.valueOf(timePassed));
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
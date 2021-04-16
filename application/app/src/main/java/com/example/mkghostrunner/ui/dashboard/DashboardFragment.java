package com.example.mkghostrunner.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mkghostrunner.R;
import com.example.mkghostrunner.RunningActivity;

public class DashboardFragment extends Fragment{

    private DashboardViewModel dashboardViewModel;
    LocationListener locListener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_run, container, false);

        final Button run_button = root.findViewById(R.id.button_id);
        final TextView gps_txt = root.findViewById(R.id.run_coords);
        run_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RunningActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
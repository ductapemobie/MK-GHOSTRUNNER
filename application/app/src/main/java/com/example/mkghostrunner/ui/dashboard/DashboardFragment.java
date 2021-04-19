package com.example.mkghostrunner.ui.dashboard;

import android.content.Intent;
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
    private static final int RUNNING_ACTIVITY_REQUEST_CODE = 0;
    TextView distTxt, timeTxt, speedTxt;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_run, container, false);
        distTxt = root.findViewById(R.id.run_dist_val);
        final Button run_button = root.findViewById(R.id.button_id);
        run_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RunningActivity.class);
                startActivityForResult(intent, RUNNING_ACTIVITY_REQUEST_CODE);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RUNNING_ACTIVITY_REQUEST_CODE) {
            if (resultCode == -1){
                String[] retVals = data.getStringExtra(Intent.EXTRA_TEXT).split(" ");

                distTxt.setText("hi");
            }
        }
    }
}
package com.pakhi.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView txtTime;

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("pakhi-test","onCreate");
        txtTime = findViewById(R.id.txtTime);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getTimeData().observe(this, elapsedTime -> txtTime.setText(elapsedTime));
        viewModel.startStopwatch();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onCleared();
    }

}
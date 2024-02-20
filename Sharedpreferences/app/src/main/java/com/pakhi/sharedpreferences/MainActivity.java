package com.pakhi.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch swNotifications ;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swNotifications = findViewById(R.id.switch1);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        swNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ///notification switch is turned on
                    boolean b1 = true;
                    sharedPreferences.edit().putBoolean("notifications", true).apply(); ///notifications is key  and true is value
                } else {
                    ///it is turned off
                    sharedPreferences.edit().putBoolean("notifications",false).apply();

                }
            }
        });
    }
}
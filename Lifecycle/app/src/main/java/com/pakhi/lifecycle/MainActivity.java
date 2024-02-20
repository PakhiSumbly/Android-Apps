package com.pakhi.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btn);

        ///finish();   only onCreate() and onStart() will be called as seen in logcat

        ///Log.d("some_tag", "onCreate method called");
        int my_log = Log.d("my_log",  "onCreate  called "); //my_log is local variable

        for (int i = 0; i < 9; i++) {
                                                            ///int for_log_output = Log.d("for_log_output", i + " "); this line is changed to the one line below
            Log.d("for_log_output", i + " ");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("my_log","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my_log", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("my_log","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my_log","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my_log","onDestroy called");
    }


    ///method triggered when we click the button
        @SuppressLint("SetTextI18n")
       public void btnClicked (View view)
       {
           btn.setText("CHANGED");
           Log.d("some_tag", "button is clicked");
        }


}
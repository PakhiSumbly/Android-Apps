package com.pakhi.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();
    TextView textView;
    Button btnOne , btnTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_view);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringMutableLiveData.setValue("ONE");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringMutableLiveData.setValue("TWO");
            }
        });

        stringMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        stringMutableLiveData.setValue("Some value");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        stringMutableLiveData.setValue("Hello there");
    }
}
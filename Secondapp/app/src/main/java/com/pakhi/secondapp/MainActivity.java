package com.pakhi.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNumberOne, edtNumberTwo;
    TextView txtresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumberOne = findViewById(R.id.numberOne);
        edtNumberTwo = findViewById(R.id.numberTwo);
        txtresult = findViewById(R.id.result);
    }

    public void showToastMessage(View view)
    {
        String firstNumber = edtNumberOne.getText().toString();
        String secondNumber= edtNumberTwo.getText().toString();

        if(firstNumber.isEmpty()||secondNumber.isEmpty())
        {
            Toast.makeText(MainActivity.this,"wrong input",Toast.LENGTH_SHORT).show();
            return ;
        }

        int resultNumber = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);

        //Toast.makeText(MainActivity.this ,"Button Clicked!"+firstNumber + " -- " +secondNumber , Toast.LENGTH_SHORT).show();

        txtresult.setText(String.valueOf(resultNumber));
        Toast.makeText(MainActivity.this, "Result is "+resultNumber , Toast.LENGTH_SHORT).show();
    }
}
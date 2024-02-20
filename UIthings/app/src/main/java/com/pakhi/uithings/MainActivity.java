package com.pakhi.uithings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txt2);
        editText=findViewById(R.id.edtinput);
    }

    public void goToSecondActivity(){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("some_input",editText.getText().toString());

        startActivity(intent);

    }

    public void animate(View view){

        textView.animate().rotationX(120).start();
        textView.animate().alpha(0).setDuration(500).start();
        textView.animate().scaleY(1.2f).scaleX(1.2f).setDuration(500).start();
        textView.animate().translationX(300).start();
        goToSecondActivity();

    }
}
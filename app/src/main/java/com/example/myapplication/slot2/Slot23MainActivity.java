package com.example.myapplication.slot2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot23MainActivity extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot23_main);
        tv1 = findViewById(R.id.slot2A23Tv1);
        Intent i1 = getIntent();
        double a = Double.parseDouble(i1.getExtras().getString("a"));
        double b = Double.parseDouble(i1.getExtras().getString("b"));
        double sum = a+b;
        tv1.setText(String.valueOf(sum));
    }
}
package com.example.myapplication.slot8;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Demo81MainActivity extends AppCompatActivity {
TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo81_main);
        tv1=findViewById(R.id.demo81Tv1);
        Typeface font = Typeface.createFromAsset(getAssets(), "Blazed.ttf");
        tv1.setTypeface(font);
    }
}
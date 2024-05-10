package com.example.myapplication.slot1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot1MainActivity extends AppCompatActivity {
    TextView tv1;//var
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot1_main);
        //reference from layout to java file: findViewById()
        //TextView: display data
        //EditText: input data
        tv1=findViewById(R.id.sl1Txt1);
        //set text for textview object
        tv1.setText("Text after changed");
    }
}
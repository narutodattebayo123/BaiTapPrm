package com.example.myapplication.slot2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot2MainActivity extends AppCompatActivity {
    //var all control
    EditText txt1,txt2;
    Button btn1;
    TextView tv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot2_main);
        //reference control to memory
        txt1=findViewById(R.id.slot2Txt1);
        txt2=findViewById(R.id.slot2Txt2);
        btn1=findViewById(R.id.slot2Btn1);
        tv1=findViewById(R.id.slot2TvResult);
        //event handing
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumfn();
            }
        });
    }
    //write a function for Sum
    void sumfn(){
        //get data of the input1
        double a= Double.parseDouble(txt1.getText().toString());
        //get data of the input2
        double b=Double.parseDouble(txt2.getText().toString());
        //sum
        double s=a+b;
        //display result
        tv1.setText(String.valueOf(s));
    }
}
package com.example.myapplication.slot1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot12MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    Button btn1;
    TextView tvKQ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot12_main);
        txt1=findViewById(R.id.slot1Edt1);
        txt2=findViewById(R.id.slot1Edt2);
        btn1=findViewById(R.id.slot1Btn1);
        tvKQ=findViewById(R.id.slot1TvKQ);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator();
            }
        });
    }

    void calculator(){
        //lay du lieu nhap vao tu editText1
        int a= Integer.parseInt(txt1.getText().toString());
        //lay du lieu nhap vao tu editText1
        int b=Integer.parseInt(txt2.getText().toString());
        //tinh tong
        int sum=a+b;
        //dua tong ra ngoai man hinh
        tvKQ.setText(String.valueOf(sum));

    }
}
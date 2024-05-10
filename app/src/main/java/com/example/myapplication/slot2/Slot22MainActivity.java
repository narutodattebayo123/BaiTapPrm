package com.example.myapplication.slot2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot22MainActivity extends AppCompatActivity {

    EditText txt1,txt2;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot22_main);
        txt1=findViewById(R.id.slot2A22Txt1);
        txt2=findViewById(R.id.slot2A22Txt2);
        btn1=findViewById(R.id.slot2A22Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Slot22MainActivity.this, Slot23MainActivity.class);
                i.putExtra("a",txt1.getText().toString());
                i.putExtra("b",txt2.getText().toString());
                startActivity(i);
            }
        });
    }
}
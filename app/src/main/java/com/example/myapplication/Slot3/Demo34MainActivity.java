package com.example.myapplication.Slot3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Demo34MainActivity extends AppCompatActivity {

    TextView tvKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo34_main);

        tvKQ = findViewById(R.id.demo34TvKQ);

        Intent intent1 = getIntent();

        int a = Integer.parseInt(intent1.getExtras().getString("hsa"));
        int b = Integer.parseInt(intent1.getExtras().getString("hsb"));
        int c = Integer.parseInt(intent1.getExtras().getString("hsc"));

        int delta = b*b-4*a*c;
        if(delta<0){
            tvKQ.setText("PTVN");
        }else if(delta == 0){
            tvKQ.setText("PT co nghiem kep x="+ (-b)/(2*a));
        }else{
            float x1 = (float) (-b+Math.sqrt(delta)/(2*a));
            float x2 = (float) (-b-Math.sqrt(delta)/(2*a));
            tvKQ.setText("PT co 2 nghiem la: "+x1 + "va "+x2);
        }
    }
}
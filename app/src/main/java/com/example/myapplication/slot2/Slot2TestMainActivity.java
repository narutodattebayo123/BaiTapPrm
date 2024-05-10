package com.example.myapplication.slot2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot2TestMainActivity extends AppCompatActivity {
    EditText txt1,txt2;;
    Button btn1;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slot2_test_main);

        txt1 = findViewById(R.id.slot2Txt1);
        txt2 = findViewById(R.id.slot2Txt2);
        btn1 = findViewById(R.id.slot2btn1);
        tv1 = findViewById(R.id.result);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumfn();
            }
        });
    }
    void sumfn(){
        Double a = Double.parseDouble(txt1.getText().toString());
        Double b = Double.parseDouble(txt2.getText().toString());
        Double s = a + b;

        tv1.setText(String.valueOf(s));
    }
}
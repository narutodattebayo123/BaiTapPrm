package com.example.myapplication.Slot3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Demo3MainActivity extends AppCompatActivity {

    EditText txtA, txtB, txtC;
    Button btn1;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo3_main);

        txtA = findViewById(R.id.demo33Hsa);
        txtB = findViewById(R.id.demo33Hsb);
        txtC = findViewById(R.id.demo33Hsc);
        btn1=findViewById(R.id.demo33Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }
    private void sendData(){
        String a = txtA.getText().toString();
        String b = txtB.getText().toString();
        String c = txtC.getText().toString();
        Intent intent = new Intent(Demo3MainActivity.this, Demo34MainActivity.class);
        intent.putExtra("hsa",a);
        intent.putExtra("hsb",b);
        intent.putExtra("hsc",c);
        startActivity(intent);
    }
}
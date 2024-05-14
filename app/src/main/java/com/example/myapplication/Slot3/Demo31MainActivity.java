package com.example.myapplication.Slot3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Demo31MainActivity extends AppCompatActivity {
    EditText txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo31_main);

        txt1 = findViewById(R.id.demo31Txt1);
        txt2 = findViewById(R.id.demo31Txt2);
        btn1 = findViewById(R.id.demo31Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Login();
            }
        });
    }
    private void Login(){
        if(txt1.getText().toString().equals("admin")
                &&txt2.getText().toString().equals("123456")){
            Toast.makeText(Demo31MainActivity.this,"Login successful",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(Demo31MainActivity.this,"User or pass wrong",Toast.LENGTH_LONG).show();
        }
    }
}
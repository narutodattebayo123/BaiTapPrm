package com.example.myapplication.slot16;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.R;

public class Demo161MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText txtSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo161_main);
        btnSend = findViewById(R.id.demo161Btn1);
        txtSend = findViewById(R.id.demo161Txt1);
        btnSend.setOnClickListener(v->{
            FragmentManager fragmentManager = getSupportFragmentManager();
            Demo161BlankFragment f1 = (Demo161BlankFragment) fragmentManager.findFragmentById(R.id.demo161Fr1);
            f1.editText.setText(txtSend.getText().toString());
        });
    }
}
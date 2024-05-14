package com.example.myapplication.Slot3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Demo32MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo32_main);
        listView = findViewById(R.id.demo32lv);
        getDataToListView();
    }

    private void getDataToListView(){
        String[] arr = new String[]{
                "laptrinh java 1",
                "computer science introduction",
                "Mobile programming",
                "visual studio code",
                "visual studio 2022",
                ".NET Core Web MVC"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Demo32MainActivity.this,
                android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
    }
}
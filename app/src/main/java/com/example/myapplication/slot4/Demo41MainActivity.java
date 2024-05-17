package com.example.myapplication.slot4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Demo41MainActivity extends AppCompatActivity {
    private ListView listView;
    private Demo41BaseAdapter adapter;
    private List<Demo41Student> list=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo41_main);
        listView=findViewById(R.id.demo41ListView);
        list.add(new Demo41Student("Nguyen Van A","18",R.drawable.android));
        list.add(new Demo41Student("Tran Van B","19",R.drawable.apple));
        list.add(new Demo41Student("Vu Van C","20",R.drawable.blogger));
        list.add(new Demo41Student("Nguyen Van D","22",R.drawable.hp));
        list.add(new Demo41Student("Hoang Van E","18",R.drawable.chrome));
        list.add(new Demo41Student("Nguyen Van Y","17",R.drawable.ic_launcher_background));
        list.add(new Demo41Student("Nguyen Van X","19",R.drawable.dell));
        list.add(new Demo41Student("Nguyen Van G","21",R.drawable.facebook));
        list.add(new Demo41Student("Nguyen Van Z","23",R.drawable.hancock));

        adapter=new Demo41BaseAdapter(this,list);//create adapter
        listView.setAdapter(adapter);//attach adapter to listview

    }
}
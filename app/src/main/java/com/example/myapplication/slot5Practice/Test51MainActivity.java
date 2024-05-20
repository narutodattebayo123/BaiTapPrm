package com.example.myapplication.slot5Practice;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Test51MainActivity extends AppCompatActivity {
    ListView listView;
    Test51Adapter adapter;
    List<Test51Product> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test51_main);
        listView=findViewById(R.id.test51Listview1);
        //Test51SqliteHelper helper = new Test51SqliteHelper(this);
        //SQLiteDatabase db = helper.getReadableDatabase();
        Test51ProductDAO dao = new Test51ProductDAO(this);
        Test51Product p = new Test51Product("3", "San pham 1", 123, 1);
        //int kq = dao.insertProduct(p);
        list = dao.getAll();
        adapter = new Test51Adapter(list, this);
        listView.setAdapter(adapter);
        //int kq = dao.insertProduct(p);
    }
}
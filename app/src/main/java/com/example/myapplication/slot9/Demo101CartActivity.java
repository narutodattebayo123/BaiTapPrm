package com.example.myapplication.slot9;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.List;

public class Demo101CartActivity extends AppCompatActivity {
    private ListView listView;
    private Demo101CartAdapter adapter;
    Demo10CartManager cartManager;
    List<Product91> cartItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo101_cart_main);
        listView=findViewById(R.id.demo101_cartActivity_ListView);

        cartManager=Demo10CartManager.getInstance();
        cartItems=cartManager.getCartItem();

        adapter=new Demo101CartAdapter(this, cartItems);
        listView.setAdapter(adapter);
    }
}
package com.example.myapplication.slot9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class Demo101MainActivity extends AppCompatActivity {
    private TextView tvStyleID, tvBrand, tvPrice, tvAddInfo;
    private ImageView img;
    Intent intent;
    Product91 product;
    Demo10CartManager cartManager;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo101_main);
        img=findViewById(R.id.demo101ImageView1);
        tvStyleID=findViewById(R.id.demo101TvStyleID);
        tvBrand=findViewById(R.id.demo101TvBrand);
        tvPrice=findViewById(R.id.demo101TvPrice);
        tvAddInfo=findViewById(R.id.demo101TvAddInfo);
        btn=findViewById(R.id.demo101BtnAddToCart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCartClickd();
            }
        });
        //tqao gio hang
        cartManager=Demo10CartManager.getInstance();

        intent=getIntent();
        product=intent.getParcelableExtra("PRODUCT");
        if(product!=null){
            Picasso.get().load(product.getSearchImage()).into(img);
            tvStyleID.setText(product.getStyleId());
            tvBrand.setText(product.getBrand());
            tvPrice.setText(product.getPrice());
            tvAddInfo.setText(product.getInfo());
        }
    }

    private void addToCartClickd(){
        Intent intent1 = getIntent();
        Product91 product1 = intent1.getParcelableExtra("PRODUCT");
        if(product1!=null){
            cartManager.addProductToCart(product1);
            Intent intent2 = new Intent(this, Demo101CartActivity.class);
            startActivity(intent2);
        }
    }
}
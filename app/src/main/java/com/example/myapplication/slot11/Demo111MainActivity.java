package com.example.myapplication.slot11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo111MainActivity extends AppCompatActivity {

    TextView tv1;
    EditText txt1, txt2, txt3;
    Button btnInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo111_main2);
        txt1=findViewById(R.id.demo111Txt1);
        txt2=findViewById(R.id.demo111Txt2);
        txt3=findViewById(R.id.demo111Txt3);
        tv1=findViewById(R.id.demo111TvResult);
        btnInsert=findViewById(R.id.demo111BtnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }
    private void insertData(){
        Prd prd = new Prd();
        prd.setName(txt1.getText().toString());
        prd.setPrice(txt2.getText().toString());
        prd.setDescription(txt3.getText().toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.119/000/202406/create_product.php")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceInsertPrd insertPrdobj = retrofit.create(InterfaceInsertPrd.class);
        Call<SvrResponePrd> call = insertPrdobj.insertPrd(prd.getName(), prd.getPrice(), prd.getDescription());
        call.enqueue(new Callback<SvrResponePrd>() {
            @Override
            public void onResponse(Call<SvrResponePrd> call, Response<SvrResponePrd> response) {
                SvrResponePrd svrResponePrd = response.body();
                tv1.setText(svrResponePrd.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponePrd> call, Throwable throwable) {
                tv1.setText(throwable.getMessage());
            }
        });
    }
}
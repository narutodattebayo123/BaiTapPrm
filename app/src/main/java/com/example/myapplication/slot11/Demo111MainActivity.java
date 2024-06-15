package com.example.myapplication.slot11;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo111MainActivity extends AppCompatActivity {
    EditText txt0,txt1,txt2,txt3;
    TextView tv1;
    Button btnInsert,btnUpdate,btnDelete,btnSelect;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo111_main);
        txt0=findViewById(R.id.demo111Txt0);
        txt1=findViewById(R.id.demo111Txt1);
        txt2=findViewById(R.id.demo111Txt2);
        txt3=findViewById(R.id.demo111Txt3);
        tv1=findViewById(R.id.demo111TvResult);
        btnInsert=findViewById(R.id.demo111BtnInsert);
        btnDelete=findViewById(R.id.demo121BtnDelete);
        btnUpdate=findViewById(R.id.demo121BtnUpdate);
        btnSelect=findViewById(R.id.demo121BtnSelect);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectData();
            }
        });
    }
    private List<PrdSelect> ls;
    String strResult="";
    private void selectData(){
        //2. Create a retrofit object
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.100.119/000/202406/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //call
        InterfaceSelect interfaceSelect=retrofit.create(InterfaceSelect.class);
        Call<SvrResponseSelect> call
                =interfaceSelect.getPrd();
        //execute delete
        call.enqueue(new Callback<SvrResponseSelect>() {
            @Override
            public void onResponse(Call<SvrResponseSelect> call, Response<SvrResponseSelect> response) {
                SvrResponseSelect svrResponseSelect=response.body();
                //convert response to list
                ls=new ArrayList<>(Arrays.asList(svrResponseSelect.getProducts()));
                //for
                for(PrdSelect p:ls){
                    strResult +="Name: "+p.getName()+"; Price: "+p.getPrice()+"; Des: "+p.getDescription()+"\n";
                }
                tv1.setText(strResult);
            }

            @Override
            public void onFailure(Call<SvrResponseSelect> call, Throwable t) {
                tv1.setText(t.getMessage());
            }
        });
    }
    private void updateData(){
        //1. Create an object for archive data
        PrdUpd p=new PrdUpd();
        p.setPid(txt0.getText().toString());
        p.setName(txt1.getText().toString());
        p.setPrice(txt2.getText().toString());
        p.setDescription(txt3.getText().toString());
        //2. Create a retrofit object
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.100.119/000/202406/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //call
        InterfaceUpd interfaceUpd=retrofit.create(InterfaceUpd.class);
        Call<SvrResponseUpd> call
                =interfaceUpd.updateExe(p.getPid(),p.getName(),p.getPrice(),p.getDescription());
        //execute delete
        call.enqueue(new Callback<SvrResponseUpd>() {
            @Override
            public void onResponse(Call<SvrResponseUpd> call, Response<SvrResponseUpd> response) {
                SvrResponseUpd svrResponseUpd=response.body();
                tv1.setText(svrResponseUpd.getMessage());
            }
            @Override
            public void onFailure(Call<SvrResponseUpd> call, Throwable t) {
                tv1.setText(t.getMessage());
            }
        });
    }
    private void deleteData(){
        //1. Create an object for archive data
        PrdDel p=new PrdDel();
        p.setPid(txt0.getText().toString());
        //2. Create a retrofit object
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.100.119/000/202406/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //call
        InterfaceDel interfaceDel=retrofit.create(InterfaceDel.class);
        Call<SvrResponseDel> call
                =interfaceDel.deleteExe(p.getPid());
        //execute delete
        call.enqueue(new Callback<SvrResponseDel>() {
            @Override
            public void onResponse(Call<SvrResponseDel> call, Response<SvrResponseDel> response) {
                SvrResponseDel svrResponseDel=response.body();
                tv1.setText(svrResponseDel.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseDel> call, Throwable t) {
                tv1.setText(t.getMessage());
            }
        });
    }
    private void insertData(){
        //1.Create a object for archive data
        Prd prd=new Prd();
        //2.set data to object
        prd.setName(txt1.getText().toString());
        prd.setPrice(txt2.getText().toString());
        prd.setDescription(txt3.getText().toString());
        //3. create a retrofit object
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.100.119/000/202406/create_product.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //4. Call insert
        //4.0. Create a object
        InterfaceInsertPrd insertPrdObj
                =retrofit.create(InterfaceInsertPrd.class);
        //4.1. prepare function
        Call<SvrResponsePrd> call
                =insertPrdObj.insertPrd(prd.getName(),prd.getPrice(),prd.getDescription());
        //4.2 execute function
        call.enqueue(new Callback<SvrResponsePrd>() {
            @Override
            public void onResponse(Call<SvrResponsePrd> call, Response<SvrResponsePrd> response) {
                SvrResponsePrd svrResponsePrd=response.body();
                tv1.setText(svrResponsePrd.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponsePrd> call, Throwable t) {
                tv1.setText(t.getMessage());
            }
        });

    }
}
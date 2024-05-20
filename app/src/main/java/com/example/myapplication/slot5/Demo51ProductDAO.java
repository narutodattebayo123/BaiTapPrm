package com.example.myapplication.slot5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Demo51ProductDAO {
    private Demo51SqliteHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;
    public Demo51ProductDAO(Context context){
        this.context = context;
        dbHelper=new Demo51SqliteHelper(context);
        dbHelper.getWritableDatabase();
    }

    public int insertProduct(Demo51Product p ){
        ContentValues value = new ContentValues();
        value.put("id",p.getId());
        value.put("name",p.getName());
        value.put("price",p.getPrice());

        if(db.insert("Product", null, value)<0){
            return -1;
        }else{
            return 1;
        }
    }

    public List<Demo51Product> getAll(){
        List<Demo51Product> list = new ArrayList<>();
        Cursor c = db.query("Product", null, null, null, null, null, null, null);
        c.moveToFirst();
        while ((c.isAfterLast()==false)){
            Demo51Product product = new Demo51Product();
            product.setId(c.getString(0));
            product.setName(c.getString(1));
            product.setPrice(c.getDouble(2));
            list.add(product);
            c.moveToNext();
        }
        c.close();
        return list;
    }
}

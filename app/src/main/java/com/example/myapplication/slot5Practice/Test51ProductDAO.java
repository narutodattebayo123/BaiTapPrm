package com.example.myapplication.slot5Practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Test51ProductDAO {
    private Test51SqliteHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;
    public Test51ProductDAO(Context context){
        this.context=context;
        dbHelper=new Test51SqliteHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public int insertProduct(Test51Product p){
        ContentValues values = new ContentValues();
        values.put("id",p.getId());
        values.put("name",p.getName());
        values.put("price",p.getPrice());
        if(db.insert("Product", null,values)<0){
            return -1;
        }
        return 1;
    }

    public List<Test51Product> getAll(){
        List<Test51Product> list = new ArrayList<>();
        Cursor c = db.query("Product", null, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            Test51Product product = new Test51Product();
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

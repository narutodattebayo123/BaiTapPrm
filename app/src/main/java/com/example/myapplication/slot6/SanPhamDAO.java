package com.example.myapplication.slot6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbhelper;
    private Context context;
    public static final String TABLE_NAME="sanpham";
    public SanPhamDAO(Context context){
        this.context = context;
        dbhelper=new Demo61SQLiteHelper(context);
        db=dbhelper.getWritableDatabase();
    }
    public  int insertProduct(SanPham p){
        ContentValues values = new ContentValues();
        values.put("masp", p.getMasp());
        values.put("tensp", p.getTensp());
        values.put("soluongSP", String.valueOf(p.getSoluongSP()));
        if(db.insert(TABLE_NAME, null, values)<0){
            return -1;
        }
        return 1;
    }

    public int deleteProduct(String masp){
        if(db.delete(TABLE_NAME, "masp=?", new String[]{masp})>=0){
            return -1;
        }
        return 1;
    }

    public int updateProduct(SanPham p){
        ContentValues values = new ContentValues();
        values.put("masp", p.getMasp());
        values.put("tensp", p.getTensp());
        values.put("soluongSP", String.valueOf(p.getSoluongSP()));
        if(db.update(TABLE_NAME, values, "masp=?", new String[]{p.getMasp()})<0){
            return -1;
        }
        return 1;
    }

    public List<String> getAllProductToString(){
        List<String> ls = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null,
                null, null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            SanPham s = new SanPham();
            s.setMasp(c.getString(0));
            s.setTensp(c.getString(1));
            s.setSoluongSP(c.getInt(2));
            String chuoi = s.getMasp() +" - "+s.getTensp()+" - "+s.getSoluongSP();
            ls.add(chuoi);
            c.moveToNext();
        }
        c.close();
        return ls;
    }
}

package com.example.myapplication.slot6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Demo61SQLiteHelper extends SQLiteOpenHelper {
    public static final String SQl_Create_TABLE_SANPHAM="CREATE TABLE sanpham (\n" +
            "masp text PRIMARY KEY,\n" +
            "tensp text,\n" +
            "soluongSP text);";
    public Demo61SQLiteHelper(Context context) {
        super(context, "QLSP", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQl_Create_TABLE_SANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sanpham;");
    }
}

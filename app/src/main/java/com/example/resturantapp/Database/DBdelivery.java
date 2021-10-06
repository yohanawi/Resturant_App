package com.example.resturantapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBdelivery extends SQLiteOpenHelper {
    public static final String DBNAME = "cash_on.db";

    public DBdelivery(Context context) {
        super(context, "cash_on.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table users(citycode TEXT primary key, address TEXT, city TEXT, phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String citycode, String address, String city, String phone) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("citycode", citycode);
        contentValues.put("address", address);
        contentValues.put("city", city);
        contentValues.put("phone", phone);

        long result = sqLiteDatabase.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;
}
}

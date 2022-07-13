package com.aakash.recycleviewsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "Studentdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        //DB.execSQL("create Table Userdetails(name TEXT primary key, email TEXT, age TEXT)");
        DB.execSQL("Create Table Studentdetails(name TEXT primary key, ad TEXT, phone TEXT, bg TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Studentdetails");
    }

    public boolean insertuserdata(String name, String ad, String phone, String bg)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("ad",ad);
        contentValues.put("phone",phone);
        contentValues.put("bg",bg);
        long result = DB.insert("Studentdetails",null,contentValues);

        //long result = DB.insert("Userdetails",null,contentValues);
        if(result==-1)
        {
            return  false;
        }
        else {
            return true;
        }

    }
    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Studentdetails",null);

        //Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        return cursor;
    }
}

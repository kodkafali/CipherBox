package com.emre.cip;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
    private static final String Veritabani_Adi="kayitlar";
    private static final int SURUM=1;
    DataBase db;
    public DataBase(Context c){
        super(c,Veritabani_Adi,null,SURUM);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE bilgiler(alan TEXT, sifre TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST bilgiler");
        onCreate(db);
    }
    public void sil(){
        SQLiteDatabase d1=db.getReadableDatabase();
        d1.delete("bilgiler",null,null);
    }

}

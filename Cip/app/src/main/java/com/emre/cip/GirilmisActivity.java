package com.emre.cip;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

public class GirilmisActivity extends Activity {

    Button ekle,ara,sil;
    EditText alan,sifre;
    public DataBase d1;
    final Context context=this;
    //RelativeLayout l;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_girilmis);
        //l=(RelativeLayout)findViewById(R.id.back);
        //l.setBackgroundColor(Color.parseColor("#00FFFF"));
        d1=new DataBase(this);
        alan=(EditText)findViewById(R.id.ALAN);
        sifre=(EditText)findViewById(R.id.SIFRE);
        ekle=(Button)findViewById(R.id.EKLE);
        ara=(Button)findViewById(R.id.ara);
        sil=(Button)findViewById(R.id.sil_girilmis);
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sil();
            }
        });
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uzn,uzn1;
                uzn=alan.getText().length();
                uzn1=sifre.getText().length();
                String aranan=alan.getText().toString();
                String sifrem=sifre.getText().toString();


                String rw="SELECT alan FROM bilgiler WHERE alan like '"+aranan+"'";
                SQLiteDatabase d= d1.getReadableDatabase();
                Cursor c=d.rawQuery(rw, null);
                int a=c.getCount();
                if(sifrem.equals("") || aranan.equals("")){
                    Toast.makeText(GirilmisActivity.this,"Lutfen bos alan birakmayiniz.",Toast.LENGTH_SHORT).show();
                }else {
                    if (a!=0) {
                        Toast.makeText(GirilmisActivity.this, "Zaten bu alani kullanmissiniz", Toast.LENGTH_SHORT).show();
                    } else {
                        ekleme(alan.getText().toString(), sifre.getText().toString());
                        Toast.makeText(GirilmisActivity.this, "Isleminiz basarili bir sekilde gerceklesti.", Toast.LENGTH_SHORT).show();
                        alan.getText().delete(0,uzn);
                        sifre.getText().delete(0,uzn1);
                    }
                }

            }
        });
        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arama();
            }
        });


    }

    private void sil(){
        Intent intent=new Intent(this,SilActivity.class);
        startActivity(intent);
    }
    private void ekleme(String alan,String sifre){
        SQLiteDatabase db=d1.getWritableDatabase();
        ContentValues cv1=new ContentValues();
        cv1.put("alan",alan);
        cv1.put("sifre",sifre);
        db.insertOrThrow("bilgiler", null, cv1);
    }
    private void arama(){
        Intent i=new Intent(this,AramaActivity.class);
        startActivity(i);
    }

}

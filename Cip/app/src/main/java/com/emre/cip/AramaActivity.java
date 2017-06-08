package com.emre.cip;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class AramaActivity extends Activity {

    Button geri,ara,cık,farklıara;
    EditText aramayeri;
    private DataBase db;
    final Context context=this;
    //RelativeLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_arama);
        //l=(RelativeLayout)findViewById(R.id.back);
        //l.setBackgroundColor(Color.parseColor("#00FFFF"));
        geri=(Button)findViewById(R.id.geri);
        ara=(Button)findViewById(R.id.aramak);
        cık=(Button)findViewById(R.id.cik_arama);
        farklıara=(Button)findViewById(R.id.farklıara);
        farklıara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                farklıarama();
            }
        });
        cık.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cik();
            }
        });
        aramayeri=(EditText)findViewById(R.id.editText);
        db=new DataBase(this);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });
        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase d1 = db.getReadableDatabase();
                String arama_kelimesi = aramayeri.getText().toString();
                Cursor c = d1.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi + "' ", null);
                if (c != null) {
                    if (c.moveToNext()) {
                        do {
                            String sifrem = c.getString(c.getColumnIndex("sifre"));
                            Toast.makeText(AramaActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                            Log.v("Şifreniz", sifrem);
                        } while (c.moveToNext());

                    } else {
                        Toast.makeText(AramaActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
    public void geri(){
        Intent intent=new Intent(this,GirilmisActivity.class);
        startActivity(intent);

    }
    public void cik(){
        Intent intent= new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void farklıarama(){
        Intent intent=new Intent(this,FarkliActivity.class);
        startActivity(intent);
    }
}

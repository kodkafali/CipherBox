package com.emre.cip;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class KisiselActivity extends AppCompatActivity {
    private String[] alanlar={"Pin","Telefon","Bilgisayar","Kapı"};
    ListView list;
    Button geri,çık;
    String arama_kelimesi_p="pin";
    String arama_kelimesi_t="telefon";
    String arama_kelimesi_b="bilgisayar";
    String arama_kelimesi_k="kapı";
    final Context context=this;
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_kisisel);
        db=new DataBase(this);
        list=(ListView)findViewById(R.id.kisisel);
        ArrayAdapter<String> veri= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,alanlar);
        list.setAdapter(veri);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        SQLiteDatabase d1 = db.getReadableDatabase();
                        Cursor c = d1.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_p + "' ", null);
                        if (c != null) {
                            if (c.moveToNext()) {
                                do {
                                    String sifrem = c.getString(c.getColumnIndex("sifre"));
                                    Toast.makeText(KisiselActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c.moveToNext());

                            } else {
                                Toast.makeText(KisiselActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                    case 1:
                        SQLiteDatabase d2 = db.getReadableDatabase();
                        Cursor c1 = d2.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_t + "' ", null);
                        if (c1 != null) {
                            if (c1.moveToNext()) {
                                do {
                                    String sifrem = c1.getString(c1.getColumnIndex("sifre"));
                                    Toast.makeText(KisiselActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c1.moveToNext());

                            } else {
                                Toast.makeText(KisiselActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                    case 2:
                        SQLiteDatabase d3 = db.getReadableDatabase();
                        Cursor c2 = d3.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_b + "' ", null);
                        if (c2 != null) {
                            if (c2.moveToNext()) {
                                do {
                                    String sifrem = c2.getString(c2.getColumnIndex("sifre"));
                                    Toast.makeText(KisiselActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c2.moveToNext());

                            } else {
                                Toast.makeText(KisiselActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                    case 3:
                        SQLiteDatabase d4 = db.getReadableDatabase();
                        Cursor c3 = d4.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_k + "' ", null);
                        if (c3 != null) {
                            if (c3.moveToNext()) {
                                do {
                                    String sifrem = c3.getString(c3.getColumnIndex("sifre"));
                                    Toast.makeText(KisiselActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c3.moveToNext());

                            } else {
                                Toast.makeText(KisiselActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                }
            }
        });
        geri=(Button)findViewById(R.id.geri_kisisel);
        çık=(Button)findViewById(R.id.çık_kisisel);
        çık.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                çık();
            }
        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });



    }
    public void çık(){
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void geri(){
        Intent intent=new Intent(this,FarkliActivity.class);
        startActivity(intent);

    }

}

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

public class PostaActivity extends AppCompatActivity {
    private String[] alanlar={"Gmail","Hotmail","Mynet","Yahoo"};
    ListView list;
    Button geri,çık;
    String arama_kelimesi_g="gmail";
    String arama_kelimesi_h="hotmail";
    String arama_kelimesi_m="mynet";
    String arama_kelimesi_y="yahoo";
    final Context context=this;
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_posta);
        db=new DataBase(this);
        list=(ListView)findViewById(R.id.posta);
        ArrayAdapter<String> veri= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,alanlar);
        list.setAdapter(veri);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        SQLiteDatabase d1 = db.getReadableDatabase();
                        Cursor c = d1.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_g + "' ", null);
                        if (c != null) {
                            if (c.moveToNext()) {
                                do {
                                    String sifrem = c.getString(c.getColumnIndex("sifre"));
                                    Toast.makeText(PostaActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c.moveToNext());

                            } else {
                                Toast.makeText(PostaActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                    case 1:
                        SQLiteDatabase d2 = db.getReadableDatabase();
                        Cursor c1 = d2.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_h + "' ", null);
                        if (c1 != null) {
                            if (c1.moveToNext()) {
                                do {
                                    String sifrem = c1.getString(c1.getColumnIndex("sifre"));
                                    Toast.makeText(PostaActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c1.moveToNext());

                            } else {
                                Toast.makeText(PostaActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                    case 2:
                        SQLiteDatabase d3 = db.getReadableDatabase();
                        Cursor c2 = d3.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_m + "' ", null);
                        if (c2 != null) {
                            if (c2.moveToNext()) {
                                do {
                                    String sifrem = c2.getString(c2.getColumnIndex("sifre"));
                                    Toast.makeText(PostaActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c2.moveToNext());

                            } else {
                                Toast.makeText(PostaActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                    case 3:
                        SQLiteDatabase d4 = db.getReadableDatabase();
                        Cursor c3 = d4.rawQuery("SELECT sifre FROM bilgiler WHERE alan like '" + arama_kelimesi_y + "' ", null);
                        if (c3 != null) {
                            if (c3.moveToNext()) {
                                do {
                                    String sifrem = c3.getString(c3.getColumnIndex("sifre"));
                                    Toast.makeText(PostaActivity.this, "ŞİFRENİZ: " + sifrem + "", Toast.LENGTH_SHORT).show();
                                    Log.v("Şifreniz", sifrem);
                                } while (c3.moveToNext());

                            } else {
                                Toast.makeText(PostaActivity.this, "BULUNAMADI", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                }
            }
        });
        geri=(Button)findViewById(R.id.Geri_posta);
        çık=(Button)findViewById(R.id.çık_posta);
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



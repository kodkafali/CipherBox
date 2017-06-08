package com.emre.cip;


import android.app.AlertDialog;
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
import android.widget.Toast;

public class SilActivity extends Activity {

    Button  sil,geri,tum;
    EditText text;
    final Context context=this;
    DataBase d;
    LoginDataBaseAdapter lg;
    //RelativeLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sil);
        //l=(RelativeLayout)findViewById(R.id.back);
        //l.setBackgroundColor(Color.parseColor("#00FFFF"));
        d=new DataBase(this);
        lg=new LoginDataBaseAdapter(this);
        text=(EditText)findViewById(R.id.editText2);
        sil=(Button)findViewById(R.id.sil);
        geri=(Button)findViewById(R.id.geri1);
        tum=(Button)findViewById(R.id.tum_sil);
        tum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db=d.getReadableDatabase();
                db.delete("bilgiler",null,null);
                String rw="SELECT alan FROM bilgiler";
                Cursor c=db.rawQuery(rw, null);
                int a=c.getCount();
                if(a==0)
                {
                    lg.sil();
                    Toast.makeText(SilActivity.this,"Üyeliğinizde dahil olmak üzere tüm kayıtlarınız silindi.",Toast.LENGTH_SHORT).show();
                    silik();

                }else
                {
                    Toast.makeText(SilActivity.this,"Silme İşlemi Başarısız.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gelen=text.getText().toString();
                SQLiteDatabase db=d.getReadableDatabase();
                int row = db.delete("bilgiler", "alan = ?", new String[]{gelen});
                if(row>0)
                {
                    Toast.makeText(SilActivity.this,"Silme İşlemi Gerçekleşti.",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(SilActivity.this,"Silme İşlemi Başarısız..",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void geri(){
        Intent intent=new Intent(this,GirilmisActivity.class);
        startActivity(intent);
    }
    private void silik()
    {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

}

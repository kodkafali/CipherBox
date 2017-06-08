package com.emre.cip;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Button;

public class FarkliActivity extends AppCompatActivity {

    private String[] alanlar={"Sosyal Medya","Bankalar","Kişisel","E-Posta"};
    ListView listem;
    Button geri,çık;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_farkli);
        geri=(Button)findViewById(R.id.geri_fark);
        çık=(Button)findViewById(R.id.çık_fark);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });
        çık.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                çık();
            }
        });
        listem=(ListView)findViewById(R.id.liste);
        ArrayAdapter<String> veri= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,alanlar);
        listem.setAdapter(veri);
        listem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                            sosyal();
                        break;
                    case 1:
                            banka();
                        break;
                    case 2:
                            kisisel();
                        break;
                    case 3:
                            posta();
                        break;

                }
            }
        });



    }
    public void sosyal(){
        Intent intent=new Intent(this,SosyalActivity.class);
        startActivity(intent);
    }
    public void banka(){
        Intent intent=new Intent(this,BankaActivity.class);
        startActivity(intent);
    }
    public void kisisel(){
        Intent intent=new Intent(this,KisiselActivity.class);
        startActivity(intent);
    }
    public void posta(){
        Intent intent=new Intent(this,PostaActivity.class);
        startActivity(intent);
    }
    public void çık(){
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void geri(){
        Intent intent=new Intent(this,AramaActivity.class);
        startActivity(intent);
    }


}

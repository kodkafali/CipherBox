package com.emre.cip;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class KulActivity extends AppCompatActivity {
    Button ger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_kul);
        ger=(Button)findViewById(R.id.ger);
        ger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });
    }
    public void geri(){
        Intent i =new Intent(this,HomeActivity.class);
        startActivity(i);
    }

}

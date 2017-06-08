package com.emre.cip;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SingUpActivity extends Activity {

    EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    Button btnCreateAccount,geri;
    final Context context=this;
    LoginDataBaseAdapter loginDataBaseAdapter;
    //LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sing_up);
        //l=(LinearLayout)findViewById(R.id.back);
        //l.setBackgroundColor(Color.parseColor("#00FFFF"));

        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
        geri=(Button)findViewById(R.id.gerile);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub


                int username,pass,confirm;
                username=editTextUserName.getText().length();
                pass=editTextPassword.getText().length();
                confirm=editTextPassword.getText().length();
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();
                // check if any of the fields are vaccant
                if(loginDataBaseAdapter.toplamrow()==0){
                    if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Lutfen tum bosluklari Doldurunuz..", Toast.LENGTH_LONG).show();
                        return;
                    }
                    // check if both password matches
                    if(!password.equals(confirmPassword))
                    {
                        Toast.makeText(getApplicationContext(), "Sifreler uyusmuyor lutfen Kontrol Ediniz..", Toast.LENGTH_LONG).show();
                        return;
                    }
                    else
                    {
                        // Save the Data in Database
                        loginDataBaseAdapter.insertEntry(userName, password);
                        editTextConfirmPassword.getText().delete(0,confirm);
                        editTextPassword.getText().delete(0,pass);
                        editTextUserName.getText().delete(0,username);
                        Toast.makeText(getApplicationContext(), "Kaydiniz tamamlandi. ", Toast.LENGTH_LONG).show();
                        girildi();
                    }
                }else
                {
                    Toast.makeText(getApplicationContext(),"Uyeliginiz bulunmamaktadir",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void girildi(){
        Intent gec= new Intent(this,HomeActivity.class);
        startActivity(gec);
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
    public void geri(){
        Intent i=new Intent(this,HomeActivity.class);
        startActivity(i);
    }


}

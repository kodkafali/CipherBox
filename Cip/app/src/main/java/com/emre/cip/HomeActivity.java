package com.emre.cip;


import android.widget.Toast;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.*;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class HomeActivity extends Activity {


	Button btnSignIn, btnSignUp,hak;
	LoginDataBaseAdapter loginDataBaseAdapter;
	DataBase data;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.content_home);

		 hak=(Button)findViewById(R.id.hak);
		 hak.setOnClickListener(new View.OnClickListener() {
			 @Override
			 public void onClick(View v) {
				 hak();
			 }
		 });
	     
	     // create a instance of SQLite Database
	     loginDataBaseAdapter =new LoginDataBaseAdapter(this);
	     loginDataBaseAdapter=loginDataBaseAdapter.open();
		 data=new DataBase(this);

	     // Get The Refference Of Buttons
	     btnSignIn=(Button)findViewById(R.id.buttonSignIN);
	     btnSignUp=(Button)findViewById(R.id.buttonSignUP);


				// Set OnClick Listener on SignUp button
				btnSignUp.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						// TODO Auto-generated method stub

						/// Create Intent for SignUpActivity  and Start The Activity
						if (loginDataBaseAdapter.toplamrow() != 0) {
							Toast.makeText(getApplicationContext(), "Zaten üyesiniz!!", Toast.LENGTH_SHORT).show();

						} else {

							Intent intentSignUP = new Intent(getApplicationContext(),SingUpActivity.class);
							startActivity(intentSignUP);
						}
					}
				});



	}

	// Methos to handleClick Event of Sign In Button
	public void signIn(View V)
	   {
			final Dialog dialog = new Dialog(HomeActivity.this);
			dialog.setContentView(R.layout.login);
		    dialog.setTitle("Login");
	
		    // get the Refferences of views
		    final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
		    final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);
		    
			Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);
				
			// Set On ClickListener
			btnSignIn.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// get The User name and Password
					String userName=editTextUserName.getText().toString();
					String password=editTextPassword.getText().toString();


					// fetch the Password form database for respective user name
					String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
					
					// check if the Stored password matches with  Password entered by user
					if(password.equals(storedPassword))
					{
						Toast.makeText(HomeActivity.this, "Giris Saglandi..", Toast.LENGTH_LONG).show();
						dialog.dismiss();
						//singin yaptıktan sonra burdan yönlendir.
						gec(getCurrentFocus());
					}
					else
					{
						Toast.makeText(HomeActivity.this, "Sifreler uymuyor lutfen kontrol ediniz.", Toast.LENGTH_LONG).show();
					}
				}
			});
			
			dialog.show();
	}
	public void gecis(){
		Intent intent=new Intent(this,KulActivity.class);
		startActivity(intent);
	}
	public void gec(View view){
		Intent gec=new Intent(this,GirilmisActivity.class);
		startActivity(gec);
	}
	public void hak(){
		Intent i=new Intent(this,KulActivity.class);
		startActivity(i);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	    // Close The Database
		loginDataBaseAdapter.close();
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//return super.onKeyDown(keyCode, event);
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent i=new Intent(this,HomeActivity.class);
			startActivity(i);

		}
		return true;
	}

}

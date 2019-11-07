package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtUsername;
    TextView txtPassword;
    Button btnLogin;
    SharedPreferences shPref;
    Intent detailsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        detailsIntent = new Intent(MainActivity.this,DetailsActivity.class);
       

    }

    public void saveLoginCredentialsAndGoDetailsScreen(View view){

        shPref = getSharedPreferences("user_details",MODE_PRIVATE);
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        if(username.equals("shuoling") && password.equals("shuoling111")){
            SharedPreferences.Editor editor = shPref.edit();
            editor.putString("username",username);
            editor.putString("password",password);
            editor.commit();
            Toast.makeText(this,"Login successful",Toast.LENGTH_LONG).show();
            startActivity(detailsIntent);
        }else{
            Toast.makeText(this,"Login credentials invalid",Toast.LENGTH_LONG).show();
        }

    }
}

package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView txtUserLoggedInName;
    SharedPreferences shrPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        shrPref = getSharedPreferences("user_details",MODE_PRIVATE);
        setUserLoggedInCredentials();
    }

    private void setUserLoggedInCredentials(){

        txtUserLoggedInName = (TextView) findViewById(R.id.txtUserLoggedInName);
        String username = shrPref.getString("username",null);
        txtUserLoggedInName.setText("Hello " + username + "!");

    }

    public void logOut(View view){
        Intent loginIntent = new Intent(DetailsActivity.this,MainActivity.class);
        //SharedPreferences.Editor editor = shrPref.edit();
        //editor.clear();
        //editor.commit();
        startActivity(loginIntent);
    }
}

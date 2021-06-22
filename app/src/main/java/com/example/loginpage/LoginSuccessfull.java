package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LoginSuccessfull extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successfull);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        @Override
        public void onBackPressed() {
            super.onBackPressed();
            startActivity(new Intent(getApplicationContext(),loginPage.class));
        }
    }

  package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginPage extends AppCompatActivity {
    EditText etLoginUserName,etLoginPassword;
    Button logBtn;
    int i =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        etLoginUserName=findViewById(R.id.editTextUserNameLogin);
        etLoginPassword=findViewById(R.id.editTextPasswordLogin);
        logBtn=findViewById(R.id.buttonSignIn);

        String regUname=getIntent().getStringExtra("username");
        String regPass=getIntent().getStringExtra("password");

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = etLoginUserName.getText().toString();
                String upass =  etLoginPassword.getText().toString();

                if (regUname.equals(uname) && regPass.equals(upass))
                {
                    Intent intent = new Intent(loginPage.this,LoginSuccessfull.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginPage.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
                i--;
                if(i==0)
                {
                    Toast.makeText(getBaseContext(),"Failed Login Attempts",Toast.LENGTH_LONG).show();
                    logBtn.setEnabled(false);
                }
            }
        });

    }
}
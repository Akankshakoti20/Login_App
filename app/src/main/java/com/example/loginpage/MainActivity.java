package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etSignUpUserName, etSignUpPassword,pwdval;
    Button signButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSignUpUserName = findViewById(R.id.editTextUserName);
        etSignUpPassword = findViewById(R.id.editTextPassword);
        signButton = findViewById(R.id.buttonSignUp);

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = etSignUpUserName.getText().toString();
                String pwd = etSignUpPassword.getText().toString();

                if(!pwdval(pwd))
                {
                    Toast.makeText(MainActivity.this,"Password doesn't match",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, loginPage.class);
                    intent.putExtra("username", uname);
                    intent.putExtra("password", pwd);
                    startActivity(intent);
                }
            }
        });
    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacter = Pattern.compile("^.*[@#$%&*].*$");

    private Boolean pwdval(String password){
        if(password.length()<8){
            Log.d("test","len");
            return false;
        }
        if(!lowercase.matcher(password).matches()){
            Log.d("test","low");
            return false;
        }
        if(!uppercase.matcher(password).matches()){
            Log.d("test","up");
            return false;
        }
        if(!number.matcher(password).matches()){
            Log.d("test","num");
            return false;
        }
        if(!specialCharacter.matcher(password).matches()){
            Log.d("test","spl");
            return false;
        }
        return true;
    }

}

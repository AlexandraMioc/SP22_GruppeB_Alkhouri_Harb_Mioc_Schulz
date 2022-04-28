package com.example.minimalloginfunction;

import static com.example.minimalloginfunction.RegisterScreen.PASSWORD;
import static com.example.minimalloginfunction.RegisterScreen.USERNAME;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class LoginScreen extends Activity {
    public static final String EXTRA_TEXT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);
    }

    public void onClickLoginTry(View v){

        EditText userNameLogin = findViewById(R.id.userNameLogin);
        EditText passWordLogin = findViewById(R.id.passWordLogin);
        if(v.getId() == R.id.loginButton) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String userName = sharedPreferences.getString(USERNAME, "");
            String passWord = sharedPreferences.getString(PASSWORD, "");
            if (userNameLogin.getText().toString().equals(userName) && passWordLogin.getText().toString().equals(passWord)) {
                Intent rightData = new Intent(this, LoginSuccess.class);
                startActivity(rightData);
            } else if (userNameLogin.getText().toString().equals("") || passWordLogin.getText().toString().equals("")) {
            } else {
                Intent wrongData = new Intent(this, LoginFail.class);
                wrongData.putExtra(EXTRA_TEXT, LoginScreen.securityCode());
                startActivity(wrongData);
            }
        }
    }

    public static String securityCode() {
        Random securityCodeGenerator = new Random();
        StringBuilder code = new StringBuilder();

        for(int i = 0; i < 4; i++){
            code.append(securityCodeGenerator.nextInt(9));
        }
        return code.toString();
    }
}

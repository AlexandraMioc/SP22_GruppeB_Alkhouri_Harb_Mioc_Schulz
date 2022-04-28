package com.example.minimalloginfunction;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class RegisterScreen extends Activity {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerscreen);
    }

    public void onClickSignUp(View v){
        EditText userNameRegister = findViewById(R.id.userNameRegister);
        EditText passWordRegister = findViewById(R.id.passWordRegister);
        if(v.getId() == R.id.signUpButton) {
            Intent acceptedUserData = new Intent(RegisterScreen.this, LoginScreen.class);
            if (!(userNameRegister.getText().toString().equals("") || passWordRegister.getText().toString().equals(""))) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(USERNAME, userNameRegister.getText().toString());
                editor.putString(PASSWORD, passWordRegister.getText().toString());
                editor.apply();
                startActivity(acceptedUserData);
            }
        }
    }


}
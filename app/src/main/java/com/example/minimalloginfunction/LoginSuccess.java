package com.example.minimalloginfunction;

import static android.widget.TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM;
import static com.example.minimalloginfunction.RegisterScreen.PASSWORD;
import static com.example.minimalloginfunction.RegisterScreen.USERNAME;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.widget.TextViewCompat;

public class LoginSuccess extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsuccess);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String receivedName = sharedPreferences.getString(USERNAME, "");
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("   Welcome back, " + receivedName +"!");
    }

    private void hideKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }

    public void onClickChangePassword(View v) {
        EditText newPassword = findViewById(R.id.newPassword);
        if(v.getId() == R.id.changePasswordButton) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();



            if (!(newPassword.getText().toString().equals(""))) {
                editor.putString(PASSWORD, newPassword.getText().toString());
                editor.apply();
                newPassword.setText("");
                hideKeyboard(v);
                Toast.makeText(this, "Password changed", Toast.LENGTH_SHORT).show();

            }

        }
    }

    public void onClickBackToLogin(View v){
        if(v.getId() == R.id.backToLoginButton) {
            Intent backToLogin = new Intent(this, LoginScreen.class);
            startActivity(backToLogin);
        }

    }
}

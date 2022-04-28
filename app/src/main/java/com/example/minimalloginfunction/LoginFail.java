package com.example.minimalloginfunction;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginFail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginfail);

        Intent receivedSecurityCode = getIntent();
        String receivedCode = receivedSecurityCode.getStringExtra(LoginScreen.EXTRA_TEXT);

        TextView securityCode = findViewById(R.id.securityCode);
        securityCode.setText(receivedCode);
    }

    public void onClickTryAgain(View v) {
        Intent receivedSecurityCode = getIntent();
        String receivedCode = receivedSecurityCode.getStringExtra(LoginScreen.EXTRA_TEXT);
        EditText enterCode = findViewById(R.id.enterCode);
        if (v.getId() == R.id.loginButton) {
            Intent rightCode = new Intent(this, LoginScreen.class);
            if (enterCode.getText().toString().equals(receivedCode)) {
                startActivity(rightCode);
            }else {
                enterCode.setText("");
            }
        }
    }


}

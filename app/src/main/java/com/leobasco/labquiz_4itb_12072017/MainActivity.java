package com.leobasco.labquiz_4itb_12072017;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText et_user;
    EditText et_pass;
    Button btn_Rem;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_user = (EditText) findViewById(R.id.etUser);
        et_pass = (EditText) findViewById(R.id.etPass);
        btn_Rem = (Button) findViewById(R.id.btnRemMe);
        btn_Login = (Button) findViewById(R.id.btnLogin);

        et_user.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String user = preferences.getString("username","");
                String pass = preferences.getString("password","");

                String sUsername = et_user.getText().toString();

                if(!user.isEmpty()) {
                    if (sUsername.equals(user)) {
                        et_pass.setText(pass);
                        et_pass.setBackgroundColor(Color.YELLOW);
                    }
                    else if (!(sUsername.equals(user))){
                        et_pass.setText("");
                        et_pass.setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                return false;
            }
        });

        et_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String user = preferences.getString("username","");
                    String pass = preferences.getString("password","");

                    String sUsername = et_user.getText().toString();

                    if(!user.isEmpty()) {
                        if (sUsername.equals(user)) {
                            et_pass.setText(pass);
                            et_pass.setBackgroundColor(Color.YELLOW);
                        }
                        else if (!(sUsername.equals(user))){
                            et_pass.setText("");
                            et_pass.setBackgroundColor(Color.TRANSPARENT);
                        }
                    }

                }
            }
        });
    }

    public void rememberMe (View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_user.getText().toString());
        editor.putString("password", et_pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Preference Saved!", Toast.LENGTH_SHORT).show();

    }

    public void login (View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
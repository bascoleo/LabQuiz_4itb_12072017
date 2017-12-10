package com.leobasco.labquiz_4itb_12072017;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    TextView tv_user;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_user = (TextView) findViewById(R.id.tvUser);
        btn_logout = (Button) findViewById(R.id.btnLogout);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tv_user.setText(user);

    }

    public void logout (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
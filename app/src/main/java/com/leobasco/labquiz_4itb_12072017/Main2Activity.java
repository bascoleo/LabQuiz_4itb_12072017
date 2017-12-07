package com.leobasco.labquiz_4itb_12072017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView tv_welcome;
    TextView tv_message;
    Button btn_logout;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_welcome = (TextView) findViewById(R.id.tv_welcome);
        tv_message = (TextView) findViewById(R.id.tv_message);
        btn_logout = (Button) findViewById(R.id.btnLogout);

        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try{
            fis = openFileInput("output.txt");
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        tv_message.setText(buffer.toString());
    }
    public void house (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
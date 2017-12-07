package com.leobasco.labquiz_4itb_12072017;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.leobasco.labquiz_4itb_12072017.;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    EditText et_user;
    EditText et_pass;
    Button btn_rem;
    Button btn_login;
    FileOutputStream fos;
    FileInputStream fis;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        et_user = (EditText) findViewById(R.id.et_user);
        et_pass = (EditText) findViewById(R.id.et_pass);
        btn_rem = (Button) findViewById(R.id.btnRem);
        btn_login = (Button) findViewById(R.id.btnLogin);
        textview = (TextView) findViewById(R.id.textView);

    }
    public void saveStorage (View view) {
        String message = et_user.getText().toString();
        String message2 = et_pass.getText().toString();
        try {
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(message.getBytes());
            fos.write(message2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Message saved!", Toast.LENGTH_SHORT).show();
    }
    public void act (View view){
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
        String user = et_user.getText().toString();
        String pass = et_pass.getText().toString();
        if(buffer.toString().equals(user +""+pass)) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();
        }
    }
}


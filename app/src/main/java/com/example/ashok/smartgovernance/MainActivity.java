 package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }



    public void login(View v)
    {

        setContentView(R.layout.welcome_screen);


    }

    public void b1(View view) {
        startActivity(new Intent(MainActivity.this,Notice.class));
    }
    public void b2(View view) {
        startActivity(new Intent(MainActivity.this,complains.class));
    }
    public void b3(View view) {

       // startActivity(new Intent(MainActivity.this,Feedback.class));
        startActivity(new Intent(MainActivity.this,Discussion.class));
    }
    public void b4(View view) {
        startActivity(new Intent(MainActivity.this,Doc.class));
    }
    public void b5(View view) {
        startActivity(new Intent(MainActivity.this,Service.class));
    }
    public void b6(View view) {
        startActivity(new Intent(MainActivity.this,Registration.class));
    }
    public void forget(View view) {
        startActivity(new Intent(MainActivity.this,Registration.class));
    }
    public void gov(View view) {
        startActivity(new Intent(MainActivity.this,Government.class));
    }
}

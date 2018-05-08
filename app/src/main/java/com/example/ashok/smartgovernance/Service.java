 package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void s1(View view) {

        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:9845604979"));
        startActivity(i);
    }

    public void s2(View view) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:9845604979"));
        startActivity(i);
    }


    public void s3(View view) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:9845604979"));
        startActivity(i);
    }

    public void s4(View view) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:9845604979"));
        startActivity(i);
    }

    public void s5(View view) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:9845604979"));
        startActivity(i);
    }

}

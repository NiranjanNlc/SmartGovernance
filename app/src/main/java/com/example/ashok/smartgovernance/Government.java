package com.example.ashok.smartgovernance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Government extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government);
    }
    public void adcomp(View view) {
        startActivity(new Intent(Government.this,adressComplain.class));
    }
    public void reg(View view) {
        startActivity(new Intent(Government.this,ApproveRegistrartion.class));
    }
    public void vfeed(View view) {
        startActivity(new Intent(Government.this,ViewFeedback.class));
    }





}

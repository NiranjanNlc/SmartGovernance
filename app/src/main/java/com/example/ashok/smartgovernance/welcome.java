package com.example.ashok.smartgovernance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class welcome extends AppCompatActivity {
        private Context ctx;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);


    }
    public void b1(View view) {
        startActivity(new Intent( this,Notice.class));
    }
    public void b2(View view) {
        startActivity(new Intent( this,complains.class));
    }
    public void b3(View view) {
       

       startActivity(new Intent( this,Discussion.class));
    }
    public void b4(View view) {
        startActivity(new Intent( this,Doc.class));
    }
    public void b5(View view) {
        startActivity(new Intent( this,Service.class));
    }
    public void b6(View view) {
        startActivity(new Intent( this,Registration.class));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent( this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }
}

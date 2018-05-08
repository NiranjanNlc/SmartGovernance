package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Complain extends AppCompatActivity implements View.OnClickListener{
    EditText nam ;
    EditText mail;
    EditText top;
    EditText loc;
    EditText comp;
    ImageView img;

    Button ch,s;
    private Bitmap bitmap;
    private final int IMG_REQUEST = 1;
    public static final String KEY_name  ="name";
    public static final String KEY_email ="email";
    public static final String KEY_topics ="topics";
    public static final String KEY_location ="location";
    public static final String KEY_complainMsg ="complainMsg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complain);
         nam = (EditText) findViewById(R.id.nam);
        mail= (EditText) findViewById(R.id.mail);
         top = (EditText) findViewById(R.id.top);
        loc = (EditText) findViewById(R.id.loc);
        comp = (EditText) findViewById(R.id.comp);
         img = (ImageView) findViewById(R.id.img);
        ch = (Button)findViewById(R.id.ch);
         s =(Button) findViewById(R.id.s);
        ch.setOnClickListener(this);
           }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
          switch (v.getId())
          {
              case R.id.ch :
                  selectImage();
                  break;




          }
    }
    private  void selectImage()
    {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i,IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!= null)
        {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                img.setImageBitmap(bitmap);
                img.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

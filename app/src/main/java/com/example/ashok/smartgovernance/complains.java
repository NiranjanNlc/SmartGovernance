package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class complains extends AppCompatActivity implements View.OnClickListener {
    private EditText ename;
    private EditText emails;
    private EditText loc;
    private EditText comp;
    private EditText top;
    private ImageView img;
    private Button upload, buttonSend, B1;
    public static final String KEY_name = "name";
    public static final String KEY_email = "email";
    public static final String KEY_topic = "topic";
    public static final String KEY_location = "location";
    public static final String KEY_complainMsg = "complainMsg";
    public static final String KEY_IMG = "image";

  //   private String name, location, email, complainMsg, topic;
  private Bitmap bitmap;
    private final int IMG_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complains);
        ename = (EditText) findViewById(R.id.ename);
        emails = (EditText) findViewById(R.id.emails);
        top = (EditText) findViewById(R.id.top);
        loc = (EditText) findViewById(R.id.loc);
        comp = (EditText) findViewById(R.id.comp);
        img = (ImageView) findViewById(R.id.img);
        upload = (Button) findViewById(R.id.upload);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        upload.setOnClickListener(this);
        buttonSend.setOnClickListener((View.OnClickListener) this);
    }

    private void SendComplain() {
        final String name = (String) ename.getText().toString().trim();
        final String email = (String) emails.getText().toString().trim();
        final String topic = (String) top.getText().toString().trim();
        final String location = (String) loc.getText().toString().trim();
        final String complainMsg = (String) comp.getText().toString().trim();

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:/192.168.229.50/SmartGovernance/includes/DbConnect.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(complains.this, response, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(complains.this,MainActivity.class));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(complains.this, error.toString(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(complains.this,MainActivity.class));
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(KEY_name, name);
                parameters.put(KEY_email, email);
                parameters.put(KEY_topic, topic);
                parameters.put(KEY_location, location);
                parameters.put(KEY_complainMsg, complainMsg);
                parameters.put(KEY_IMG,imageToString(bitmap));
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSend:
                SendComplain();
                break;
            case R.id.upload:
                selectImage();
                break;

        }

    }

    private void selectImage() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, IMG_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                img.setImageBitmap(bitmap);
                img.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
     private String imageToString (Bitmap bitmap)
     {
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
         byte [] imgBytes = byteArrayOutputStream.toByteArray();
         return Base64.encodeToString(imgBytes,Base64.DEFAULT);
     }

}

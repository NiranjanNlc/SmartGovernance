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
import java.io.IOException;

public class UploadNotice extends AppCompatActivity implements View.OnClickListener {
       EditText tit, ncon ;
       ImageView noticeimage ;
    private static final String URL_NOTICE = "http://niranjanlamichhane.com/SmartGovernance/notification/postnoti.php";
       Button uploadimage , UploadNotice ;
    public static final String KEY_TITLE= "title";
    public static final String KEY_NOTICE= "notice";
    public static final String KEY_IMG = "image";
    private Bitmap bitmap;
    private final int IMG_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_notice);
        tit =(EditText) findViewById(R.id.tit);
        ncon =(EditText) findViewById(R.id.content);
        uploadimage = findViewById(R.id.uploadimage);
        UploadNotice = findViewById(R.id.NoticeUpload);
        noticeimage = findViewById(R.id.noticeimage);
        uploadimage.setOnClickListener(this);
        UploadNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.NoticeUpload:
                SendNotice();
                break;
            case R.id.uploadimage:
                chooseImage();
                break;

        }
    }
    private void chooseImage()
    {
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
               noticeimage.setImageBitmap(bitmap);
                noticeimage.setVisibility(View.VISIBLE);
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

    // aBSA NOTICE PATHAUNAY
     private void SendNotice()
     { Toast.makeText(UploadNotice.this, "processing your request", Toast.LENGTH_LONG).show();
         Toast.makeText(UploadNotice.this, "processing your request", Toast.LENGTH_LONG).show();

         final String title = (String) tit.getText().toString().trim();
         final String content = (String) ncon.getText().toString().trim();
         Toast.makeText(UploadNotice.this,  content, Toast.LENGTH_LONG).show();
          // requst
         StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_NOTICE,
             new Response.Listener<String>() {
                 @Override
                 public void onResponse(String response) {

                     Toast.makeText(UploadNotice.this, response, Toast.LENGTH_LONG).show();
                     startActivity(new Intent(UploadNotice.this,UploadNotice.class));
                 }
             }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     Toast.makeText(UploadNotice.this, error.toString(), Toast.LENGTH_LONG).show();
                     startActivity(new Intent(UploadNotice.this,UploadNotice.class));
                 }
             }) {
                 @Override
                 protected Map<String, String> getParams() throws AuthFailureError {
                     Map<String, String> parameters = new HashMap<String, String>();
                     parameters.put(KEY_TITLE, title);
                     parameters.put(KEY_NOTICE,content);

                     parameters.put(KEY_IMG,imageToString(bitmap));
                     return parameters;
                 }
             };
             RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
     }


}

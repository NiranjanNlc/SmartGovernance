package com.example.ashok.smartgovernance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Government extends Activity {
  EditText post ,code ;
    public static final String KEY_USER = "user";
    public static final String KEY_PASS = "pass";
    private static final String URL_COMPLAIN = "http://niranjanlamichhane.com/SmartGovernance/user/gov.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.govlogin);
        post =(EditText) findViewById(R.id.guid);
        code = (EditText) findViewById(R.id.gpass);


    }
    public void adcomp(View view) {
        startActivity(new Intent(Government.this,adressComplain.class));
    }
    public void reg(View view) {
        startActivity(new Intent(Government.this, UploadNotice.class));
    }
    public void vfeed(View view) {
        startActivity(new Intent(Government.this,ViewFeedback.class));
    }

    public void logi(View v)
    {
        final  String k = post.getText().toString().trim();
        final String l = code.getText().toString().trim();
        if(k.equals("recip")&& l.equals("1234"))
        {
            setContentView(R.layout.activity_government);
        }
        else
        {

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_COMPLAIN,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            responseAnalyzer(response.trim());
                            //  uid.setText( response.toString());

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Error", error.toString());
//                uid.setText(error.toString());
                    Toast.makeText( Government.this, error.toString(), Toast.LENGTH_LONG).show();

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put(KEY_USER, k);
                    parameters.put(KEY_PASS,l);
                    return parameters;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            requestQueue.getCache().clear();
            requestQueue.add(stringRequest);
            //     requestQueue.start();

        }


    }

    private void responseAnalyzer(String r) {
        if(r.equals("a")){
            Toast.makeText(this, "logined ", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_government);

        }else{
            Toast.makeText(this, "invalid login", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.govlogin);
        }
    }


}

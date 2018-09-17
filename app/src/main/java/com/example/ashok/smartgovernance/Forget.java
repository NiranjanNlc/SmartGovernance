package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Forget extends AppCompatActivity {
    Button fb ;
    EditText fuid , fdob , fpass ;
    private static final String URL_COMPLAIN = "http://niranjanlamichhane.com/SmartGovernance/user/getpassword.php";
    public static final String KEY_USER = "user";
    public static final String KEY_PASS = "pass";
    public static final String KEY_DOB= "dob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        fb = findViewById(R.id.fb);
        fuid = findViewById(R.id.fuid);
        fdob =  findViewById(R.id.fdob);
        fpass = findViewById(R.id.fpass);
    }
    public void registerUser(View v)
    {
        register();
    }
    public void register(){
        Toast.makeText(Forget.this,"Registering", Toast.LENGTH_LONG).show();
        final String user = (String)fuid.getText().toString().trim();
        final String password = fpass.getText().toString().trim() ;
        final String dob = (String) fdob.getText().toString().trim();


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_COMPLAIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Forget.this,response.toString(), Toast.LENGTH_LONG).show();
                        resp(response.trim());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Forget.this, error.toString(), Toast.LENGTH_LONG).show();
                fuid.setText(error.toString());

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(KEY_USER,user);
                parameters.put(KEY_PASS,password);
                parameters.put(KEY_DOB,dob);
                return parameters;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        requestQueue.start();


    }



    public void resp(String r)
    {
        switch (r) {
            case "sucess":
                Toast.makeText(Forget.this, "Use this password to login ", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Forget.this,MainActivity.class));
                break;
            case "unmatched":
                Toast.makeText(Forget.this,"date of Birth not matched ", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Forget.this,Forget.class));
                break;

            default:
                Toast.makeText(Forget.this,"date of Birth  ", Toast.LENGTH_LONG).show();
                break;
        }
    }
}

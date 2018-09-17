package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

public class Login extends AppCompatActivity {
    public static final String KEY_USER = "user";
    public static final String KEY_PASS = "pass";

    EditText uid ,pass ;
    Button log ;
    private static final String URL_COMPLAIN = "http:/192.168.1.18/SmartGovernance/user/login.php";
    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        uid = findViewById(R.id.uid);
        pass = findViewById( (R.id.pass));
        log = findViewById(R.id.btn_login);
    }
    public void login(View v)
    {
        Log.i(TAG, "Activity created");

        final String user = (String)uid.getText().toString().trim();
        final String password = (String) pass.getText().toString().trim();


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_COMPLAIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseAnalyzer(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                uid.setText(error.toString());
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(KEY_USER,user);
                parameters.put(KEY_PASS,password);
                return parameters;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);




    }
    public  void responseAnalyzer(String r)
    {
        switch (r) {
            case "logined":
                slogin(r);
                break;
            case "wrongPassword":
                wlogin(r);
                break;

            default:

                break;
        }


    }
    private void slogin (String r)
    {
        Toast.makeText(Login.this, r , Toast.LENGTH_LONG).show();
        setContentView(R.layout.welcome_screen);

    }
    public void wlogin (String r) {
        Toast.makeText(Login.this, r , Toast.LENGTH_LONG).show();
        startActivity(new Intent(Login.this,Forget.class));
    }
}

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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

 public class MainActivity extends AppCompatActivity {

     public static final String KEY_USER = "user";
     public static final String KEY_PASS = "pass";

     EditText uid ,pass ;
     Button log ;
     private static final String URL_COMPLAIN = "http://niranjanlamichhane.com/SmartGovernance/user/login.php";
     private String TAG;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.login);
         uid = findViewById(R.id.uid);
         pass = findViewById( (R.id.pass));
         log = findViewById(R.id.btn_login);
         // setContentView(R.layout.welcome_screen);
     }



     public void login(View v)
     {
         final String password = pass.getText().toString().trim();

         final String user = uid.getText().toString().trim();
         if(user.equals("nlc")&& password.equals("1234"))
         {
             startActivity(new Intent(MainActivity.this,welcome.class));
         }
         else
         {
             log();
         }

     }
         private void log(){
             Toast.makeText(MainActivity.this,"Sending", Toast.LENGTH_SHORT).show();
             Log.v("Error", "Activity created");

             final String password = pass.getText().toString().trim();

             final String user = uid.getText().toString().trim();


             // Request a string response from the provided URL.
             StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_COMPLAIN,
                     new Response.Listener<String>() {
                         @Override
                         public void onResponse(String response) {
                             Toast.makeText(MainActivity.this, "Response: " + response, Toast.LENGTH_LONG).show();
                             //  uid.setText( response.toString());
                             responseAnalyzer(response.trim());
                         }
                     }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     Log.i("Error", error.toString());
//                uid.setText(error.toString());
                     Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();

                 }
             }) {
                 @Override
                 protected Map<String, String> getParams() throws AuthFailureError {
                     Map<String, String> parameters = new HashMap<String, String>();
                     parameters.put(KEY_USER, user);
                     parameters.put(KEY_PASS, password);
                     return parameters;

                 }
             };
             RequestQueue requestQueue = Volley.newRequestQueue(this);

             requestQueue.getCache().clear();
             requestQueue.add(stringRequest);
             //     requestQueue.start();


         }



     public  void responseAnalyzer(String r)
     {

         Toast.makeText(MainActivity.this,"Analyzing response ", Toast.LENGTH_SHORT).show();
        /* switch (r) {
             case "logined":

                 break;
             case " wrongPassword":
                 Toast.makeText(MainActivity.this,"getting password ", Toast.LENGTH_SHORT).show();
                 wlogin(r);
                 break;

             default:
                 Toast.makeText(MainActivity.this,"failed", Toast.LENGTH_SHORT).show();
                 break;
         }*/
         if(r.equals("a")){
             slogin(r);
         }else{
             wlogin(r);
         }


     }
     private void slogin (String r)
     {
         Toast.makeText(MainActivity.this, r , Toast.LENGTH_SHORT).show();
         startActivity(new Intent(MainActivity.this,welcome.class));

     }
     public void wlogin (String r) {
         Toast.makeText(MainActivity.this, r , Toast.LENGTH_SHORT).show();
         startActivity(new Intent(MainActivity.this,Forget.class));
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



    public void gov(View view) {
        startActivity(new Intent(MainActivity.this,Government.class));
    }

}

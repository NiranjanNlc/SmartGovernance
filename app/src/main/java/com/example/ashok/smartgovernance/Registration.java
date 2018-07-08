package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static com.example.ashok.smartgovernance.complains.KEY_name;

public class Registration extends AppCompatActivity {
    private EditText childName;
    private EditText Birthplace;
    private EditText  parentname ;
    private EditText parentid;
    private EditText parentcontact;
    private ImageView photo;
    private Button registerBirth ,reset ;
    public String URl ="http://192.168.1.3/SmartGovernance/birth/registerBirth.php";
// keyvaluepair
public static final String KEY_child="childName";
    public static final String KEY_dob="dob";
    public static final String KEY_BirthPlace="BirthPlace";
    public static final String KEY_pname="parentname";
    public static final String KEY_pid="parentid";
    public static final String KEY_pcontact="parentcontact";

    // image operation ko laggi
    private Bitmap bitmap;
    private final int IMG_REQUEST = 1;
     private EditText childDob ;
    private String KEY_childame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birth);



        childName =(EditText) findViewById(R.id.cname);
         childDob=  findViewById(R.id.cdob);

         Birthplace  = findViewById(R.id.BirthPlace);

          parentname = findViewById(R.id.pname);
          parentcontact = findViewById(R.id.pcontact);
          parentid = findViewById(R.id.pid);
          registerBirth = findViewById(R.id.registerBirth);

          }
    public void registerBirth(View view) {
        final String  cname  = (String) childName.getText().toString().trim();

        final String cdob = (String) childDob.getText().toString().trim();
        final String birthplace = (String) Birthplace.getText().toString().trim();
        final String pname = (String) parentname.getText().toString().trim();
        final String pid = (String) parentid.getText().toString().trim();
        final String pcontact= (String) parentcontact.getText().toString().trim();


        /// response listemer
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       approve (pname,cname,cdob,response,pcontact);
                   Toast.makeText(Registration.this, response, Toast.LENGTH_LONG).show();
                   startActivity(new Intent(Registration.this,Registration.class));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                childName.setText(error.toString());
                Toast.makeText(Registration.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(KEY_child,cname);
                parameters.put(KEY_dob,cdob);
                parameters.put(KEY_pname,pname);
                parameters.put(KEY_BirthPlace,birthplace);
                parameters.put(KEY_pcontact,pcontact);
                parameters.put(KEY_pid,pid);
                return parameters;
            }
           /* @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> param = new HashMap<String, String>();

                return param;
            }
          @Override
            public String getBodyContentType() {
                return "application/json";
            }*/
        };
    /*    stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)); */
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void approve (String p,String c,String d,String r,String con )
    {
        String body ="Dear"+p+",your child "+c +"born on "+d + ",birthid is :"+r;
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(con, null, body , null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            System.out.print(e);
            Toast.makeText(getApplicationContext(),
                    "Registration  faild, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

}

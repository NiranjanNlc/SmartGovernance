package com.example.ashok.smartgovernance;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

public class RComplain extends AppCompatActivity {

    private TextView rloc,rid;
    private TextView rcomp,contact;
    private TextView rtop;

    Bitmap bm ;
   EditText reply;
     Button adress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replycomplain);
        rcomp=findViewById(R.id.rgriv);
        adress =findViewById(R.id.reply);
        reply = (EditText) findViewById(R.id.rrep);
        rtop = findViewById(R.id.rtop);
        rloc=findViewById(R.id.rloc);
        contact = findViewById(R.id.contact);
        rid= findViewById(R.id.rid);
           // setting req   uired
        Bundle extras = getIntent().getExtras();
        rtop.setText("TOPIC:"+ extras.getString("topic"));
        rloc.setText("Location:"+ extras.getString("location"));
        rcomp.setText("Complain :"+extras.getString("griv"));
        contact.setText(extras.getString("contact"));
        // image ko laggi



    }
    public void Adress(View v)
    {
        final String rep = (String) reply.getText().toString().trim();
        final String id = (String) rid.getText().toString().trim();
         final String c = (String) contact.getText().toString().trim();
        // sending reply imnto dATABASES

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.3/SmartGovernance/complain/reply.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText( RComplain.this, response, Toast.LENGTH_LONG).show();
                        sendSms (c , id,  rep );
                        startActivity(new Intent(RComplain.this, Government.class));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RComplain.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("rid",id);
                parameters.put("reply",rep);

                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }
    public void sendSms (String s ,String id ,  String sms )
    {
         String body = "YOUR complain ID: " + id + ":\n" + sms ;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(s, null, body , null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            System.out.print(e);
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}

package com.example.ashok.smartgovernance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Feedback extends AppCompatActivity   {
    Button bs,p1,p2,p3,p4,p5;
    EditText eSMS;
    ExpandableRelativeLayout f1,f2 ;
    Spinner spinner;
       ArrayAdapter<CharSequence> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
      //  bs=(Button) findViewById(R.id.bS);
      //  spinner =(Spinner) findViewById(R.id.spin);
        eSMS = (EditText) findViewById(R.id.eSMS);
 // adapter = ArrayAdapter.createFromResource(this,R.array.project,android.R.layout.simple_spinner_item);
// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// spinner.setAdapter(adapter);

        }


                public void send(View v) {
                    final String sms = eSMS.getText().toString();
                    String s =  spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                    switch (s)
                    {
                        case "taxRates":
                             s = "9809282747";
                            break;




                    }
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(s, null, sms, null, null);
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



    public void Not1(View view) {
        f1 = (ExpandableRelativeLayout) findViewById(R.id.noti1);
        f1.toggle(); // toggle expand and collapse

    }
    public void feedback(View view) {
        setContentView(R.layout.activity_feedback);
    }
    public void email(View view) {


    }


}

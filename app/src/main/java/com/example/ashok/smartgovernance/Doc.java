package com.example.ashok.smartgovernance;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Doc extends AppCompatActivity   {
    DownloadManager d;
    private Spinner spinner;
    private static final String[] paths = new String[]{"Budget", "Fiscal yaear planning", "Annual expenditure","Subsidee for farmer"};


    TextView t1;
    Button a1, a2, a3, a4, a5, a6,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rti);
          // sp0innerr ko laggi
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Doc.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
      button = findViewById(R.id.but);
     // button.setOnClickListener(this);







         // paila ko codes
      /*  a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);
        a4 = (Button) findViewById(R.id.a4);
        a5 = (Button) findViewById(R.id.a5);
        a6 = (Button) findViewById(R.id.a6);
        a1 = (Button) findViewById(R.id.a1);

        a1.setOnClickListener(this);
        a6.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        a5.setOnClickListener(this);*/
    }

    public void select(View v) {
         final  String s   ;

        s = spinner.getSelectedItem().toString();

        switch (s) {
            case "Budget":
                download ("http://niranjanlamichhane.com/SmartGovernance/doc/budget.pdf");
                       break;
            case "Fiscal yaear planning":
                download ("http://niranjanlamichhane.com/SmartGovernance/doc/planning.pdf");
                break;
            case "Annual expenditure":
                download ("http://niranjanlamichhane.com/SmartGovernance/doc/kharcha.pdf");
                break;

            case "Subsidee for farmer":

                download ("http://niranjanlamichhane.com/SmartGovernance/doc/subsidues.pdf");
                break;

            default:
                 ;
                break;
        }







    }


    private void download(String p)
    {
        d = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(p);
        DownloadManager.Request req = new DownloadManager.Request(uri);
        req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        req.setDescription("Downloading ");
        long re =  d.enqueue(req);
    }
}




package com.example.ashok.smartgovernance;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Doc extends AppCompatActivity implements View.OnClickListener {
    DownloadManager d;
    TextView t1;
    Button a1, a2, a3, a4, a5, a6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        a2 = (Button) findViewById(R.id.a2);
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
        a5.setOnClickListener(this);
    }

    public void onClick(View v) {
         final  String s ;
        switch (v.getId()) {
            case R.id.a1:
                download(  "http://192.168.2.106/budget.pdf");
                break;
            case R.id.a2:
                download(s = "http://192.168.2.106/planning.pdf");
                break;
            case R.id.a3:
                download( s = "http://192.168.2.106/ kharcha.pdf");
                break;
            case R.id.a4:
                download( s = "http://192.168.2.106/subsidues.pdf");
                break;
            case R.id.a5:
                download( s = "http://192.168.2.106/ec.pdf");
                break;
            case R.id.a6:
                download( s = "http://192.168.2.106/tender.pdf");
                break ;

        }

    }
    private void download(String s)
    {
        d = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(s);
        DownloadManager.Request req = new DownloadManager.Request(uri);
        req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long re = d.enqueue(req);
    }
}




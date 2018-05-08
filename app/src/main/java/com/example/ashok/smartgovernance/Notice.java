package com.example.ashok.smartgovernance;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.widget.Button;
import android.widget.TextView;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Notice extends AppCompatActivity {

    ExpandableRelativeLayout noti1,noti2,noti3,noti4,noti5 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
    }

    public void Not1(View view) {
        noti1 = (ExpandableRelativeLayout) findViewById(R.id.noti1);
        noti1.toggle(); // toggle expand and collapse

    }
    public void Not2(View view) {
        noti2 = (ExpandableRelativeLayout) findViewById(R.id.noti2);
        noti2.toggle(); // toggle expand and collapse

    }
    public void Not3(View view) {
        noti3 = (ExpandableRelativeLayout) findViewById(R.id.noti3);
        noti3.toggle(); // toggle expand and collapse

    }
    public void Not4(View view) {
        noti4 = (ExpandableRelativeLayout) findViewById(R.id.noti4);
        noti4.toggle(); // toggle expand and collapse

    }
    public void Not5(View view) {
        noti5 = (ExpandableRelativeLayout) findViewById(R.id.noti5);
        noti5.toggle(); // toggle expand and collapse

    }

}


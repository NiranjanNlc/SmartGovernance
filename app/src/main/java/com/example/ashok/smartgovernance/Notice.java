package com.example.ashok.smartgovernance;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Notice extends AppCompatActivity {

    ExpandableRelativeLayout noti1,noti2,noti3,noti4,noti5 ;
    private static final String URL_COMPLAIN = "http://niranjanlamichhane.com/SmartGovernance/notification/getnoti.php";
    //a list to store all the products
    List<modelNotice> listitem  ;

    //the recyclerview
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //   setContentView(R.layout.activity_notice);
        setContentView(R.layout.notice);

        // recycle vierw
        recyclerView = findViewById(R.id.noticeRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // inirtalize lists
        listitem = new ArrayList<>();
        loadnotice();


    }



                    ///       Individual notification
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

                    // recycler view bata notice lyauna

                public void loadnotice()
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_COMPLAIN,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.i("Response", response);
                                    try {
                                        //converting the string to json array object
                                        JSONArray array = new JSONArray(response);

                                        //traversing through all the object
                                        for (int i = 0; i < array.length(); i++) {

                                            //getting product object from json array
                                            JSONObject notice  = array.getJSONObject(i);

                                            //adding the product to product list
                                             listitem.add(new modelNotice(
                                                     notice.getString("image"),
                                            notice.getString("title"),
                                            notice.getString("notice")
                                            ));


                                        }

                                        //creating adapter object and setting it to recyclerview

                                        NoticeAdapter adapter = new NoticeAdapter( listitem,Notice.this);
                                        recyclerView.setAdapter(adapter);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            });
                    //adding our stringrequest to queue
                    Volley.newRequestQueue(this).add(stringRequest);
                }
                }
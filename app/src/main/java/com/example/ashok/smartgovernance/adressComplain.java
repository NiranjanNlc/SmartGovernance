package com.example.ashok.smartgovernance;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public  class adressComplain extends AppCompatActivity   {

    private static final String URL_COMPLAIN = "http://niranjanlamichhane.com/SmartGovernance/includes/Complains.php";
    //a list to store all the products
    List<ComplainModel> listitem  ;

    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_complain);

        // recycle vierw
        recyclerView = findViewById(R.id.complainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // inirtalize lists
        listitem = new ArrayList<>();
        loadcomplain();
    }
    private void loadcomplain()
    {
        final  ProgressDialog p = new ProgressDialog(this);
        p.setMessage("LOADING data .....");
        p.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_COMPLAIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        p.dismiss();
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject complain  = array.getJSONObject(i);

                                //adding the product to product list
                                listitem.add(new ComplainModel(
                                        complain.getString("Image"),
                                        complain.getString("topic"),
                                        complain.getString("location"),
                                        complain.getString("complainMsg"),
                                        complain.getString("name"),
                                        complain.getString("email"),
                                        complain.getString("cid")



                                ));
                            }

                            //creating adapter object and setting it to recyclerview

                            ComplainAdapter adapter = new ComplainAdapter(listitem,adressComplain.this);
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

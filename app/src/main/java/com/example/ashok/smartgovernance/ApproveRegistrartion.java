package com.example.ashok.smartgovernance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ApproveRegistrartion extends AppCompatActivity {

    private static final String URL_COMPLAIN = "http://192.168.2.108/SmartGovernance/includes/Complain.php";
    //a list to store all the products
    List<ComplainModel> listitem  ;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_registrartion);
    }
}

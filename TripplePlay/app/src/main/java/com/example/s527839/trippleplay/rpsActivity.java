package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class rpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
    }
    //Goes back to Start Screen on click
    public void onClickSB(View v){
        Intent ini = new Intent(v.getContext(), scoreActivity.class);
        startActivityForResult(ini, 1);
    }
}

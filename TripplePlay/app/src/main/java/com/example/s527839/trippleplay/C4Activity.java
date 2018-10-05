package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class C4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4);
    }

    public void onClickrps(View v){
        Intent ini = new Intent(v.getContext(), rpsActivity.class);
        startActivityForResult(ini, 1);
    }
}

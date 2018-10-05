package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class scoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }

    public void onClickSS(View v){
        Intent ini = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(ini, 1);
    }
}

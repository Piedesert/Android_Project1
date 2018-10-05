package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HangmanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
    }
    //goes to connect 4 activity
    public void onClickC4(View v){
        Intent ini = new Intent(v.getContext(), C4Activity.class);
        startActivityForResult(ini, 1);
    }
}

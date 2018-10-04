package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button playBTN;
    Button htpBTN;
    private static final int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBTN = (Button) findViewById(R.id.playBTN);
        htpBTN = (Button) findViewById(R.id.htpBTN);

        // Start play with HangmanActivity
        playBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(MainActivity.this, HangmanActivity.class);
                Toast.makeText(MainActivity.this, "Time to Tripple Play!", Toast.LENGTH_SHORT).show();
                startActivityForResult(ini, request_code);
            }
        });

        // Start htpActivity
        playBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(MainActivity.this, htpActivity.class);
                startActivityForResult(ini, request_code);
            }
        });
    }
}

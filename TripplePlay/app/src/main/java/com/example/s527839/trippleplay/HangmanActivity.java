package com.example.s527839.trippleplay;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HangmanActivity extends AppCompatActivity {

    Button nextBTN;
    Button htpBTN;
    private static final int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        nextBTN = (Button) findViewById(R.id.nextBTN);
        htpBTN = (Button) findViewById(R.id.htpBTN);

        // Start next game C4Activity
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(HangmanActivity.this, C4Activity.class);
                Toast.makeText(HangmanActivity.this, "Connect Four", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });

        // Start htpActivity (How To Play)
        htpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(HangmanActivity.this, htpActivity.class);
                Toast.makeText(HangmanActivity.this, "How To Play", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });
    }
}

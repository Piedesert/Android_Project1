package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.s527839.trippleplay.R;
import com.example.s527839.trippleplay.MainActivity;

public class htpActivity extends AppCompatActivity {
// How To Play

    Button homeBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htp);

        homeBTN = (Button) findViewById(R.id.homeBTN);

        // Start MainActivity
        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(htpActivity.this, MainActivity.class);
                Toast.makeText(htpActivity.this, "Home", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });
    }
}

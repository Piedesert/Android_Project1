package com.example.s527839.trippleplay;

<<<<<<< HEAD
import android.app.Activity;
=======
>>>>>>> 84ed63774e0f80d6006b96d0d38154e88ddb62f6
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.Toast;
=======
>>>>>>> 84ed63774e0f80d6006b96d0d38154e88ddb62f6

public class rpsActivity extends AppCompatActivity {
// Rock, Paper, Scissors

    Button htpBTN;
    Button homeBTN;
    private static final int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        htpBTN = (Button) findViewById(R.id.htpBTN);
        homeBTN = (Button) findViewById(R.id.homeBTN);

        // Start MainActivity
        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(rpsActivity.this, MainActivity.class);
                Toast.makeText(rpsActivity.this, "Home", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });

        // Start htpActivity (How To Play)
        htpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(rpsActivity.this, htpActivity.class);
                Toast.makeText(rpsActivity.this, "How To Play", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });
    }
    //Goes back to Start Screen on click
    public void onClickSB(View v){
        Intent ini = new Intent(v.getContext(), scoreActivity.class);
        startActivityForResult(ini, 1);
    }
}

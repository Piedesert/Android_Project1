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
    //goes to connect 4 activity
    public void onClickC4(View v){
        Intent ini = new Intent(v.getContext(), C4Activity.class);
        startActivityForResult(ini, 1);
    }
}

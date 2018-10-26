package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.s527839.trippleplay.R;
import com.example.s527839.trippleplay.htpActivity;
import com.example.s527839.trippleplay.rpsActivity;

public class C4Activity extends AppCompatActivity implements View.OnClickListener {
// Connect Four
    Button nextBTN;
    Button htpBTN;
    private static final int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4);

        nextBTN = (Button) findViewById(R.id.nextBTN);
        htpBTN = (Button) findViewById(R.id.htpBTN);
        Button reset = findViewById(R.id.resetBTN);
        ImageButton row1col1 = findViewById(R.id.row1col1);
        ImageButton row1col2 = findViewById(R.id.row1col2);
        ImageButton row1col3 = findViewById(R.id.row1col3);
        ImageButton row1col4 = findViewById(R.id.row1col4);
        ImageButton row1col5 = findViewById(R.id.row1col5);
        ImageButton row2col1 = findViewById(R.id.row2col1);
        ImageButton row2col2 = findViewById(R.id.row2col2);
        ImageButton row2col3 = findViewById(R.id.row2col3);
        ImageButton row2col4 = findViewById(R.id.row2col4);
        ImageButton row2col5 = findViewById(R.id.row2col5);
        ImageButton row3col1 = findViewById(R.id.row3col1);
        ImageButton row3col2 = findViewById(R.id.row3col2);
        ImageButton row3col3 = findViewById(R.id.row3col3);
        ImageButton row3col4 = findViewById(R.id.row3col4);
        ImageButton row3col5 = findViewById(R.id.row3col5);
        ImageButton row4col1 = findViewById(R.id.row4col1);
        ImageButton row4col2 = findViewById(R.id.row4col2);
        ImageButton row4col3 = findViewById(R.id.row4col3);
        ImageButton row4col4 = findViewById(R.id.row4col4);
        ImageButton row4col5 = findViewById(R.id.row4col5);
        ImageButton row5col1 = findViewById(R.id.row5col1);
        ImageButton row5col2 = findViewById(R.id.row5col2);
        ImageButton row5col3 = findViewById(R.id.row5col3);
        ImageButton row5col4 = findViewById(R.id.row5col4);
        ImageButton row5col5 = findViewById(R.id.row5col5);

        row1col1.setOnClickListener(this);
        row1col2.setOnClickListener(this);
        row1col3.setOnClickListener(this);
        row1col4.setOnClickListener(this);
        row1col5.setOnClickListener(this);
        row2col1.setOnClickListener(this);
        row2col2.setOnClickListener(this);
        row2col3.setOnClickListener(this);
        row2col4.setOnClickListener(this);
        row2col5.setOnClickListener(this);
        row3col1.setOnClickListener(this);
        row3col2.setOnClickListener(this);
        row3col3.setOnClickListener(this);
        row3col4.setOnClickListener(this);
        row3col5.setOnClickListener(this);
        row4col1.setOnClickListener(this);
        row4col2.setOnClickListener(this);
        row4col3.setOnClickListener(this);
        row4col4.setOnClickListener(this);
        row4col5.setOnClickListener(this);
        row5col1.setOnClickListener(this);
        row5col2.setOnClickListener(this);
        row5col3.setOnClickListener(this);
        row5col4.setOnClickListener(this);
        row5col5.setOnClickListener(this);
        reset.setOnClickListener(this);


        // Start next game rpsActivity
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(C4Activity.this, rpsActivity.class);
                Toast.makeText(C4Activity.this, "Rock, Paper, Scissors", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });

        // Start htpActivity (How To Play)
        htpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(C4Activity.this, htpActivity.class);
                Toast.makeText(C4Activity.this, "How To Play", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });
    }

    @Override
    public void onClick(View v) {
        ImageButton row1col1 = findViewById(R.id.row1col1);
        ImageButton row1col2 = findViewById(R.id.row1col2);
        ImageButton row1col3 = findViewById(R.id.row1col3);
        ImageButton row1col4 = findViewById(R.id.row1col4);
        ImageButton row1col5 = findViewById(R.id.row1col5);
        ImageButton row2col1 = findViewById(R.id.row2col1);
        ImageButton row2col2 = findViewById(R.id.row2col2);
        ImageButton row2col3 = findViewById(R.id.row2col3);
        ImageButton row2col4 = findViewById(R.id.row2col4);
        ImageButton row2col5 = findViewById(R.id.row2col5);
        ImageButton row3col1 = findViewById(R.id.row3col1);
        ImageButton row3col2 = findViewById(R.id.row3col2);
        ImageButton row3col3 = findViewById(R.id.row3col3);
        ImageButton row3col4 = findViewById(R.id.row3col4);
        ImageButton row3col5 = findViewById(R.id.row3col5);
        ImageButton row4col1 = findViewById(R.id.row4col1);
        ImageButton row4col2 = findViewById(R.id.row4col2);
        ImageButton row4col3 = findViewById(R.id.row4col3);
        ImageButton row4col4 = findViewById(R.id.row4col4);
        ImageButton row4col5 = findViewById(R.id.row4col5);
        ImageButton row5col1 = findViewById(R.id.row5col1);
        ImageButton row5col2 = findViewById(R.id.row5col2);
        ImageButton row5col3 = findViewById(R.id.row5col3);
        ImageButton row5col4 = findViewById(R.id.row5col4);
        ImageButton row5col5 = findViewById(R.id.row5col5);
        Button reset = findViewById(R.id.resetBTN);
        switch (v.getId()) {
            case R.id.row1col1:
                //call function here
                break;
            case R.id.row1col2:
                //call function here
                break;
            case R.id.row1col3:
                //call function here
                break;
            case R.id.row1col4:
                //call function here
                break;
            case R.id.row1col5:
                //call function here
                break;
            case R.id.row2col1:
                //call function here
                break;
            case R.id.row2col2:
                //call function here
                break;
            case R.id.row2col3:
                //call function here
                break;
            case R.id.row2col4:
                //call function here
                break;
            case R.id.row2col5:
                //call function here
                break;
            case R.id.row3col1:
                //call function here
                break;
            case R.id.row3col2:
                //call function here
                break;
            case R.id.row3col3:
                //call function here
                break;
            case R.id.row3col4:
                //call function here
                break;
            case R.id.row3col5:
                //call function here
                break;
            case R.id.row4col1:
                //call function here
                break;
            case R.id.row4col2:
                //call function here
                break;
            case R.id.row4col3:
                //call function here
                break;
            case R.id.row4col4:
                //call function here
                break;
            case R.id.row4col5:
                //call function here
                break;
            case R.id.row5col1:
                //call function here
                break;
            case R.id.row5col2:
                //call function here
                break;
            case R.id.row5col3:
                //call function here
                break;
            case R.id.row5col4:
                //call function here
                break;
            case R.id.row5col5:
                //call function here
                break;
            case R.id.resetBTN:
                //call function here
                break;


        }

    }
    public void imagePicker(int userCount)
    {

    }

    public void reset(){

    }
}

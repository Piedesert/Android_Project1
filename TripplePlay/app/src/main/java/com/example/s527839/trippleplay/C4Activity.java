package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class C4Activity extends AppCompatActivity implements View.OnClickListener {
    // Connect Four
    Button nextBTN;
    Button htpBTN;
    String result;
    String player;
    String winningPlayer;
    private static final int request_code = 1;
    int user = 2;
    Button reset;
    ArrayList<String> arrayRed = new ArrayList<>(25);
    ArrayList<String> arrayBlue = new ArrayList<>(25);
    ImageButton row1col1, row1col2, row1col3, row1col4, row1col5,
            row2col1, row2col2, row2col3, row2col4, row2col5,
            row3col1, row3col2, row3col3, row3col4, row3col5,
            row4col1, row4col2, row4col3, row4col4, row4col5,
            row5col1, row5col2, row5col3, row5col4, row5col5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4);

        nextBTN = (Button) findViewById(R.id.nextBTN);
        htpBTN = (Button) findViewById(R.id.htpBTN);
        reset = findViewById(R.id.resetBTN);
        row1col1 = findViewById(R.id.row1col1);
        row1col2 = findViewById(R.id.row1col2);
        row1col3 = findViewById(R.id.row1col3);
        row1col4 = findViewById(R.id.row1col4);
        row1col5 = findViewById(R.id.row1col5);
        row2col1 = findViewById(R.id.row2col1);
        row2col2 = findViewById(R.id.row2col2);
        row2col3 = findViewById(R.id.row2col3);
        row2col4 = findViewById(R.id.row2col4);
        row2col5 = findViewById(R.id.row2col5);
        row3col1 = findViewById(R.id.row3col1);
        row3col2 = findViewById(R.id.row3col2);
        row3col3 = findViewById(R.id.row3col3);
        row3col4 = findViewById(R.id.row3col4);
        row3col5 = findViewById(R.id.row3col5);
        row4col1 = findViewById(R.id.row4col1);
        row4col2 = findViewById(R.id.row4col2);
        row4col3 = findViewById(R.id.row4col3);
        row4col4 = findViewById(R.id.row4col4);
        row4col5 = findViewById(R.id.row4col5);
        row5col1 = findViewById(R.id.row5col1);
        row5col2 = findViewById(R.id.row5col2);
        row5col3 = findViewById(R.id.row5col3);
        row5col4 = findViewById(R.id.row5col4);
        row5col5 = findViewById(R.id.row5col5);

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
                Intent scoreSend = new Intent(C4Activity.this, ScoreActivity.class);
                scoreSend.putExtra("c4Result", result);
                setResult(2, scoreSend);
                finish();
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
        switch (v.getId()) {
            case R.id.row1col1:
                if (user % 2 == 0) {
                    arrayRed.add("row1col1");
                    redImage(row1col1, R.id.row1col1);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row1col1");
                    blueImage(row1col1, R.id.row1col1);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row1col2:

                if (user % 2 == 0) {
                    arrayRed.add("row1col2");
                   redImage(row1col2, R.id.row1col2);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row1col2");
                    blueImage(row1col2, R.id.row1col2);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row1col3:

                if (user % 2 == 0) {
                    arrayRed.add("row1col3");
                    redImage(row1col3, R.id.row1col3);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row1col3");
                    blueImage(row1col3, R.id.row1col3);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row1col4:

                if (user % 2 == 0) {
                    arrayRed.add("row1col4");
                    redImage(row1col4, R.id.row1col4);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row1col4");
                    blueImage(row1col4, R.id.row1col4);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row1col5:

                if (user % 2 == 0) {
                    arrayRed.add("row1col5");
                    redImage(row1col5, R.id.row1col5);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row1col5");
                    blueImage(row1col5, R.id.row1col5);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row2col1:

                if (user % 2 == 0) {
                    arrayRed.add("row2col1");
                    redImage(row2col1, R.id.row2col1);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row2col1");
                    blueImage(row2col1, R.id.row2col1);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row2col2:

                if (user % 2 == 0) {
                    arrayRed.add("row2col2");
                    redImage(row2col2, R.id.row2col2);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row2col2");
                    blueImage(row2col2, R.id.row2col2);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row2col3:

                if (user % 2 == 0) {
                    arrayRed.add("row2col3");
                    redImage(row2col3, R.id.row2col3);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row2col3");
                    blueImage(row2col3, R.id.row2col3);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row2col4:

                if (user % 2 == 0) {
                    arrayRed.add("row2col4");
                    redImage(row2col4, R.id.row2col4);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row2col4");
                    blueImage(row2col4, R.id.row2col4);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row2col5:

                if (user % 2 == 0) {
                    arrayRed.add("row2col5");
                    redImage(row2col5, R.id.row2col5);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row2col5");
                    blueImage(row2col5, R.id.row2col5);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row3col1:

                if (user % 2 == 0) {
                    arrayRed.add("row3col1");
                    redImage(row3col1, R.id.row3col1);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row3col1");
                    blueImage(row3col1, R.id.row3col1);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row3col2:

                if (user % 2 == 0) {
                    arrayRed.add("row3col2");
                    redImage(row3col2, R.id.row3col2);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row3col2");
                    blueImage(row3col2, R.id.row3col2);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row3col3:

                if (user % 2 == 0) {
                    arrayRed.add("row3col3");
                    redImage(row3col3, R.id.row3col3);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row3col3");
                    blueImage(row3col3, R.id.row3col3);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row3col4:

                if (user % 2 == 0) {
                    arrayRed.add("row3col4");
                    redImage(row3col4, R.id.row3col4);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row3col4");
                    blueImage(row3col4, R.id.row3col4);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row3col5:

                if (user % 2 == 0) {
                    arrayRed.add("row3col5");
                    redImage(row3col5, R.id.row3col5);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row3col5");
                    blueImage(row3col5, R.id.row3col5);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row4col1:

                if (user % 2 == 0) {
                    arrayRed.add("row4col1");
                    redImage(row4col1, R.id.row4col1);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row4col1");
                    blueImage(row4col1, R.id.row4col1);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row4col2:

                if (user % 2 == 0) {
                    arrayRed.add("row4col2");
                    redImage(row4col2, R.id.row4col2);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row4col2");
                    blueImage(row4col2, R.id.row4col2);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row4col3:

                if (user % 2 == 0) {
                    arrayRed.add("row4col3");
                    redImage(row4col3, R.id.row4col3);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row4col3");
                    blueImage(row4col3, R.id.row4col3);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row4col4:

                if (user % 2 == 0) {
                    arrayRed.add("row4col4");
                    redImage(row4col4, R.id.row4col4);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row4col4");
                    blueImage(row4col4, R.id.row4col4);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row4col5:

                if (user % 2 == 0) {
                    arrayRed.add("row4col5");
                    redImage(row4col5, R.id.row4col5);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row4col5");
                    blueImage(row4col5, R.id.row4col5);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row5col1:

                if (user % 2 == 0) {
                    arrayRed.add("row5col1");
                    redImage(row5col1, R.id.row5col1);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row5col1");
                    blueImage(row5col1, R.id.row5col1);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row5col2:

                if (user % 2 == 0) {
                    arrayRed.add("row5col2");
                    redImage(row5col2, R.id.row5col2);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row5col2");
                    blueImage(row5col2, R.id.row5col2);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row5col3:

                if (user % 2 == 0) {
                    arrayRed.add("row5col3");
                    redImage(row5col3, R.id.row5col3);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row5col3");
                    blueImage(row5col3, R.id.row5col3);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row5col4:

                if (user % 2 == 0) {
                    arrayRed.add("row5col4");
                    redImage(row5col4, R.id.row5col4);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row5col4");
                    blueImage(row5col4, R.id.row5col4);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.row5col5:

                if (user % 2 == 0) {
                    arrayRed.add("row5col5");
                    redImage(row5col5, R.id.row5col5);
                    winCondition(arrayRed, arrayBlue);
                } else {
                    arrayBlue.add("row5col5");
                    blueImage(row5col5,R.id.row5col5);
                    winCondition(arrayRed, arrayBlue);
                }
                user++;
                break;
            case R.id.resetBTN:
                arrayRed.clear();
                arrayBlue.clear();
                reset();
                break;


        }

    }

    public void redImage(ImageButton player1, int a) {
        TextView message = findViewById(R.id.message);
        player1 = findViewById(a);
        player1.setImageResource(R.drawable.redchecker);
        player1.setEnabled(false);
        message.setText("Player Two's Turn");
    }

    public void blueImage(ImageButton player2, int b) {
        TextView message = findViewById(R.id.message);
        player2 = findViewById(b);
        player2.setImageResource(R.drawable.bluesquare2);
        player2.setEnabled(false);
        message.setText("Player One's Turn");
    }

    public void winCondition(ArrayList<String> red, ArrayList<String> blue){
        if((red.contains("row1col1") && red.contains("row1col2") && red.contains("row1col3") && red.contains("row1col4"))||
                (red.contains("row1col2") && red.contains("row1col3") && red.contains("row1col4") && red.contains("row1col5")) ||
                (red.contains("row2col1") && red.contains("row2col2") && red.contains("row2col3") && red.contains("row2col4")) ||
                (red.contains("row2col2") && red.contains("row2col3") && red.contains("row2col4") && red.contains("row2col5")) ||
                (red.contains("row3col1") && red.contains("row3col2") && red.contains("row3col3") && red.contains("row3col4")) ||
                (red.contains("row3col2") && red.contains("row3col3") && red.contains("row3col4") && red.contains("row3col5")) ||
                (red.contains("row4col1") && red.contains("row4col2") && red.contains("row4col3") && red.contains("row4col4")) ||
                (red.contains("row4col2") && red.contains("row4col3") && red.contains("row4col4") && red.contains("row4col5")) ||
                (red.contains("row5col1") && red.contains("row5col2") && red.contains("row5col3") && red.contains("row5col4")) ||
                (red.contains("row5col2") && red.contains("row5col3") && red.contains("row5col4") && red.contains("row5col5")) ||
                (red.contains("row1col1") && red.contains("row2col1") && red.contains("row3col1") && red.contains("row4col1")) ||
                (red.contains("row2col1") && red.contains("row3col1") && red.contains("row4col1") && red.contains("row5col1")) ||
                (red.contains("row1col2") && red.contains("row2col2") && red.contains("row3col2") && red.contains("row4col2")) ||
                (red.contains("row2col2") && red.contains("row3col2") && red.contains("row4col2") && red.contains("row5col2")) ||
                (red.contains("row1col3") && red.contains("row2col3") && red.contains("row3col3") && red.contains("row4col3")) ||
                (red.contains("row2col3") && red.contains("row3col3") && red.contains("row4col3") && red.contains("row5col3")) ||
                (red.contains("row1col4") && red.contains("row2col4") && red.contains("row3col4") && red.contains("row4col4")) ||
                (red.contains("row2col4") && red.contains("row3col4") && red.contains("row4col4") && red.contains("row5col4")) ||
                (red.contains("row1col5") && red.contains("row2col5") && red.contains("row3col5") && red.contains("row4col5")) ||
                (red.contains("row2col5") && red.contains("row3col5") && red.contains("row4col5") && red.contains("row5col5")) ||
                (red.contains("row2col1") && red.contains("row3col2") && red.contains("row4col3") && red.contains("row5col4")) ||
                (red.contains("row1col2") && red.contains("row2col3") && red.contains("row3col4") && red.contains("row4col5")) ||
                (red.contains("row4col1") && red.contains("row3col2") && red.contains("row2col3") && red.contains("row1col4")) ||
                (red.contains("row5col2") && red.contains("row4col3") && red.contains("row3col4") && red.contains("row2col5")) ||
                (red.contains("row5col1") && red.contains("row4col2") && red.contains("row3col3") && red.contains("row2col4")) ||
                (red.contains("row4col2") && red.contains("row3col3") && red.contains("row2col4") && red.contains("row1col5")) ||
                (red.contains("row1col1") && red.contains("row2col2") && red.contains("row3col3") && red.contains("row4col4")) ||
                (red.contains("row2col2") && red.contains("row3col3") && red.contains("row4col4") && red.contains("row5col5")))
        {
            if((red.contains("row1col1") && red.contains("row1col2") && red.contains("row1col3") && red.contains("row1col4"))){
                row1col1.setImageResource(R.drawable.orangesquare);
                row1col2.setImageResource(R.drawable.orangesquare);
                row1col3.setImageResource(R.drawable.orangesquare);
                row1col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col1") && red.contains("row2col2") && red.contains("row2col3") && red.contains("row2col4")){
                row2col1.setImageResource(R.drawable.orangesquare);
                row2col2.setImageResource(R.drawable.orangesquare);
                row2col3.setImageResource(R.drawable.orangesquare);
                row2col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col2") && red.contains("row2col3") && red.contains("row2col4") && red.contains("row2col5")){
                row2col2.setImageResource(R.drawable.orangesquare);
                row2col3.setImageResource(R.drawable.orangesquare);
                row2col4.setImageResource(R.drawable.orangesquare);
                row2col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row3col1") && red.contains("row3col2") && red.contains("row3col3") && red.contains("row3col4")){
                row3col1.setImageResource(R.drawable.orangesquare);
                row3col2.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row3col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row3col2") && red.contains("row3col3") && red.contains("row3col4") && red.contains("row3col5")){
                row3col2.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row3col4.setImageResource(R.drawable.orangesquare);
                row3col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row4col1") && red.contains("row4col2") && red.contains("row4col3") && red.contains("row4col4")){
                row4col1.setImageResource(R.drawable.orangesquare);
                row4col2.setImageResource(R.drawable.orangesquare);
                row4col3.setImageResource(R.drawable.orangesquare);
                row4col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row4col2") && red.contains("row4col3") && red.contains("row4col4") && red.contains("row4col5")){
                row4col2.setImageResource(R.drawable.orangesquare);
                row4col3.setImageResource(R.drawable.orangesquare);
                row4col4.setImageResource(R.drawable.orangesquare);
                row4col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row5col1") && red.contains("row5col2") && red.contains("row5col3") && red.contains("row5col4")){
                row5col1.setImageResource(R.drawable.orangesquare);
                row5col2.setImageResource(R.drawable.orangesquare);
                row5col3.setImageResource(R.drawable.orangesquare);
                row5col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row5col2") && red.contains("row5col3") && red.contains("row5col4") && red.contains("row5col5")){
                row5col2.setImageResource(R.drawable.orangesquare);
                row5col3.setImageResource(R.drawable.orangesquare);
                row5col4.setImageResource(R.drawable.orangesquare);
                row5col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row1col1") && red.contains("row2col1") && red.contains("row3col1") && red.contains("row4col1")){
                row1col1.setImageResource(R.drawable.orangesquare);
                row2col1.setImageResource(R.drawable.orangesquare);
                row3col1.setImageResource(R.drawable.orangesquare);
                row4col1.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col1") && red.contains("row3col1") && red.contains("row4col1") && red.contains("row5col1")){
                row2col1.setImageResource(R.drawable.orangesquare);
                row3col1.setImageResource(R.drawable.orangesquare);
                row4col1.setImageResource(R.drawable.orangesquare);
                row5col1.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row1col2") && red.contains("row2col2") && red.contains("row3col2") && red.contains("row4col2")){
                row1col2.setImageResource(R.drawable.orangesquare);
                row2col2.setImageResource(R.drawable.orangesquare);
                row3col2.setImageResource(R.drawable.orangesquare);
                row4col2.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col2") && red.contains("row3col2") && red.contains("row4col2") && red.contains("row5col2")){
                row2col2.setImageResource(R.drawable.orangesquare);
                row3col2.setImageResource(R.drawable.orangesquare);
                row4col2.setImageResource(R.drawable.orangesquare);
                row5col2.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row1col3") && red.contains("row2col3") && red.contains("row3col3") && red.contains("row4col3")){
                row1col3.setImageResource(R.drawable.orangesquare);
                row2col3.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row4col3.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col3") && red.contains("row3col3") && red.contains("row4col3") && red.contains("row5col3")){
                row2col3.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row4col3.setImageResource(R.drawable.orangesquare);
                row5col3.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col2") && red.contains("row3col3") && red.contains("row4col4") && red.contains("row5col5")){
                row2col2.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row4col4.setImageResource(R.drawable.orangesquare);
                row5col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row1col4") && red.contains("row2col4") && red.contains("row3col4") && red.contains("row4col4")){
                row1col4.setImageResource(R.drawable.orangesquare);
                row2col4.setImageResource(R.drawable.orangesquare);
                row3col4.setImageResource(R.drawable.orangesquare);
                row4col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col4") && red.contains("row3col4") && red.contains("row4col4") && red.contains("row5col4")){
                row2col4.setImageResource(R.drawable.orangesquare);
                row3col4.setImageResource(R.drawable.orangesquare);
                row4col4.setImageResource(R.drawable.orangesquare);
                row5col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row1col5") && red.contains("row2col5") && red.contains("row3col5") && red.contains("row4col5")){
                row1col5.setImageResource(R.drawable.orangesquare);
                row2col5.setImageResource(R.drawable.orangesquare);
                row3col5.setImageResource(R.drawable.orangesquare);
                row4col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col5") && red.contains("row3col5") && red.contains("row4col5") && red.contains("row5col5")){
                row2col5.setImageResource(R.drawable.orangesquare);
                row3col5.setImageResource(R.drawable.orangesquare);
                row4col5.setImageResource(R.drawable.orangesquare);
                row5col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row2col1") && red.contains("row3col2") && red.contains("row4col3") && red.contains("row5col4")){
                row2col1.setImageResource(R.drawable.orangesquare);
                row3col2.setImageResource(R.drawable.orangesquare);
                row4col3.setImageResource(R.drawable.orangesquare);
                row5col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row1col2") && red.contains("row2col3") && red.contains("row3col4") && red.contains("row4col5")){
                row1col2.setImageResource(R.drawable.orangesquare);
                row2col3.setImageResource(R.drawable.orangesquare);
                row3col4.setImageResource(R.drawable.orangesquare);
                row4col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row4col1") && red.contains("row3col2") && red.contains("row2col3") && red.contains("row1col4")){
                row4col1.setImageResource(R.drawable.orangesquare);
                row3col2.setImageResource(R.drawable.orangesquare);
                row2col3.setImageResource(R.drawable.orangesquare);
                row1col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row5col2") && red.contains("row4col3") && red.contains("row3col4") && red.contains("row2col5")){
                row5col2.setImageResource(R.drawable.orangesquare);
                row4col3.setImageResource(R.drawable.orangesquare);
                row3col4.setImageResource(R.drawable.orangesquare);
                row2col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row5col1") && red.contains("row4col2") && red.contains("row3col3") && red.contains("row2col4")){
                row5col1.setImageResource(R.drawable.orangesquare);
                row4col2.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row2col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row5col1") && red.contains("row4col2") && red.contains("row3col3") && red.contains("row2col4")){
                row5col1.setImageResource(R.drawable.orangesquare);
                row4col2.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row2col4.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row4col2") && red.contains("row3col3") && red.contains("row2col4") && red.contains("row1col5")){
                row4col2.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row2col4.setImageResource(R.drawable.orangesquare);
                row1col5.setImageResource(R.drawable.orangesquare);
            }
            if(red.contains("row1col1") && red.contains("row2col2") && red.contains("row3col3") && red.contains("row4col4")){
                row1col1.setImageResource(R.drawable.orangesquare);
                row2col2.setImageResource(R.drawable.orangesquare);
                row3col3.setImageResource(R.drawable.orangesquare);
                row4col4.setImageResource(R.drawable.orangesquare);
            }
            MainActivity.user1++;
            if(MainActivity.user1 == 3){
                Intent ini = new Intent(C4Activity.this, ScoreActivity.class);
                Toast.makeText(C4Activity.this, "Rock, Paper, Scissors", Toast.LENGTH_SHORT).show();
                Intent scoreSend = new Intent(C4Activity.this, ScoreActivity.class);
                scoreSend.putExtra("c4Result", result);
                setResult(2, scoreSend);
                finish();
                startActivity(ini);
            }
            TextView message = findViewById(R.id.message);
            message.setText("Player one Wins");
            row1col1.setEnabled(false);
            row1col2.setEnabled(false);
            row1col3.setEnabled(false);
            row1col4.setEnabled(false);
            row1col5.setEnabled(false);
            row2col1.setEnabled(false);
            row2col2.setEnabled(false);
            row2col3.setEnabled(false);
            row2col4.setEnabled(false);
            row2col5.setEnabled(false);
            row3col1.setEnabled(false);
            row3col2.setEnabled(false);
            row3col3.setEnabled(false);
            row3col4.setEnabled(false);
            row3col5.setEnabled(false);
            row4col1.setEnabled(false);
            row4col2.setEnabled(false);
            row4col3.setEnabled(false);
            row4col4.setEnabled(false);
            row4col5.setEnabled(false);
            row5col1.setEnabled(false);
            row5col2.setEnabled(false);
            row5col3.setEnabled(false);
            row5col4.setEnabled(false);
            row5col5.setEnabled(false);
        }
        if((blue.contains("row1col1") && blue.contains("row1col2") && blue.contains("row1col3") && blue.contains("row1col4"))||
                (blue.contains("row1col2") && blue.contains("row1col3") && blue.contains("row1col4") && blue.contains("row1col5")) ||
                (blue.contains("row2col1") && blue.contains("row2col2") && blue.contains("row2col3") && blue.contains("row2col4")) ||
                (blue.contains("row2col2") && blue.contains("row2col3") && blue.contains("row2col4") && blue.contains("row2col5")) ||
                (blue.contains("row3col1") && blue.contains("row3col2") && blue.contains("row3col3") && blue.contains("row3col4")) ||
                (blue.contains("row3col2") && blue.contains("row3col3") && blue.contains("row3col4") && blue.contains("row3col5")) ||
                (blue.contains("row4col1") && blue.contains("row4col2") && blue.contains("row4col3") && blue.contains("row4col4")) ||
                (blue.contains("row4col2") && blue.contains("row4col3") && blue.contains("row4col4") && blue.contains("row4col5")) ||
                (blue.contains("row5col1") && blue.contains("row5col2") && blue.contains("row5col3") && blue.contains("row5col4")) ||
                (blue.contains("row5col2") && blue.contains("row5col3") && blue.contains("row5col4") && blue.contains("row5col5")) ||
                (blue.contains("row1col1") && blue.contains("row2col1") && blue.contains("row3col1") && blue.contains("row4col1")) ||
                (blue.contains("row2col1") && blue.contains("row3col1") && blue.contains("row4col1") && blue.contains("row5col1")) ||
                (blue.contains("row1col2") && blue.contains("row2col2") && blue.contains("row3col2") && blue.contains("row4col2")) ||
                (blue.contains("row2col2") && blue.contains("row3col2") && blue.contains("row4col2") && blue.contains("row5col2")) ||
                (blue.contains("row1col3") && blue.contains("row2col3") && blue.contains("row3col3") && blue.contains("row4col3")) ||
                (blue.contains("row2col3") && blue.contains("row3col3") && blue.contains("row4col3") && blue.contains("row5col3")) ||
                (blue.contains("row1col4") && blue.contains("row2col4") && blue.contains("row3col4") && blue.contains("row4col4")) ||
                (blue.contains("row2col4") && blue.contains("row3col4") && blue.contains("row4col4") && blue.contains("row5col4")) ||
                (blue.contains("row1col5") && blue.contains("row2col5") && blue.contains("row3col5") && blue.contains("row4col5")) ||
                (blue.contains("row2col5") && blue.contains("row3col5") && blue.contains("row4col5") && blue.contains("row5col5")) ||
                (blue.contains("row2col1") && blue.contains("row3col2") && blue.contains("row4col3") && blue.contains("row5col4")) ||
                (blue.contains("row1col2") && blue.contains("row2col3") && blue.contains("row3col4") && blue.contains("row4col5")) ||
                (blue.contains("row4col1") && blue.contains("row3col2") && blue.contains("row2col3") && blue.contains("row1col4")) ||
                (blue.contains("row5col2") && blue.contains("row4col3") && blue.contains("row3col4") && blue.contains("row2col5")) ||
                (blue.contains("row5col1") && blue.contains("row4col2") && blue.contains("row3col3") && blue.contains("row2col4")) ||
                (blue.contains("row4col2") && blue.contains("row3col3") && blue.contains("row2col4") && blue.contains("row1col5")) ||
                (blue.contains("row1col1") && blue.contains("row2col2") && blue.contains("row3col3") && blue.contains("row4col4")) ||
                (blue.contains("row2col2") && blue.contains("row3col3") && blue.contains("row4col4") && blue.contains("row5col5"))) {
            if ((blue.contains("row1col1") && blue.contains("row1col2") && blue.contains("row1col3") && blue.contains("row1col4"))) {
                row1col1.setImageResource(R.drawable.purplesquare);
                row1col2.setImageResource(R.drawable.purplesquare);
                row1col3.setImageResource(R.drawable.purplesquare);
                row1col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col1") && blue.contains("row2col2") && blue.contains("row2col3") && blue.contains("row2col4")) {
                row2col1.setImageResource(R.drawable.purplesquare);
                row2col2.setImageResource(R.drawable.purplesquare);
                row2col3.setImageResource(R.drawable.purplesquare);
                row2col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col2") && blue.contains("row2col3") && blue.contains("row2col4") && blue.contains("row2col5")) {
                row2col2.setImageResource(R.drawable.purplesquare);
                row2col3.setImageResource(R.drawable.purplesquare);
                row2col4.setImageResource(R.drawable.purplesquare);
                row2col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row3col1") && blue.contains("row3col2") && blue.contains("row3col3") && blue.contains("row3col4")) {
                row3col1.setImageResource(R.drawable.purplesquare);
                row3col2.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row3col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row3col2") && blue.contains("row3col3") && blue.contains("row3col4") && blue.contains("row3col5")) {
                row3col2.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row3col4.setImageResource(R.drawable.purplesquare);
                row3col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row4col1") && blue.contains("row4col2") && blue.contains("row4col3") && blue.contains("row4col4")) {
                row4col1.setImageResource(R.drawable.purplesquare);
                row4col2.setImageResource(R.drawable.purplesquare);
                row4col3.setImageResource(R.drawable.purplesquare);
                row4col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row4col2") && blue.contains("row4col3") && blue.contains("row4col4") && blue.contains("row4col5")) {
                row4col2.setImageResource(R.drawable.purplesquare);
                row4col3.setImageResource(R.drawable.purplesquare);
                row4col4.setImageResource(R.drawable.purplesquare);
                row4col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row5col1") && blue.contains("row5col2") && blue.contains("row5col3") && blue.contains("row5col4")) {
                row5col1.setImageResource(R.drawable.purplesquare);
                row5col2.setImageResource(R.drawable.purplesquare);
                row5col3.setImageResource(R.drawable.purplesquare);
                row5col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row5col2") && blue.contains("row5col3") && blue.contains("row5col4") && blue.contains("row5col5")) {
                row5col2.setImageResource(R.drawable.purplesquare);
                row5col3.setImageResource(R.drawable.purplesquare);
                row5col4.setImageResource(R.drawable.purplesquare);
                row5col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row1col1") && blue.contains("row2col1") && blue.contains("row3col1") && blue.contains("row4col1")) {
                row1col1.setImageResource(R.drawable.purplesquare);
                row2col1.setImageResource(R.drawable.purplesquare);
                row3col1.setImageResource(R.drawable.purplesquare);
                row4col1.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col1") && blue.contains("row3col1") && blue.contains("row4col1") && blue.contains("row5col1")) {
                row2col1.setImageResource(R.drawable.purplesquare);
                row3col1.setImageResource(R.drawable.purplesquare);
                row4col1.setImageResource(R.drawable.purplesquare);
                row5col1.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row1col2") && blue.contains("row2col2") && blue.contains("row3col2") && blue.contains("row4col2")) {
                row1col2.setImageResource(R.drawable.purplesquare);
                row2col2.setImageResource(R.drawable.purplesquare);
                row3col2.setImageResource(R.drawable.purplesquare);
                row4col2.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col2") && blue.contains("row3col2") && blue.contains("row4col2") && blue.contains("row5col2")) {
                row2col2.setImageResource(R.drawable.purplesquare);
                row3col2.setImageResource(R.drawable.purplesquare);
                row4col2.setImageResource(R.drawable.purplesquare);
                row5col2.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row1col3") && blue.contains("row2col3") && blue.contains("row3col3") && blue.contains("row4col3")) {
                row1col3.setImageResource(R.drawable.purplesquare);
                row2col3.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row4col3.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col3") && blue.contains("row3col3") && blue.contains("row4col3") && blue.contains("row5col3")) {
                row2col3.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row4col3.setImageResource(R.drawable.purplesquare);
                row5col3.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col2") && blue.contains("row3col3") && blue.contains("row4col4") && blue.contains("row5col5")) {
                row2col2.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row4col4.setImageResource(R.drawable.purplesquare);
                row5col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row1col4") && blue.contains("row2col4") && blue.contains("row3col4") && blue.contains("row4col4")) {
                row1col4.setImageResource(R.drawable.purplesquare);
                row2col4.setImageResource(R.drawable.purplesquare);
                row3col4.setImageResource(R.drawable.purplesquare);
                row4col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col4") && blue.contains("row3col4") && blue.contains("row4col4") && blue.contains("row5col4")) {
                row2col4.setImageResource(R.drawable.purplesquare);
                row3col4.setImageResource(R.drawable.purplesquare);
                row4col4.setImageResource(R.drawable.purplesquare);
                row5col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row1col5") && blue.contains("row2col5") && blue.contains("row3col5") && blue.contains("row4col5")) {
                row1col5.setImageResource(R.drawable.purplesquare);
                row2col5.setImageResource(R.drawable.purplesquare);
                row3col5.setImageResource(R.drawable.purplesquare);
                row4col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col5") && blue.contains("row3col5") && blue.contains("row4col5") && blue.contains("row5col5")) {
                row2col5.setImageResource(R.drawable.purplesquare);
                row3col5.setImageResource(R.drawable.purplesquare);
                row4col5.setImageResource(R.drawable.purplesquare);
                row5col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row2col1") && blue.contains("row3col2") && blue.contains("row4col3") && blue.contains("row5col4")) {
                row2col1.setImageResource(R.drawable.purplesquare);
                row3col2.setImageResource(R.drawable.purplesquare);
                row4col3.setImageResource(R.drawable.purplesquare);
                row5col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row1col2") && blue.contains("row2col3") && blue.contains("row3col4") && blue.contains("row4col5")) {
                row1col2.setImageResource(R.drawable.purplesquare);
                row2col3.setImageResource(R.drawable.purplesquare);
                row3col4.setImageResource(R.drawable.purplesquare);
                row4col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row4col1") && blue.contains("row3col2") && blue.contains("row2col3") && blue.contains("row1col4")) {
                row4col1.setImageResource(R.drawable.purplesquare);
                row3col2.setImageResource(R.drawable.purplesquare);
                row2col3.setImageResource(R.drawable.purplesquare);
                row1col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row5col2") && blue.contains("row4col3") && blue.contains("row3col4") && blue.contains("row2col5")) {
                row5col2.setImageResource(R.drawable.purplesquare);
                row4col3.setImageResource(R.drawable.purplesquare);
                row3col4.setImageResource(R.drawable.purplesquare);
                row2col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row5col1") && blue.contains("row4col2") && blue.contains("row3col3") && blue.contains("row2col4")) {
                row5col1.setImageResource(R.drawable.purplesquare);
                row4col2.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row2col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row5col1") && blue.contains("row4col2") && blue.contains("row3col3") && blue.contains("row2col4")) {
                row5col1.setImageResource(R.drawable.purplesquare);
                row4col2.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row2col4.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row4col2") && blue.contains("row3col3") && blue.contains("row2col4") && blue.contains("row1col5")) {
                row4col2.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row2col4.setImageResource(R.drawable.purplesquare);
                row1col5.setImageResource(R.drawable.purplesquare);
            }
            if (blue.contains("row1col1") && blue.contains("row2col2") && blue.contains("row3col3") && blue.contains("row4col4")) {
                row1col1.setImageResource(R.drawable.purplesquare);
                row2col2.setImageResource(R.drawable.purplesquare);
                row3col3.setImageResource(R.drawable.purplesquare);
                row4col4.setImageResource(R.drawable.purplesquare);
            }
            MainActivity.user2++;
            if (MainActivity.user2 == 3) {
                Intent ini = new Intent(C4Activity.this, ScoreActivity.class);
                Intent scoreSend = new Intent(C4Activity.this, ScoreActivity.class);
                scoreSend.putExtra("c4Result", result);
                setResult(2, scoreSend);
                finish();
                startActivity(ini);}
                TextView message = findViewById(R.id.message);
                message.setText("Player two Wins");
                row1col1.setEnabled(false);
                row1col2.setEnabled(false);
                row1col3.setEnabled(false);
                row1col4.setEnabled(false);
                row1col5.setEnabled(false);
                row2col1.setEnabled(false);
                row2col2.setEnabled(false);
                row2col3.setEnabled(false);
                row2col4.setEnabled(false);
                row2col5.setEnabled(false);
                row3col1.setEnabled(false);
                row3col2.setEnabled(false);
                row3col3.setEnabled(false);
                row3col4.setEnabled(false);
                row3col5.setEnabled(false);
                row4col1.setEnabled(false);
                row4col2.setEnabled(false);
                row4col3.setEnabled(false);
                row4col4.setEnabled(false);
                row4col5.setEnabled(false);
                row5col1.setEnabled(false);
                row5col2.setEnabled(false);
                row5col3.setEnabled(false);
                row5col4.setEnabled(false);
                row5col5.setEnabled(false);
            }


}


    public void reset() {
        TextView message = findViewById(R.id.message);
        message.setText("A new round has been started");
        row1col1.setEnabled(true);
        row1col1.setImageResource(android.R.drawable.btn_star_big_on);
        row1col2.setEnabled(true);
        row1col2.setImageResource(android.R.drawable.btn_star_big_on);
        row1col3.setEnabled(true);
        row1col3.setImageResource(android.R.drawable.btn_star_big_on);
        row1col4.setEnabled(true);
        row1col4.setImageResource(android.R.drawable.btn_star_big_on);
        row1col5.setEnabled(true);
        row1col5.setImageResource(android.R.drawable.btn_star_big_on);
        row2col1.setEnabled(true);
        row2col1.setImageResource(android.R.drawable.btn_star_big_on);
        row2col2.setEnabled(true);
        row2col2.setImageResource(android.R.drawable.btn_star_big_on);
        row2col3.setEnabled(true);
        row2col3.setImageResource(android.R.drawable.btn_star_big_on);
        row2col4.setEnabled(true);
        row2col4.setImageResource(android.R.drawable.btn_star_big_on);
        row2col5.setEnabled(true);
        row2col5.setImageResource(android.R.drawable.btn_star_big_on);
        row3col1.setEnabled(true);
        row3col1.setImageResource(android.R.drawable.btn_star_big_on);
        row3col2.setEnabled(true);
        row3col2.setImageResource(android.R.drawable.btn_star_big_on);
        row3col3.setEnabled(true);
        row3col3.setImageResource(android.R.drawable.btn_star_big_on);
        row3col4.setEnabled(true);
        row3col4.setImageResource(android.R.drawable.btn_star_big_on);
        row3col5.setEnabled(true);
        row3col5.setImageResource(android.R.drawable.btn_star_big_on);
        row4col1.setEnabled(true);
        row4col1.setImageResource(android.R.drawable.btn_star_big_on);
        row4col2.setEnabled(true);
        row4col2.setImageResource(android.R.drawable.btn_star_big_on);
        row4col3.setEnabled(true);
        row4col3.setImageResource(android.R.drawable.btn_star_big_on);
        row4col4.setEnabled(true);
        row4col4.setImageResource(android.R.drawable.btn_star_big_on);
        row4col5.setEnabled(true);
        row4col5.setImageResource(android.R.drawable.btn_star_big_on);
        row5col1.setEnabled(true);
        row5col1.setImageResource(android.R.drawable.btn_star_big_on);
        row5col2.setEnabled(true);
        row5col2.setImageResource(android.R.drawable.btn_star_big_on);
        row5col3.setEnabled(true);
        row5col3.setImageResource(android.R.drawable.btn_star_big_on);
        row5col4.setEnabled(true);
        row5col4.setImageResource(android.R.drawable.btn_star_big_on);
        row5col5.setEnabled(true);
        row5col5.setImageResource(android.R.drawable.btn_star_big_on);
        user = 2;
    }
}

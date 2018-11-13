package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s527839.trippleplay.R;
import com.example.s527839.trippleplay.MainActivity;
import com.example.s527839.trippleplay.htpActivity;

import java.util.Random;

public class rpsActivity extends AppCompatActivity {
// Rock, Paper, Scissors

    Button htpBTN;
    Button homeBTN;
    String result;
    String player;
    String winningPlayer;
    TextView mTextView_Instructions;
    TextView mTextView_Result;

    Button mButton_Rock;
    Button mButton_Paper;
    Button mButton_Scissors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        mTextView_Instructions = findViewById(R.id.text_instructions);
        mTextView_Result = findViewById(R.id.text_result);
        mButton_Rock = findViewById(R.id.main_button_rock);
        mButton_Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView_Result.setText(play("Rock"));
            }
        });

        mButton_Paper = findViewById(R.id.main_button_paper);
        mButton_Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView_Result.setText(play("Paper"));

            }
        });

        mButton_Scissors = findViewById(R.id.main_button_scissors);
        mButton_Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView_Result.setText(play("Scissors"));

            }
        });


        htpBTN =(Button) findViewById(R.id.htpBTN);

        homeBTN =(Button) findViewById(R.id.homeBTN);

        // Start MainActivity
        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(rpsActivity.this, MainActivity.class);
                Toast.makeText(rpsActivity.this, "Home", Toast.LENGTH_SHORT).show();
                gameResult();
                Intent scoreSend = new Intent(rpsActivity.this, ScoreActivity.class);
                scoreSend.putExtra("hangmanResult", result);
                setResult(3, scoreSend);
                finish();
                startActivity(ini);
            }
        });
    }





    public void gameResult() {
        Toast.makeText(rpsActivity.this, "Player " + winningPlayer + " wins!", Toast.LENGTH_LONG).show();
        result = winningPlayer;
    }

    public String play(String userPick) {
        String sResult = "";

        String[] saOptions = {"Rock", "Paper", "Scissors"};
        // gets a random number between 0 and 2 (stops at 3)
        int iComputerPick = new Random().nextInt(3);
        String sComputerPick = saOptions[iComputerPick];

        if (userPick.equals(sComputerPick))
            sResult = "TIE";
        else if (userPick.equals("Rock")) {
            if (sComputerPick.equals("Paper"))
                sResult = "YOU LOST";
            else if (sComputerPick.equals("Scissors"))
                sResult = "YOU WON";
        } else if (userPick.equals("Paper")) {
            if (sComputerPick.equals("Scissors"))
                sResult = "YOU LOST";
            else if (sComputerPick.equals("Rock"))
                sResult = "YOU WON";
        } else if (userPick.equals("Scissors")) {
            if (sComputerPick.equals("Rock"))
                sResult = "YOU LOST";
            else if (sComputerPick.equals("Paper"))
                sResult = "YOU WON";
        }

        sResult += " (Your Pick: " + userPick + " / Computer Pick: " + sComputerPick + ")";

        return sResult;
    }
}

package com.example.Luke.rockpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTextView_Instructions;
    TextView mTextView_Result;

    Button mButton_Rock;
    Button mButton_Paper;
    Button mButton_Scissors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -------------------------------------------------------------
        mTextView_Instructions = findViewById(R.id.main_textView_instructions);
        mTextView_Result = findViewById(R.id.main_textView_result);
        // -------------------------------------------------------------
        mButton_Rock = findViewById(R.id.main_button_rock);
        mButton_Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView_Result.setText(play("Rock"));
            }
        });
        // -------------------------------------------------------------
        mButton_Paper = findViewById(R.id.main_button_paper);
        mButton_Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView_Result.setText(play("Paper"));

            }
        });
        // -------------------------------------------------------------
        mButton_Scissors = findViewById(R.id.main_button_scissors);
        mButton_Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView_Result.setText(play("Scissors"));

            }
        });
        // -------------------------------------------------------------
    }
    // -------------------------------------------------------------
    private String play(String userPick) {
        String sResult = "";

        String[] saOptions = { "Rock", "Paper", "Scissors" };
        // gets a random number between 0 and 2 (stops at 3)
        int iComputerPick = new Random().nextInt(3);
        String sComputerPick = saOptions[iComputerPick];

        if (userPick.equals(sComputerPick))
            sResult = "TIE";
        else if (userPick.equals("Rock")){
            if (sComputerPick.equals("Paper"))
                sResult = "YOU LOST";
            else if (sComputerPick.equals("Scissors"))
                sResult = "YOU WON";
        }
        else if (userPick.equals("Paper")){
            if (sComputerPick.equals("Scissors"))
                sResult = "YOU LOST";
            else if (sComputerPick.equals("Rock"))
                sResult = "YOU WON";
        }
        else if (userPick.equals("Scissors")){
            if (sComputerPick.equals("Rock"))
                sResult = "YOU LOST";
            else if (sComputerPick.equals("Paper"))
                sResult = "YOU WON";
        }

        sResult += " (Your Pick: " + userPick + " / Computer Pick: " + sComputerPick + ")";

        return sResult;
    }

    // -------------------------------------------------------------
    // -------------------------------------------------------------
}

package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    ImageView user1pick, user2pick;
    TextView user1_text, user2_text, winText;
    ImageButton user1_rock, user2_rock, user1_paper, user2_paper, user1_scissors, user2_scissors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        user1pick = findViewById(R.id.user1View);
        user2pick = findViewById(R.id.user2View);
        user1_text = findViewById(R.id.user1text);
        user2_text = findViewById(R.id.user2text);
        winText = findViewById(R.id.gameresult);
        user1_rock = findViewById(R.id.rock1);
        user2_rock = findViewById(R.id.rock2);
        user1_paper = findViewById(R.id.paper1);
        user2_paper = findViewById(R.id.paper2);
        user1_scissors = findViewById(R.id.scissor1);
        user2_scissors = findViewById(R.id.scissors2);

        user1_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user1pick.setImageResource(R.drawable.rock);

            }
        });

        user1_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user1pick.setImageResource(R.drawable.scissorsbig);
            }
        });

        user1_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user1pick.setImageResource(R.drawable.paper);
            }
        });

        user2_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        user2_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        user2_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
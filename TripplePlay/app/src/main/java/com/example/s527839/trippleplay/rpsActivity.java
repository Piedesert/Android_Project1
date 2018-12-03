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
    Button homeBTN, reset;
    String result;
    int  select1, select2;
    String winningPlayer;
    ImageView user1pick, user2pick;
    TextView message, user1, user2;
    ImageButton user1_rock, user2_rock, user1_paper, user2_paper, user1_scissors, user2_scissors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);


        select1 = 0;
        select2 = 0;
        user1 = findViewById(R.id.user1text);
        user2 = findViewById(R.id.user2text);
        user1pick = findViewById(R.id.user1View);
        user2pick = findViewById(R.id.user2View);
        message = findViewById(R.id.gameresult);
        user1_rock = findViewById(R.id.rock1);
        user2_rock = findViewById(R.id.rock2);
        user1_paper = findViewById(R.id.paper1);
        user2_paper = findViewById(R.id.paper2);
        user1_scissors = findViewById(R.id.scissor1);
        user2_scissors = findViewById(R.id.scissors2);
        reset = findViewById(R.id.resetBTN);

        user1.setText(MainActivity.username1 + "'s Picks");
        user2.setText(MainActivity.username2 + "'s Picks");

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select1 = 0;
                select2 = 0;
                user1_paper.setEnabled(true);
                user1_scissors.setEnabled(true);
                user1_rock.setEnabled(true);
                user2_scissors.setEnabled(true);
                user2_rock.setEnabled(true);
                user2_paper.setEnabled(true);
                user1pick.setImageResource(R.color.colorPrimary);
                user2pick.setImageResource(R.color.colorPrimary);

            }
        });
        user1_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select1 = 1;
                userSelect();
                winCondition();

            }
        });

        user1_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select1 = 2;
                userSelect();
                winCondition();

            }
        });

        user1_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select1 = 3;
                userSelect();
                winCondition();

            }
        });

        user2_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select2 = 1;
                userSelect();
                winCondition();

            }
        });

        user2_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select2 = 2;
                userSelect();
                winCondition();
            }
        });

        user2_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select2 = 3;
                userSelect();
                winCondition();
            }
        });


        htpBTN = (Button) findViewById(R.id.htpBTN);

        homeBTN = (Button) findViewById(R.id.homeBTN);

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

    public void userSelect() {
        if (select1 == 1 && select2 != 0) {
            user1pick.setImageResource(R.drawable.rock);
        }
        if (select1 == 2 && select2 != 0){
            user1pick.setImageResource(R.drawable.scissorsbig);
        }
        if (select1 == 3 && select2 != 0){
            user1pick.setImageResource(R.drawable.paper1);
        }
        if (select2 == 1 && select1 != 0) {
            user2pick.setImageResource(R.drawable.rock);
        }
        if (select2 == 2 && select1 != 0){
            user2pick.setImageResource(R.drawable.scissorsbig);
        }
        if (select2 == 3 && select1 != 0){
            user2pick.setImageResource(R.drawable.paper1);
        }
    }

    public void winCondition(){
        if (select1 == 1 && select2 == 1){
            message.setText("Tie. Both Players chose Rock");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
        }
        if (select1 == 1 && select2 == 2){
            message.setText(MainActivity.username1 + " Wins. Rock beats Scissors");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
            MainActivity.user1++;

        }
        if (select1 == 1 && select2 == 3){
            message.setText(MainActivity.username2 + " Wins. Paper beats Rock");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
            MainActivity.user2++;
        }
        if (select1 == 2 && select2 == 1){
            message.setText(MainActivity.username2 + " Wins. Rock beats Scissors");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
            MainActivity.user2++;
        }
        if (select1 == 2 && select2 == 2){
            message.setText("Tie. Both Players chose Scissors");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
        }
        if (select1 == 2 && select2 == 3){
            message.setText(MainActivity.username1 + " Wins. Scissors beats Paper");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
            MainActivity.user1++;
        }
        if (select1 == 3 && select2 == 1){
            message.setText(MainActivity.username1 + " Wins. Paper beats Rock");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
            MainActivity.user1++;
        }
        if (select1 == 3 && select2 == 2){
            message.setText(MainActivity.username2 + " Wins. Scissors beats Paper");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
            MainActivity.user2++;
        }
        if (select1 == 3 && select2 == 3){
            message.setText("Tie. Both Players chose Paper");
            user1_paper.setEnabled(false);
            user1_scissors.setEnabled(false);
            user1_rock.setEnabled(false);
            user2_scissors.setEnabled(false);
            user2_rock.setEnabled(false);
            user2_paper.setEnabled(false);
        }
        if (MainActivity.user1 == 5 || MainActivity.user2 == 5){
            Intent ini = new Intent(rpsActivity.this, ScoreActivity.class);
            //Toast.makeText(rpsActivity.this, "Rock, Paper, Scissors", Toast.LENGTH_SHORT).show();
            Intent scoreSend = new Intent(rpsActivity.this, ScoreActivity.class);
            scoreSend.putExtra("c4Result", result);
            setResult(2, scoreSend);
            finish();
            startActivity(ini);
        }
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
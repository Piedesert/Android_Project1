package com.example.s527839.trippleplay;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s527839.trippleplay.R;

public class ScoreActivity extends AppCompatActivity {

    int playerOneScore;
    int playerTwoScore;
    int playerThreeScore;
    int playerFourScore;
    int hResult;
    int cResult;
    int rResult;
    Button resetBTN;
    TextView player1TV;
    TextView player2TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        if(MainActivity.user1 == 1){
            Toast.makeText(this, "User 1 Wins!", Toast.LENGTH_SHORT).show();
        }
        resetBTN = (Button) findViewById(R.id.resetBTN);

        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.user1 = 0;
                MainActivity.user2 = 0;
                Intent ini = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(ini);
            }
        });

        player1TV = findViewById(R.id.player1TV);
        player2TV = findViewById(R.id.player2TV);
        String points1 = Integer.toString(MainActivity.user1);
        String points2 = Integer.toString(MainActivity.user2);
        String player1String = MainActivity.username1 + " got " + points1 + " points";
        String player2String = MainActivity.username2 + " got " + points2 + " points";
        player1TV.setText(player1String);
        player2TV.setText(player2String);


    }

    public void onClickSS(View v){
        Intent ini = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(ini, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1){
            String hangmanResult = data.getStringExtra("hangmanResult");
            hResult = Integer.parseInt(hangmanResult);
        }

        else if (resultCode == 2){
            String c4Result = data.getStringExtra("c4Result");
            cResult = Integer.parseInt(c4Result);
        }

        else if (resultCode == 3){
            String rpsResult = data.getStringExtra("rpsResult");
            rResult = Integer.parseInt(rpsResult);
        }
    }

    public void hangmanScore(){
        switch (hResult) {
            case 1:
                playerOneScore ++;
                break;
            case 2:
                playerTwoScore ++;
                break;
            case 3:
                playerThreeScore ++;
                break;
            case 4:
                playerFourScore ++;
                break;
        }
    }

    public void c4Score(){
        switch (cResult) {
            case 1:
                playerOneScore ++;
                break;
            case 2:
                playerTwoScore ++;
                break;
            case 3:
                playerThreeScore ++;
                break;
            case 4:
                playerFourScore ++;
                break;
        }
    }

    public void rpsScore(){
        switch (rResult) {
            case 1:
                playerOneScore ++;
                break;
            case 2:
                playerTwoScore ++;
                break;
            case 3:
                playerThreeScore ++;
                break;
            case 4:
                playerFourScore ++;
                break;
        }
    }

}

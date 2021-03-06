package com.example.s527839.trippleplay;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ActionBar.*;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HangmanActivity extends AppCompatActivity
        implements WordInput.setWord
{
    String result;
    int player;
    int winningPlayer;
    int correctcount = 0;
// Hangman

    private static String SAVED_ONFRAGMENT = "OnFragment";
    private static String SAVED_HANG0_FRAG = "Hang0Fragment";
    private static String SAVED_HANG1_FRAG = "Hang1Fragment";
    private static String SAVED_HANG2_FRAG = "Hang2Fragment";
    private static String SAVED_HANG3_FRAG = "Hang3Fragment";
    private static String SAVED_HANG4_FRAG = "Hang4Fragment";
    private static String SAVED_HANG5_FRAG = "Hang5Fragment";
    private static String SAVED_HANG6_FRAG = "Hang6Fragment";
    private int onFragment = 1;
    private Hangman0Frag h0IMG;
    private Hangman1Frag h1IMG;
    private Hangman2Frag h2IMG;
    private Hangman3Frag h3IMG;
    private Hangman4Frag h4IMG;
    private Hangman5Frag h5IMG;
    private Hangman6Frag h6IMG;

    Button resetBTN;
    Button nextBTN;
    Button htpBTN;
    Button guessBTN;
    private static final int request_code = 1;

    int allowedguess;
    public String newWord;
    public TextView[] spacesTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        // Determine which user is to be guessing,
        final int random = new Random().nextInt((2-1) + 1) + 1;
        player = random;
        if (player == 1) {
            Toast.makeText(HangmanActivity.this,MainActivity.username1 + " Will attempt to hang the man",Toast.LENGTH_LONG).show();
            Toast.makeText(HangmanActivity.this,MainActivity.username1 + " make a one to six letter word",Toast.LENGTH_LONG).show();
        } else {
            player = 2;
            Toast.makeText(HangmanActivity.this,MainActivity.username2 + " Will attempt to hang the man",Toast.LENGTH_LONG).show();
            Toast.makeText(HangmanActivity.this,MainActivity.username2 + " make a one to six letter word",Toast.LENGTH_LONG).show();
        }

        // Input a new guess word
        WordInput input = new WordInput();
        input.show(getSupportFragmentManager(),"New word input");

        if(savedInstanceState!=null){
            // We are being restored, so we need to take care of our instance variables.
            Log.d("Restored", "Recreating my instance variables");
            onFragment = savedInstanceState.getInt(SAVED_ONFRAGMENT);

            // Use the Fragment Manager to save the fragments that are in use.
            FragmentManager manager = getSupportFragmentManager();
            h0IMG = (Hangman0Frag) manager.getFragment(savedInstanceState, SAVED_HANG0_FRAG);
            h1IMG = (Hangman1Frag) manager.getFragment(savedInstanceState, SAVED_HANG1_FRAG);
            h2IMG = (Hangman2Frag) manager.getFragment(savedInstanceState, SAVED_HANG2_FRAG);
            h3IMG = (Hangman3Frag) manager.getFragment(savedInstanceState, SAVED_HANG3_FRAG);
            h4IMG = (Hangman4Frag) manager.getFragment(savedInstanceState, SAVED_HANG4_FRAG);
            h5IMG = (Hangman5Frag) manager.getFragment(savedInstanceState, SAVED_HANG5_FRAG);
            h6IMG = (Hangman6Frag) manager.getFragment(savedInstanceState, SAVED_HANG6_FRAG);
            return;
        }

        // First Time must create and add the fragments
        h0IMG = new Hangman0Frag();
        h1IMG = new Hangman1Frag();
        h2IMG = new Hangman2Frag();
        h3IMG = new Hangman3Frag();
        h4IMG = new Hangman4Frag();
        h5IMG = new Hangman5Frag();
        h6IMG = new Hangman6Frag();

        // Add to use hide/show to swap
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.add(R.id.nooseFrame, h6IMG);
        t.hide(h6IMG);
        t.add(R.id.nooseFrame, h5IMG);
        t.hide(h5IMG);
        t.add(R.id.nooseFrame, h4IMG);
        t.hide(h4IMG);
        t.add(R.id.nooseFrame, h3IMG);
        t.hide(h3IMG);
        t.add(R.id.nooseFrame, h2IMG);
        t.hide(h2IMG);
        t.add(R.id.nooseFrame, h1IMG);
        t.hide(h1IMG);
        t.add(R.id.nooseFrame, h0IMG);
        t.commit();

        nextBTN = (Button) findViewById(R.id.nextBTN);
        resetBTN = (Button) findViewById(R.id.resetBTN);
        htpBTN = (Button) findViewById(R.id.htpBTN);
        guessBTN = (Button) findViewById(R.id.guessBTN);

        // Start next game C4Activity
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(HangmanActivity.this, C4Activity.class);
                Toast.makeText(HangmanActivity.this, "Connect Four", Toast.LENGTH_SHORT).show();
                gameResult();
                Intent scoreSend = new Intent(HangmanActivity.this, ScoreActivity.class);
                scoreSend.putExtra("hangmanResult", result);
                setResult(1,scoreSend);
                finish();
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

        // Start htpActivity (How To Play)
        guessBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getGuess(newWord)){
                    Toast.makeText(HangmanActivity.this, "CORRECT", Toast.LENGTH_SHORT).show();
                    correctcount++;
                    if(allowedguess == correctcount) {
                        if (player == 1) { // if player 1 was guessing, player 2 won
                            winningPlayer = 2;
                        } else {
                            winningPlayer = 1; // else player 2 was guessing and lost
                        }
                        gameResult();
                    }
                }
                else {
                    Toast.makeText(HangmanActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
                    swapNoose();
                }
            }
        });

        // Start htpActivity (How To Play)
        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    } // onCreate

    public void reset(){
        Intent ini = getIntent();
        correctcount = 0;
        finish();
        startActivity(ini);
    } // reset

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // put my private state variables into the bundle
        outState.putInt(SAVED_ONFRAGMENT, onFragment);

        // Save the fragments in the bundle using the fragment manager
        getSupportFragmentManager().putFragment(outState, SAVED_HANG0_FRAG, h0IMG);
        getSupportFragmentManager().putFragment(outState, SAVED_HANG1_FRAG, h1IMG);
        getSupportFragmentManager().putFragment(outState, SAVED_HANG2_FRAG, h2IMG);
        getSupportFragmentManager().putFragment(outState, SAVED_HANG3_FRAG, h3IMG);
        getSupportFragmentManager().putFragment(outState, SAVED_HANG4_FRAG, h4IMG);
        getSupportFragmentManager().putFragment(outState, SAVED_HANG5_FRAG, h5IMG);
        getSupportFragmentManager().putFragment(outState, SAVED_HANG6_FRAG, h6IMG);
    } // oonSaveInstanceState

    public void swapNoose() {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();

        switch (onFragment) {
            case 0: t.hide(h6IMG);
                    t.show(h0IMG);
                    t.commit();
                    onFragment = 1;
                    break;

            case 1: t.hide(h0IMG);
                    t.show(h1IMG);
                    t.commit();
                    onFragment = 2;
                    break;

            case 2: t.hide(h1IMG);
                    t.show(h2IMG);
                    t.commit();
                    onFragment = 3;
                    break;

            case 3: t.hide(h2IMG);
                    t.show(h3IMG);
                    t.commit();
                    onFragment = 4;
                    break;

            case 4: t.hide(h3IMG);
                    t.show(h4IMG);
                    t.commit();
                    onFragment = 5;
                    break;

            case 5: t.hide(h4IMG);
                    t.show(h5IMG);
                    t.commit();
                    onFragment = 6;
                    break;

            case 6: t.hide(h5IMG);
                    t.show(h6IMG);
                    winningPlayer = player;
                    gameResult();
                    t.commit();
                    break;

            default:
                break;
        }
        Log.d("onFragment: ", "Hangman " + onFragment + "/6");

    } // swapNoose

    @Override
    public void setGuessWord(String input) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.guessWordLayout);

        // creating LayoutParams
        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        newWord = input;
        int amount = 50;
        char[] inputArray = input.toCharArray();
        // Determine how many correct guesses needed to win
        allowedguess = inputArray.length;
        spacesTV = new TextView[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            lpView.leftMargin = amount += 10;
            TextView spaceTV = new TextView(this, null, R.attr.guessWordStyle);
            spaceTV.setId(i);
            spaceTV.setLayoutParams(lpView);
            spaceTV.setText("_");
            spaceTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
            linearLayout.addView(spaceTV, lpView);
            spacesTV[i] = spaceTV;
        }
    }

    public boolean getGuess(String guessWord) {
        boolean correct = false;
        EditText input = (EditText) findViewById(R.id.guessET);
        String str = input.getText().toString();
        char[] userGuess = str.toCharArray();
        char[] inputArray = guessWord.toCharArray();

        for (int i = 0; i < userGuess.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (Character.toUpperCase(userGuess[i]) == Character.toUpperCase(inputArray[j])) {
                    spacesTV[j].setText(String.valueOf(userGuess[i]).toUpperCase());
                    correct = true;
                }
            }
        }
        return correct;
    }

    public void gameResult(){

        if (winningPlayer == 1) {
            MainActivity.user1++;
            Toast.makeText(HangmanActivity.this,MainActivity.username1 + " won",Toast.LENGTH_LONG).show();
            SharedPreferences sp = getSharedPreferences("Name", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            int user1Score = sp.getInt("Score", 0);
            user1Score++;
            edit.putInt("Score", user1Score);
            edit.commit();
        }

        if (winningPlayer == 2) {
            MainActivity.user2++;
            Toast.makeText(HangmanActivity.this,MainActivity.username2 + " won",Toast.LENGTH_LONG).show();
            SharedPreferences sp = getSharedPreferences("Name", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            int user2Score = sp.getInt("Score", 0);
            user2Score++;
            edit.putInt("Score", user2Score);
            edit.commit();
        }

        if(MainActivity.user1 == 3){
            Toast.makeText(HangmanActivity.this,MainActivity.username1 + " wins!",Toast.LENGTH_LONG).show();
            Intent ini = new Intent(HangmanActivity.this, ScoreActivity.class);
            Intent scoreSend = new Intent(HangmanActivity.this, ScoreActivity.class);
            scoreSend.putExtra("Hangman Result: ", result);
            setResult(2, scoreSend);
            finish();
            startActivity(ini);
        }

        if(MainActivity.user2 == 3){
            Toast.makeText(HangmanActivity.this,MainActivity.username2 + " wins!",Toast.LENGTH_LONG).show();
            Intent ini = new Intent(HangmanActivity.this, ScoreActivity.class);
            Intent scoreSend = new Intent(HangmanActivity.this, ScoreActivity.class);
            scoreSend.putExtra("Hangman Result: ", result);
            setResult(2, scoreSend);
            finish();
            startActivity(ini);
        }
    } // gameResult

}

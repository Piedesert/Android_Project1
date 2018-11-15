package com.example.s527839.trippleplay;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ActionBar.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s527839.trippleplay.R;
import com.example.s527839.trippleplay.htpActivity;
import com.example.s527839.trippleplay.Hangman0Frag;
import com.example.s527839.trippleplay.Hangman1Frag;
import com.example.s527839.trippleplay.Hangman2Frag;
import com.example.s527839.trippleplay.Hangman3Frag;
import com.example.s527839.trippleplay.Hangman4Frag;
import com.example.s527839.trippleplay.Hangman5Frag;
import com.example.s527839.trippleplay.Hangman6Frag;

import org.w3c.dom.Text;
import java.util.Set;

public class HangmanActivity extends AppCompatActivity
        implements WordInput.setWord
{

    String player;
    String winningPlayer;
    String result;
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

    Button nextBTN;
    Button htpBTN;
    Button guessBTN;
    private static final int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        // Input a new guees word
        WordInput input = new WordInput();
        input.show(getSupportFragmentManager(),"New Word input");

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
        htpBTN = (Button) findViewById(R.id.htpBTN);
        guessBTN = (Button) findViewById(R.id.guessBTN);

        // Start next game C4Activity
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(HangmanActivity.this, C4Activity.class);
                Toast.makeText(HangmanActivity.this, "Connect Four", Toast.LENGTH_SHORT).show();
                // gameResult();
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
                //if (guessMade())
                Toast.makeText(HangmanActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
                swapNoose();
            }
        });

    } // onCreate

    public void reset(){
        onFragment = 1;
        swapNoose();
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
                    t.commit();
                    //gameOver();
                    break;

            default: break;
        }
        Log.d("onFragment: ", "Hangman " + onFragment + "/6");

    } // swapNoose

    @Override
    public void setGuessWord(String input) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.guessWordLayout);
        // creating LayoutParams
        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int amount = 50;
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            TextView spaceTV = new TextView(this, null, R.attr.guessWordStyle);
            lpView.leftMargin = amount += 10;
            spaceTV.setId((int)System.currentTimeMillis());
            spaceTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            spaceTV.setText("_");
            linearLayout.addView(spaceTV, lpView);
        }

    }
/*
    public void gameResult(){
        Toast.makeText(HangmanActivity.this,winningPlayer + " wins!",Toast.LENGTH_LONG).show();
        if (1) {
            result = winningPlayer;
            MainActivity.user1++;
        }

        if (2) {
            result = winningPlayer;
            MainActivity.user2++;
        }

        if(MainActivity.user1 == 3){
            Intent ini = new Intent(HangmanActivity.this, ScoreActivity.class);
            Intent scoreSend = new Intent(HangmanActivity.this, ScoreActivity.class);
            scoreSend.putExtra("Hangman Result: ", result);
            setResult(2, scoreSend);
            finish();
            startActivity(ini);
        }
    } // gameResult
*/
}

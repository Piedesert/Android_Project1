package com.example.s527839.trippleplay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ActionBar.*;

import com.example.s527839.trippleplay.HangmanActivity;
import com.example.s527839.trippleplay.R;
import com.example.s527839.trippleplay.htpActivity;

public class MainActivity extends AppCompatActivity {
// Main Menu

    Button playBTN;
    Button htpBTN;
    private static final int request_code = 1;

    public static int user1 = 0;
    public static int user2 = 0;
    public static String username1;
    public static String username2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBTN = (Button) findViewById(R.id.playBTN);
        htpBTN = (Button) findViewById(R.id.htpBTN);

        // Start play with HangmanActivity
        playBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(MainActivity.this, HangmanActivity.class);

                SharedPreferences sp = getSharedPreferences("Name", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                EditText playerName1 = findViewById(R.id.player1name);
                EditText playerName2 = findViewById(R.id.player2name);
                username1 = playerName1.getText().toString();
                username2 = playerName2.getText().toString();

                edit.putString("Name", username1);
                edit.putString("Name", username2);
                edit.putInt("Score", user1);
                edit.putInt("Score", user2);
                edit.commit();

                // Toast.makeText(MainActivity.this, "Time to Tripple Play!", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });

        // Start htpActivity
        htpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(MainActivity.this, htpActivity.class);
                Toast.makeText(MainActivity.this, "How To Play", Toast.LENGTH_SHORT).show();
                startActivity(ini);
            }
        });

    }

}
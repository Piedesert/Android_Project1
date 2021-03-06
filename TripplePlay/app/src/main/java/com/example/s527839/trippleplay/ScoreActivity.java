package com.example.s527839.trippleplay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TwoLineListItem;

import com.example.s527839.trippleplay.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ScoreActivity extends AppCompatActivity {

    int playerOneScore;
    int playerTwoScore;
    int playerThreeScore;
    int playerFourScore;
    int hResult;
    int cResult;
    int rResult;
    Button resetBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ListView resultsListView = (ListView) findViewById(R.id.list);
        SharedPreferences sp = getSharedPreferences("Name", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        int user2Score = sp.getInt("Score", 0);
        String name1 = sp.getString("Name", "");
        String userScore2 = String.valueOf(user2Score);
        String user1 = MainActivity.username1;
        String user2 = MainActivity.username2;
        String user1S = String.valueOf(MainActivity.user1);
        String user2S = String.valueOf(MainActivity.user2);
        HashMap<String, String> values = new HashMap<>();
        //values.put(name1, userScore2);
        values.put(user1, user1S);
        values.put(user2, user2S);
        /*values.put("jorda", "935");
        values.put("jord", "934");
        values.put("jor", "933");
        values.put("jo", "932");
        values.put("hell", "20");
        values.put("hel", "20");
        values.put("he", "206");
        values.put("helo", "205");
        values.put("heo", "204");
        values.put("hllo", "202");
        */




        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_items,
                new String[]{"firstLine", "SecondLine"}, new int[]{R.id.text1, R.id.text2});
        Iterator aIter = values.entrySet().iterator();
        while(aIter.hasNext()){
            HashMap<String, String> results = new HashMap<>();
            Map.Entry putter = (Map.Entry)aIter.next();
            results.put("firstLine", putter.getKey().toString());
            results.put("SecondLine", putter.getValue().toString());
            listItems.add(results);
        }

        resultsListView.setAdapter(adapter);

        if (MainActivity.user1 == 5) {
            Toast.makeText(this, MainActivity.username1 + " Wins!", Toast.LENGTH_LONG).show();
        }
        if (MainActivity.user2 == 5) {
            Toast.makeText(this, MainActivity.username2 + " Wins!", Toast.LENGTH_LONG).show();
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

        //player1TV = findViewById(R.id.player1TV);
        //player2TV = findViewById(R.id.player2TV);
        String points1 = Integer.toString(MainActivity.user1);
        String points2 = Integer.toString(MainActivity.user2);
        String player1String = MainActivity.username1 + " got " + points1 + " points";
        String player2String = MainActivity.username2 + " got " + points2 + " points";
        // player1TV.setText(player1String);
        //player2TV.setText(player2String);


    }

    public void onClickSS(View v) {
        Intent ini = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(ini, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            String hangmanResult = data.getStringExtra("hangmanResult");
            hResult = Integer.parseInt(hangmanResult);
        } else if (resultCode == 2) {
            String c4Result = data.getStringExtra("c4Result");
            cResult = Integer.parseInt(c4Result);
        } else if (resultCode == 3) {
            String rpsResult = data.getStringExtra("rpsResult");
            rResult = Integer.parseInt(rpsResult);
        }
    }


}

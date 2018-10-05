package com.example.s527839.trippleplay;

<<<<<<< HEAD
<<<<<<< HEAD
import android.app.Activity;
=======
>>>>>>> 84ed63774e0f80d6006b96d0d38154e88ddb62f6
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.Toast;
=======
>>>>>>> 84ed63774e0f80d6006b96d0d38154e88ddb62f6
=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
>>>>>>> parent of 46d43ab... Roughly connected all Activities

public class HangmanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
    }
    //goes to connect 4 activity
    public void onClickC4(View v){
        Intent ini = new Intent(v.getContext(), C4Activity.class);
        startActivityForResult(ini, 1);
    }
}

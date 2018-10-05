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

public class rpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
    }
    //Goes back to Start Screen on click
    public void onClickSB(View v){
        Intent ini = new Intent(v.getContext(), scoreActivity.class);
        startActivityForResult(ini, 1);
    }
}

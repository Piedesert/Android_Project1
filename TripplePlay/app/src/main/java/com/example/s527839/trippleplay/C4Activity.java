package com.example.s527839.trippleplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.Toast;
=======
>>>>>>> 84ed63774e0f80d6006b96d0d38154e88ddb62f6
=======
>>>>>>> parent of 46d43ab... Roughly connected all Activities

public class C4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4);
    }

    public void onClickrps(View v){
        Intent ini = new Intent(v.getContext(), rpsActivity.class);
        startActivityForResult(ini, 1);
    }
}

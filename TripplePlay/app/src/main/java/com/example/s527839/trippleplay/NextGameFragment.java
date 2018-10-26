package com.example.s527839.trippleplay;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.s527839.trippleplay.R;
import com.example.s527839.trippleplay.C4Activity;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextGameFragment extends Fragment {


    public interface NextGame {
        public void nextGame();
    }

    public NextGameFragment() {
        // Required empty public constructor
    }

    private NextGameFragment.NextGame myActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_next_game, container, false);
        Button next = v.findViewById(R.id.nextBTN);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(getActivity(), C4Activity.class);
                Toast.makeText(getContext(),"Next Game",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}

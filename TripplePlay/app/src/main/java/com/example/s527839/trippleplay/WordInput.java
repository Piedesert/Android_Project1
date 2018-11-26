package com.example.s527839.trippleplay;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordInput extends DialogFragment {

    private String m_Text;
    EditText input;

    public String getWord() {
        return m_Text;
    }

    public void setM_Text(String m_Text) {
        this.m_Text = m_Text;
    }

    public interface setWord {
        public void setGuessWord(String input);
    }

    public WordInput() {
        // Required empty public constructor
    }

    private WordInput.setWord myActivity;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder factory = new AlertDialog.Builder(getContext());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        factory.setView(inflater.inflate(R.layout.guess_wordinput_layout, null));

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.guess_wordinput_layout, (ViewGroup) getView(), false);

        // Set up the input
        input = (EditText) viewInflated.findViewById(R.id.guessWordET);
/*
        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher ms = ps.matcher(input.getText().toString());
        boolean bs = ms.matches();
        if (bs == false) {
            Toast.makeText(getActivity(), "Only characters allowed", Toast.LENGTH_LONG).show();
        }
*/
        //input.setInputType(InputType.TYPE_CLASS_TEXT);

        factory.setView(viewInflated);
        factory.setTitle("Input a word to be guessed");

        factory.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                setM_Text(m_Text);
                ((HangmanActivity)getActivity()).setGuessWord(m_Text);
            }
        });
        /*
        factory.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("alert","User Pressed Cancel");
                dialog.cancel();
            }
        });*/
        return factory.create();
    }

}

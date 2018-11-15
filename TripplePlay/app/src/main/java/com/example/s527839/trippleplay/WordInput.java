package com.example.s527839.trippleplay;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class WordInput extends DialogFragment {

    private String m_Text;
    EditText input;

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

        // Make it pretty later
        factory.setView(inflater.inflate(R.layout.guess_word_layout, null));

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.guess_word_layout, (ViewGroup) getView(), false);

        // Set up the input
        input = (EditText) viewInflated.findViewById(R.id.guessWordET);
        input.setInputType(InputType.TYPE_CLASS_TEXT);

        factory.setView(viewInflated);
        factory.setTitle("Input a word to be guessed");

        //factory.setMessage("");

        factory.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String saved = input.getText().toString();
                m_Text = input.getText().toString();
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

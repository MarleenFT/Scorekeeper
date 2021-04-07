package com.example.scorekeeper;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class HighScore extends Fragment {

    private EditText eUser, eGame, eScore, eGetUser;
    private Context _context;

    HighScore(Context context) {
        // Required empty public constructor
        _context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_high_score, container, false);

        eUser = v.findViewById(R.id.username);
        eGame = v.findViewById(R.id.game);
        eScore = v.findViewById(R.id.score);
        eGetUser = v.findViewById(R.id.get_username);
        Button inpButton = v.findViewById(R.id.inp_button);
        Button outButton = v.findViewById(R.id.out_button);

        inpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData();
            }
        });

        outButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputData();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    private void inputData() {
        String username = eUser.getText().toString();
        String game = eGame.getText().toString();
        String score = eScore.getText().toString();

        new BackgroundWorker(_context).execute(username, game, score);
    }

    private void outputData() {
        String username = eGetUser.getText().toString();
        String get1 = "getData";
        String get2 = "getData";

        new BackgroundWorker(_context).execute(username, get1, get2);
    }
}

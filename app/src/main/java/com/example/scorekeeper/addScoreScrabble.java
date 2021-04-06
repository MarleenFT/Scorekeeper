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
public class addScoreScrabble extends Fragment {

    // Required empty public constructor
    private LocalDatabaseHelper MyDB;
    ListItems listItems;

    addScoreScrabble(Context context) {
        MyDB = new LocalDatabaseHelper(context);
        if (MyDB.getAllData().getCount() == 0)
            MyDB.insertData(0,0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_score_scrabble, container, false);

        final EditText addScore = view.findViewById(R.id.editScore);
        Button button = view.findViewById(R.id.editScoreCommitButton);
        Button remButton = view.findViewById(R.id.remButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDB.insertData((MyDB.getLatestFromTable() + Integer.parseInt(addScore.getText().toString())), Integer.parseInt(addScore.getText().toString()));
                assert getFragmentManager() != null;
                getFragmentManager().popBackStack();
            }
        });

        remButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDB.removeAllData();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}

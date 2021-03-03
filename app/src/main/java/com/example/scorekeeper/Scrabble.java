package com.example.scorekeeper;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scrabble extends Fragment {

    LocalDatabaseHelper ScrabbleDB;
    ListItems listItems;

    public Scrabble() {
        // Required empty public constructor
        listItems = new ListItems();

        listItems.addItems("AddToScore", new addScoreScrabble());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scrabble, container, false);

        Button button = view.findViewById(R.id.add_button);

        ScrabbleDB = new LocalDatabaseHelper(getContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, listItems.getFragmentByIndex(0)).addToBackStack(null).commit();
            }
        });
        
        // Inflate the layout for this fragment
        return view;
    }

}

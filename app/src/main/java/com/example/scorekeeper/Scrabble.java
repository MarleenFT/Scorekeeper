package com.example.scorekeeper;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scrabble extends Fragment {

    LocalDatabaseHelper ScrabbleDB;

    public Scrabble() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scrabble, container, false);

        ScrabbleDB = new LocalDatabaseHelper(getContext());
        
        // Inflate the layout for this fragment
        return view;
    }

}

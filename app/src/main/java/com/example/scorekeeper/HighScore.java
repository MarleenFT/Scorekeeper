package com.example.scorekeeper;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HighScore extends Fragment {

    public HighScore() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_high_score, container, false);

        // Inflate the layout for this fragment
        return v;
    }

    private void argumentParser (View v) {

    }
}

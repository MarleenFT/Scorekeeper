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
public class Calculator extends Fragment {

    public Calculator() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculator, container, false);

        Button button[] = {v.findViewById(R.id.b0),v.findViewById(R.id.b1),v.findViewById(R.id.b2),v.findViewById(R.id.b3),v.findViewById(R.id.b4),v.findViewById(R.id.b5),v.findViewById(R.id.b6),v.findViewById(R.id.b7),v.findViewById(R.id.b8),v.findViewById(R.id.b9),v.findViewById(R.id.bDP),v.findViewById(R.id.bIS),v.findViewById(R.id.bDEV),v.findViewById(R.id.bMIN),v.findViewById(R.id.bMULT),v.findViewById(R.id.bPLUS)};

        for (int i = 0; i < button.length; i++) {
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    argumentParser(v);
                }
            });
        }

        // Inflate the layout for this fragment
        return v;
    }

    private void argumentParser (View v) {

    }
}

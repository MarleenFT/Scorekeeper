package com.example.scorekeeper;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class gamesList extends Fragment {

    ListView listView;

    public gamesList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_games_list, container, false);

        listView = v.findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Munchkin");
        arrayList.add("Yahtzee");
        arrayList.add("Scrabble");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        // Inflate the layout for this fragment
        return v;
    }

}

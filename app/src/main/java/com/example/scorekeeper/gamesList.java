package com.example.scorekeeper;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class gamesList extends Fragment {

    private ListItems listItems;

    public gamesList() {
        // Required empty public constructor
        listItems = new ListItems();

        listItems.addItems("Munchkin",  new Munchkin());
        listItems.addItems("Yahtzee",   new Yahtzee());
        listItems.addItems("Scrabble",  new Scrabble());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_games_list, container, false);

        ListView listView = v.findViewById(R.id.listview);

        if (listItems.getListSize() > 0) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()).getBaseContext(), android.R.layout.simple_list_item_1, listItems.getNamesList());

            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    checkListItem(position);
                }
            });
        }

        // Inflate the layout for this fragment
        return v;
    }

    private void checkListItem(int pos) {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, listItems.getFragmentByIndex(pos)).addToBackStack(null).commit();
    }

}

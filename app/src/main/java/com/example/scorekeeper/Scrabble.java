package com.example.scorekeeper;


import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scrabble extends Fragment {

    LocalDatabaseHelper MyDB;
    private ListItems listItems;
    Context _context;

    public Scrabble(Context context) {
        // Required empty public constructor
        _context = context;

        MyDB = new LocalDatabaseHelper(_context);

        listItems = new ListItems();
        listItems.addItems("AddToScore", new addScoreScrabble(context));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scrabble, container, false);

        Button button = view.findViewById(R.id.add_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems.replaceFragmentContainer(listItems.getFragmentByIndex(0), listItems.getNameByIndex(0), null);
            }
        });

        TableRow tableRow = new TableRow(_context);

        viewAll();
        
        // Inflate the layout for this fragment
        return view;
    }

    private void viewAll() {
        Cursor data = MyDB.getAllData();

        if (data.getCount() > 0) {
            StringBuilder buffer = new StringBuilder();
            while (data.moveToNext()) {
                buffer.append("Total: ").append(data.getInt(1)).append("\n");
                buffer.append("Added: ").append(data.getInt(2)).append("\n\n");
            }
            showPoints("Data", buffer.toString());
        }
        else
            showPoints("Error", "No data was found");
    }

    private void showPoints(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(_context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}

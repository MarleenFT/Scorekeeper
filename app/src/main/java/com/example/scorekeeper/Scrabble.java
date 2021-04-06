package com.example.scorekeeper;


import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scrabble extends Fragment {

    private LocalDatabaseHelper MyDB;
    private ListItems listItems;

    Scrabble(Context context) {
        // Required empty public constructor

        MyDB = new LocalDatabaseHelper(context);

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

        String pointItems = viewAll();
        TextView tv = view.findViewById(R.id.scoreText);
        tv.setMovementMethod(new ScrollingMovementMethod());
        tv.setText(pointItems);
        
        // Inflate the layout for this fragment
        return view;
    }

    private String viewAll() {
        Cursor data = MyDB.getAllData();

        if (data.getCount() > 0) {
            StringBuilder buffer = new StringBuilder();
            while (data.moveToNext()) {
                buffer.append("Total: ").append(data.getInt(1)).append("\n");
                buffer.append("Added: ").append(data.getInt(2)).append("\n\n");
            }
            return buffer.toString();
        }
        else
            return "No data was found!";
    }

}

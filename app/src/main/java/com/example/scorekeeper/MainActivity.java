package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.fragment_container) != null) {

            if(savedInstanceState != null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            gamesList fragment = new gamesList();
            fragmentTransaction.add(R.id.fragment_container, fragment, "LIST_ADD").commit();
        }

        final ListItems listItems = new ListItems();
        listItems.addItems("Calculator", new Calculator());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = (Calculator)getSupportFragmentManager().findFragmentByTag("CALC_OPEN");
                if (calculator != null && calculator.isVisible()) {
                    fragmentManager.popBackStackImmediate(getBackStackName(), 1);
                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, listItems.getFragmentByIndex(0), "CALC_OPEN").addToBackStack(listItems.getNameByIndex(0)).commit();
                }
            }
        });
    }

    private String getBackStackName() {
        String returnString;
        int count = getSupportFragmentManager().getBackStackEntryCount();
        returnString = fragmentManager.getBackStackEntryAt(count - 1).getName();

        return returnString;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
























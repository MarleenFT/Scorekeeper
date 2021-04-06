package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    boolean exiting = false;

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
            gamesList fragment = new gamesList(MainActivity.this);
            fragmentTransaction.add(R.id.fragment_container, fragment, "LIST_ADD").commit();
        }

        final ListItems listItems = new ListItems();
        listItems.addItems("Calculator", new Calculator());

        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = (Calculator)getSupportFragmentManager().findFragmentByTag("CALC_OPEN");
                if (calculator != null && calculator.isVisible()) {
                    fragmentManager.popBackStackImmediate(listItems.getBackStackName(), 1);
                }
                else {
                    listItems.replaceFragmentContainer(listItems.getFragmentByIndex(0), listItems.getNameByIndex(0), "CALC_OPEN");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!exiting && getSupportFragmentManager().getBackStackEntryCount() == 0) {
            Toast.makeText(MainActivity.this, "Are you sure you want to exit? Press back again.", Toast.LENGTH_SHORT).show();
            exiting = true;
        }
        else {
            exiting = false;
            super.onBackPressed();
        }
    }
}
























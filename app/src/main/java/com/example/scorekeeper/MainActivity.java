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

    FloatingActionButton Fab;

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

        Fab = (FloatingActionButton)findViewById(R.id.floatingActionButton2);

        Fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = (Calculator)getSupportFragmentManager().findFragmentByTag("CALC_OPEN");
                if (calculator != null && calculator.isVisible()) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, new gamesList(), "LIST_OPEN").commit();
                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, new Calculator(), "CALC_OPEN").commit();
                }
            }
        });
    }
}

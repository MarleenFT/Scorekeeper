package com.example.scorekeeper;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ListItems {
    private ArrayList<String>   namesList;
    private ArrayList<Fragment> fragmentsList;
    private int listSize;

    public ListItems() {
        namesList =     new ArrayList<>();
        fragmentsList = new ArrayList<>();
        listSize = 0;
    }

    void addItems(String name, Fragment fm) {
        namesList.add(name);
        fragmentsList.add(fm);
        listSize++;
    }

    public ArrayList<String> getNamesList() {
        return namesList;
    }

    public ArrayList<Fragment> getFragmentsList() {
        return fragmentsList;
    }

    String getNameByIndex(int index) {
        return namesList.get(index);
    }

    Fragment getFragmentByIndex(int index) {
        return fragmentsList.get(index);
    }

    public int getListSize() {
        return listSize;
    }
}

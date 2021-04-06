package com.example.scorekeeper;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

class ListItems {
    private ArrayList<String>   namesList;
    private ArrayList<Fragment> fragmentsList;
    private int listSize;

    ListItems() {
        namesList =     new ArrayList<>();
        fragmentsList = new ArrayList<>();
        listSize = 0;
    }

    void addItems(String name, Fragment fm) {
        namesList.add(name);
        fragmentsList.add(fm);
        listSize++;
    }

    ArrayList<String> getNamesList() {
        return namesList;
    }

//    ArrayList<Fragment> getFragmentsList() {
//        return fragmentsList;
//    }

    String getNameByIndex(int index) {
        return namesList.get(index);
    }

    Fragment getFragmentByIndex(int index) {
        return fragmentsList.get(index);
    }

    int getListSize() {
        return listSize;
    }

    void replaceFragmentContainer(Fragment fragment, String name, String tag) {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, tag).addToBackStack(name).commit();
    }

    String getBackStackName() {
        String returnString;
        int count = MainActivity.fragmentManager.getBackStackEntryCount();
        returnString = MainActivity.fragmentManager.getBackStackEntryAt(count - 1).getName();

        return returnString;
    }
}

package com.example.scorekeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME    = "LocalScores.db";
    private static final String TABLE_NAME       = "T_ScrabbleScore";
    private static final String ID               = "ID";
    private static final String TOTAL_SCORE      = "Total";
    private static final String SCORE_TO_ADD     = "Points";

    LocalDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TOTAL_SCORE + " INTEGER, " + SCORE_TO_ADD + " INTEGER );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    boolean insertData(int totalScore, int scoreToAdd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TOTAL_SCORE, totalScore);
        contentValues.put(SCORE_TO_ADD, scoreToAdd);
        long result = db.insert(TABLE_NAME, null, contentValues);

        return (result != -1);
    }

    Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

    }

    int getLatestFromTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT `" + TOTAL_SCORE + "` FROM `" + TABLE_NAME + "` WHERE `" + ID + "` = (SELECT MAX( `" + ID + "` ) FROM `"+ TABLE_NAME +"`)", null);

        data.moveToLast();

        int retVal = data.getInt(0);

        data.close();

        return retVal;
    }

    void removeAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
        insertData(0,0);
    }
}

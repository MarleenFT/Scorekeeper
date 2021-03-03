package com.example.scorekeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LocalDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME    = "LocalScores.db";
    private static final String TABLE_NAME       = "T_ScrabbleScore";
    private static final String ID               = "ID";
    private static final String TOTAL_SCORE      = "Total";
    private static final String SCORE_TO_ADD     = "Points";

    public LocalDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TOTAL_SCORE + " INT, " + SCORE_TO_ADD + " INT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    public boolean insertData(int totalScore, int scoreToAdd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TOTAL_SCORE, totalScore);
        contentValues.put(SCORE_TO_ADD, scoreToAdd);
        long result = db.insert(TABLE_NAME, null, contentValues);

        return (result != -1);
    }
}

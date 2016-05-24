package com.shellcore.android.databaseboolean.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "dbboolean.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createBooleanTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createBooleanTable() {
        return "CREATE TABLE " + DBTables.BOOLTABLE.TABLE
                + " ("
                + " " + DBTables.BOOLTABLE.C_ID + " INTEGER PRIMARY KEY,"
                + " " + DBTables.BOOLTABLE.C_VALUE + " BOOLEAN"
                + " )";
    }
}

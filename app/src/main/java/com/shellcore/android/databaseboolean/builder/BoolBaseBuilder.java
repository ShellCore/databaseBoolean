package com.shellcore.android.databaseboolean.builder;

import android.content.ContentValues;
import android.database.Cursor;

import com.shellcore.android.databaseboolean.database.DBTables;
import com.shellcore.android.databaseboolean.models.BoolBase;

public class BoolBaseBuilder {
    public static ContentValues createContentValue(BoolBase boolBase) {
        ContentValues contentValues = new ContentValues();
        if (boolBase.getId() != 0) {
            contentValues.put(DBTables.BOOLTABLE.C_ID, boolBase.getId());
        }
        contentValues.put(DBTables.BOOLTABLE.C_VALUE, boolBase.isValue());

        return contentValues;
    }


    public static BoolBase createBoolBase(Cursor cursor) {
        BoolBase boolBase = new BoolBase();

        boolBase.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DBTables.BOOLTABLE.C_ID)));
        boolBase.setValue(cursor.getInt(cursor.getColumnIndexOrThrow(DBTables.BOOLTABLE.C_VALUE)) == 1 ? true : false);

        return boolBase;
    }
}

package com.shellcore.android.databaseboolean.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.shellcore.android.databaseboolean.builder.BoolBaseBuilder;
import com.shellcore.android.databaseboolean.models.BoolBase;

public class DBBoolBase extends DBBase<BoolBase> {
    public DBBoolBase(Context context) {
        super(context, DBTables.BOOLTABLE.TABLE);
    }

    @Override
    protected ContentValues createContentValue(BoolBase boolBase) {
        return BoolBaseBuilder.createContentValue(boolBase);
    }

    @Override
    protected BoolBase createBO(Cursor cursor) {
        return BoolBaseBuilder.createBoolBase(cursor);
    }
}

package com.shellcore.android.databaseboolean.models;

public class BoolBase {
    private int id;
    private boolean value;

    public BoolBase() {
    }

    public BoolBase(int id, boolean value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

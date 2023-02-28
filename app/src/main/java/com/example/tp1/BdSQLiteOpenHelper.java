package com.example.tp1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BdSQLiteOpenHelper extends SQLiteOpenHelper {

    private String table_typeplat="CREATE TABLE typeplat (idTP INTEGER PRIMARY KEY, libelleTP TEXT NOT NULL)";

    private String table_plat = "CREATE TABLE plat (idP INTEGER PRIMARY KEY, libelleP TEXT NOT NULL, idTP INTEGER NOT NULL, FOREIGN KEY(idTP) REFERENCES typeplat(idTP))";

    public BdSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_typeplat);
        db.execSQL(table_plat);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.example.logreg;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;

public class dbhelper extends SQLiteOpenHelper {


    public static final String DB_NAME = "felhasznalo.db";
    public static final int DB_VERSION = 1;

    public static final String FELHASZNALO_TABLE = "felhasznalo";

    public static final String COL_ID = "id";
    public static final String COL_EMAIL = "email";
    public static final String COL_FELHNEV = "felhnev";
    public static final String COL_JELSZO = "jelszo";
    public static final String COL_TELJESNEV = "teljesnev";

    public dbhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + FELHASZNALO_TABLE + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_EMAIL + " VARCHAR(255) NOT NULL UNIQUE," +
                COL_FELHNEV + " VARCHAR(255) NOT NULL UNIQUE," +
                COL_JELSZO + " VARCHAR(255) NOT NULL," +
                COL_TELJESNEV + " VARCHAR(255) NOT NULL" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + FELHASZNALO_TABLE;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean regisztracio(String email, String felhnev, String jelszo, String teljesnev) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_EMAIL, email);
        values.put(COL_FELHNEV,felhnev);
        values.put(COL_JELSZO, jelszo);
        values.put(COL_TELJESNEV, teljesnev);

        return db.insert(FELHASZNALO_TABLE, null, values) != -1;
    }
    public boolean login(String felhnev, String jelszo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (false){

        values.put(COL_FELHNEV, felhnev);
        values.put(COL_JELSZO, jelszo);
        }


        return db.insert(FELHASZNALO_TABLE, null, values) != -1;
    }



}

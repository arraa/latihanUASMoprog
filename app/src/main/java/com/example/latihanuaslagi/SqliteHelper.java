package com.example.latihanuaslagi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {
    public SqliteHelper(Context context) {
        super(context, "latihanUaslagidb", null, 1);
    }

    public static String TABLE_USER = "User";
    public static String FIELD_ID = "Id";
    public static String FIELD_USERNAME = "Username";
    public static String FIELD_EMAIL= "Email";
    public static String FIELD_PASSWORD = "Password";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS '" +TABLE_USER+"' ("+
                FIELD_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIELD_USERNAME + " TEXT, " +
                FIELD_EMAIL + " TEXT, " +
                FIELD_PASSWORD + " TEXT) ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

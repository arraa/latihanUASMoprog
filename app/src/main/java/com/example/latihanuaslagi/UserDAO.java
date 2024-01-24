package com.example.latihanuaslagi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserDAO {
    public void insert(Context context, User user){
        SqliteHelper helper = new SqliteHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(helper.FIELD_USERNAME, user.getName());
        cv.put(helper.FIELD_EMAIL, user.getEmail());
        cv.put(helper.FIELD_PASSWORD, user.getPassword());

        db.insertWithOnConflict(helper.TABLE_USER, null, cv, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void delete(Context context, int id){
        SqliteHelper helper = new SqliteHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] args = {""+id};
        String where = helper.FIELD_ID + " = ?";
        db.delete(helper.TABLE_USER, where, args);
    }

    public void Update(Context context, User user){
        SqliteHelper helper = new SqliteHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(helper.FIELD_USERNAME, user.getName());
        cv.put(helper.FIELD_EMAIL, user.getEmail());
        cv.put(helper.FIELD_PASSWORD, user.getPassword());

        String[] args = {""+user.getId()};
        String where = helper.FIELD_ID + " = ?";

        db.update(helper.TABLE_USER, cv, where, args);
        db.close();
    }

    public ArrayList<User> getList(Context context){
        ArrayList<User> users = new ArrayList<>();
        SqliteHelper helper = new SqliteHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(helper.TABLE_USER, null,null,null,null,null,null);

        while (cursor.moveToNext()){
            User user = new User();
            String name = user.getName();
            String email = user.getEmail();
            String pass = user.getPassword();
            int id = user.getId();

            id = Integer.parseInt(cursor.getString(0));
            name = cursor.getString(1);
            email = cursor.getString(2);
            pass = cursor.getString(3);

            users.add(new User(id, name, email, pass));
        }
        return users;
    }
}

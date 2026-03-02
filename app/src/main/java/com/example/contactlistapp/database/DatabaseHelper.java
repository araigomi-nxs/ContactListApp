package com.example.contactlistapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.contactlistapp.models.Contact;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contacts.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contacts (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "phone_number TEXT," +
                "image INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    //insertUser db.insert
    public void insertContact( Contact contactperson)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("name",contactperson.getName());
        value.put("phone_number",contactperson.getPhoneNumber());
        value.put("image",contactperson.getImage());

        db.insert("contacts", null, value);
        db.close();
    }


    //readContacts  db.query - return Contact object - ListView
    //updateUser db.update
    //deleteUser db.delete





}

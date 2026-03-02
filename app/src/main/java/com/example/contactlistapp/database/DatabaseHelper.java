package com.example.contactlistapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.contactlistapp.models.Contact;

import java.util.ArrayList;
import java.util.List;

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
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put("name",contactperson.getName());
        value.put("phone_number",contactperson.getPhoneNumber());
        value.put("image",contactperson.getImage());
        db.insert("contacts", null, value);

    }

    public List<Contact> getAllContacts()
    {
        List <Contact> contacts = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("contacts", new String[]{"id", "name", "phone_number", "image"}, null, null, null, null, null);

        while ( cursor.moveToNext())
        {
            Contact contact = new Contact(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3)
            );
            contacts.add(contact);
        }
        cursor.close();
        db.close();
        return contacts;
    }


    //readContacts  db.query - return Contact object - ListView
    //updateUser db.update
    //deleteUser db.delete





}

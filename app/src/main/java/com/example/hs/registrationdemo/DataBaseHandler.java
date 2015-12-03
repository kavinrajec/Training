package com.example.hs.registrationdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HS on 27-11-2015.
 */
public class DataBaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FIRS_TNAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_DATE_BIRTH = "date_birth";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PH_NO = "phone_number";
    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_FIRS_TNAME + " TEXT,"
                + KEY_LAST_NAME + " TEXT,"
                + KEY_DATE_BIRTH + " TEXT,"
                + KEY_GENDER + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRS_TNAME, contact.getFirstName()); // Contact Name
        values.put(KEY_LAST_NAME, contact.getLastName());
        values.put(KEY_DATE_BIRTH, contact.getDateOfBirth());
        values.put(KEY_GENDER, contact.getGender());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setFirstName(cursor.getString(1));
                contact.setLastName(cursor.getString(2));
                contact.setDateOfBirth(cursor.getString(3));
                contact.setGender(cursor.getString(4));
                contact.setEmail(cursor.getString(5));
                contact.setPhoneNumber(cursor.getString(6));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
}

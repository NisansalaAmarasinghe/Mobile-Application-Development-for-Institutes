package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TeachersDB extends SQLiteOpenHelper {

    // Database Name and Version
    private static final String DATABASE_NAME = "teachers.db";
    private static final int DATABASE_VERSION = 2; // Incremented version number

    // Table and Columns for Teacher's Registration
    private static final String TABLE_TEACHERS_REGISTRATION = "teachers_registration";
    private static final String TEMP_TABLE_TEACHERS_REGISTRATION = "temp_teachers_registration"; // Temporary table name
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_INDEX_NUMBER = "index_number";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_CONTACT_NUMBER = "contact_number";

    // SQL to create the table for Teacher's Registration
    private static final String TABLE_CREATE_TEACHERS_REGISTRATION =
            "CREATE TABLE " + TABLE_TEACHERS_REGISTRATION + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_LAST_NAME + " TEXT, " +
                    COLUMN_INDEX_NUMBER + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_CONTACT_NUMBER + " TEXT);";

    // SQL to create the temporary table for Teacher's Registration (without stream)
    private static final String TEMP_TABLE_CREATE_TEACHERS_REGISTRATION =
            "CREATE TABLE " + TEMP_TABLE_TEACHERS_REGISTRATION + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_LAST_NAME + " TEXT, " +
                    COLUMN_INDEX_NUMBER + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_CONTACT_NUMBER + " TEXT);";

    // Table and Columns for Library Registration
    private static final String TABLE_LIBRARY_REGISTRATION = "teachers_library_registration";
    private static final String COLUMN_FULL_NAME = "full_name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";

    // SQL to create the table for Library Registration
    private static final String TABLE_CREATE_LIBRARY_REGISTRATION =
            "CREATE TABLE " + TABLE_LIBRARY_REGISTRATION + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULL_NAME + " TEXT, " +
                    COLUMN_INDEX_NUMBER + " TEXT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_TIME + " TEXT);";

    public TeachersDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables
        db.execSQL(TABLE_CREATE_TEACHERS_REGISTRATION);
        db.execSQL(TABLE_CREATE_LIBRARY_REGISTRATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If upgrading from version 1 to 2, remove the 'stream' column
        if (oldVersion < 2) {
            // Create the new table without the 'stream' column
            db.execSQL(TEMP_TABLE_CREATE_TEACHERS_REGISTRATION);

            // Copy the data from the old table to the new table
            db.execSQL("INSERT INTO " + TEMP_TABLE_TEACHERS_REGISTRATION + " (" +
                    COLUMN_ID + ", " + COLUMN_FIRST_NAME + ", " + COLUMN_LAST_NAME + ", " +
                    COLUMN_INDEX_NUMBER + ", " + COLUMN_ADDRESS + ", " + COLUMN_EMAIL + ", " +
                    COLUMN_CONTACT_NUMBER + ") SELECT " + COLUMN_ID + ", " + COLUMN_FIRST_NAME + ", " +
                    COLUMN_LAST_NAME + ", " + COLUMN_INDEX_NUMBER + ", " + COLUMN_ADDRESS + ", " +
                    COLUMN_EMAIL + ", " + COLUMN_CONTACT_NUMBER + " FROM " + TABLE_TEACHERS_REGISTRATION + ";");

            // Drop the old table
            db.execSQL("DROP TABLE " + TABLE_TEACHERS_REGISTRATION + ";");

            // Rename the new table to the original table name
            db.execSQL("ALTER TABLE " + TEMP_TABLE_TEACHERS_REGISTRATION + " RENAME TO " + TABLE_TEACHERS_REGISTRATION + ";");
        }
    }

    // Insert Teacher's Registration details
    public boolean insertTeacher(String firstName, String lastName, String indexNumber, String address,
                                 String email, String contactNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, firstName);
        contentValues.put(COLUMN_LAST_NAME, lastName);
        contentValues.put(COLUMN_INDEX_NUMBER, indexNumber);
        contentValues.put(COLUMN_ADDRESS, address);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_CONTACT_NUMBER, contactNumber);
        long result = db.insert(TABLE_TEACHERS_REGISTRATION, null, contentValues);
        return result != -1;
    }

    // Insert Library Registration details
    public boolean insertLibraryRegistration(String fullName, String indexNumber, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FULL_NAME, fullName);
        contentValues.put(COLUMN_INDEX_NUMBER, indexNumber);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_TIME, time);
        long result = db.insert(TABLE_LIBRARY_REGISTRATION, null, contentValues);
        return result != -1;
    }

    // Get all Teacher's Registration details
    public Cursor getAllTeachers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_TEACHERS_REGISTRATION, null);
    }

    // Get all Library Registration details
    public Cursor getAllLibraryRegistrations() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_LIBRARY_REGISTRATION, null);
    }

}

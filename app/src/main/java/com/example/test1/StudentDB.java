package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STUDENTS_REGISTRATION = "students_registration";
    private static final String TABLE_LIBRARY_REGISTRATION = "students_library_registration";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_INDEX_NUMBER = "index_number";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";
    private static final String COLUMN_GRADE = "grade";

    private static final String COLUMN_FULL_NAME = "full_name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";

    private static final String TABLE_CREATE_STUDENTS_REGISTRATION =
            "CREATE TABLE " + TABLE_STUDENTS_REGISTRATION + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_LAST_NAME + " TEXT, " +
                    COLUMN_INDEX_NUMBER + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_PHONE_NUMBER + " TEXT, " +
                    COLUMN_GRADE + " TEXT);";

    private static final String TABLE_CREATE_LIBRARY_REGISTRATION =
            "CREATE TABLE " + TABLE_LIBRARY_REGISTRATION + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULL_NAME + " TEXT, " +
                    COLUMN_INDEX_NUMBER + " TEXT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_TIME + " TEXT);";

    public StudentDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_STUDENTS_REGISTRATION);
        db.execSQL(TABLE_CREATE_LIBRARY_REGISTRATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If you need to update the database schema in the future, add changes here
        // This method is called when the database version changes
        // Drop old tables and recreate them
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS_REGISTRATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIBRARY_REGISTRATION);
        onCreate(db);
    }

    public boolean insertStudentData(String firstName, String lastName, String indexNumber, String address,
                                     String phoneNumber, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, firstName);
        contentValues.put(COLUMN_LAST_NAME, lastName);
        contentValues.put(COLUMN_INDEX_NUMBER, indexNumber);
        contentValues.put(COLUMN_ADDRESS, address);
        contentValues.put(COLUMN_PHONE_NUMBER, phoneNumber);
        contentValues.put(COLUMN_GRADE, grade);
        long result = db.insert(TABLE_STUDENTS_REGISTRATION, null, contentValues);
        return result != -1;
    }

    public boolean insertStudentLibraryRegistration(String fullName, String indexNumber, String date, String time, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FULL_NAME, fullName);
        contentValues.put(COLUMN_INDEX_NUMBER, indexNumber);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_TIME, time);
        long result = db.insert(TABLE_LIBRARY_REGISTRATION, null, contentValues);
        return result != -1;
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_STUDENTS_REGISTRATION, null);
    }

    public Cursor getAllLibraryRegistrations() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_LIBRARY_REGISTRATION, null);
    }
}


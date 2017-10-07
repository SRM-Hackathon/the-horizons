package com.example.nihal.profile_provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper {

    public static final String IMAGE_ID = "id";
    public static final String IMAGE_Col = "image";
    private final Context mContext;

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "TheHorizons.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_Name = "ProviderImageTable";

    private static final String CREATE_IMAGES_TABLE =
            "CREATE TABLE " + TABLE_Name + " (" +
                    IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + IMAGE_Col + " BLOB NOT NULL );";


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_IMAGES_TABLE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_IMAGES_TABLE);
            onCreate(db);
        }
    }

    public void Reset() {
        mDbHelper.onUpgrade(this.mDb, 1, 1);
    }

    public DBHelper(Context ctx) {
        mContext = ctx;
        mDbHelper = new DatabaseHelper(mContext);
    }

    public DBHelper open() throws SQLException {
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    // Insert the image to the Sqlite DB
    public void insertImage(byte[] imageBytes) {
        ContentValues cv = new ContentValues();
        cv.put(IMAGE_Col, imageBytes);
        mDb.insert(TABLE_Name, null, cv);
    }

    // Get the image from SQLite DB
    // We will just get the last image we just saved for convenience...
    public byte[] retreiveImageFromDB() {
        Cursor cur = mDb.query(true, TABLE_Name, new String[]{IMAGE_Col,},
                               null, null, null, null,
                               IMAGE_ID + " DESC", "1");
        if (cur.moveToFirst()) {
            byte[] blob = cur.getBlob(cur.getColumnIndex(IMAGE_Col));
            cur.close();
            return blob;
        }
        cur.close();
        return null;
    }
}
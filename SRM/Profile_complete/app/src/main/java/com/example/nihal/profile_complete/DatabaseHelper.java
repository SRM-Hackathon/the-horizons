package com.example.nihal.profile_complete;

/**
 * Created by USER on 05-10-2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String Database_Name = "TheHorizons.db";
    public static final String Table_Name = "SeekerProfile";
    public static final String SeekerId_Col = "Seeker_Id";
    public static final String Name_Col = "User_Name";
    public static final String Email_Col = "Email_Name";
    public static final String Date_Col = "Date";
    public static final String Month_Col = "Month";
    public static final String Year_Col = "Year";
    public static final String State_Col = "State";
    public static final String City_Col = "City";
    public static final String Pincode_Col = "Pincode";
    public static final String HouseNo_Col = "House_No";




    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL("create table" + Table_Name + "(" +Fruits_Col+  "TEXT);");
        //db.execSQL("create table BS_table3 (Country_Name TEXT);");
        // db.execSQL("create table BS_table2 (Comp_Name TEXT);");

      /* db.execSQL("CREATE TABLE " + Table_Name + " ("
               +SeekerId_Col + " NUMBER AUTOINCREMENT,"
               + Name_Col + " TEXT,"
               + Email_Col + " TEXT PRIMARY KEY NOT NULL,"
               + Date_Col + "TEXT ,"
               + Month_Col + " TEXT,"
               + Year_Col + " TEXT,"
               + State_Col + " TEXT,"
               + City_Col + " TEXT,"
               + Pincode_Col + " TEXT,"
               + HouseNo_Col + " TEXT);");*/
      db.execSQL("create table SeekerProfile (SeekerId_Col NUMBER AUTOINCREMENT,Name_Col TEXT,Email_Col TEXT PRIMARY KEY,Date_Col TEXT,Month_Col TEXT,Year_Col TEXT,State_Col TEXT,City_Col TEXT,Pincode_Col TEXT,HouseNo_Col TEXT);");

        System.out.println("Table Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table IF EXISTS" + Table_Name);
        onCreate(db);
    }


    public boolean insertData(String name, String email, String pincode, String house)
    //public boolean insertData(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name_Col, name);
        contentValues.put(Email_Col,email);
        contentValues.put(Pincode_Col, pincode);
        contentValues.put(HouseNo_Col, house);

        long result = db.insert(Table_Name, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }

    public boolean insertData1(String date, String month,String year, String state,String city)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Date_Col, date);
        contentValues.put(Month_Col,month);
        contentValues.put(Year_Col, year);
        contentValues.put(State_Col, state);
        contentValues.put(City_Col, city);



        long result1 = db.insert(Table_Name, null, contentValues);
        if (result1 == -1)
            return false;
        else
            return true;


    }
    /*
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from BS_table3;",null);
        return res;
    }
    */
}


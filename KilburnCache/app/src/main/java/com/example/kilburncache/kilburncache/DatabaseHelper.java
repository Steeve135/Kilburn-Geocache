package com.example.kilburncache.kilburncache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// The helper class to handle all things for the database
public class DatabaseHelper extends SQLiteOpenHelper {

   // Database name
   public static final String DATABASE_NAME = "MainDB";

   // Database version
   public static final int DATABASE_VERSION = 1;

   // Table name
   public static final String TABLE_NAME = "users";

   // The different columns in the DB
   public static final String COLUMN_USER_NAME = "username";
   public static final String COLUMN_USER_EMAIL = "email";
   public static final String COLUMN_USER_PASSWORD = "password";
   public static final String COLUMN_USER_SCORE = "score";


   // Query for creating the table
   private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME
                                                   + " ("
                                                   + COLUMN_USER_NAME + " TEXT PRIMARY KEY, "
                                                   + COLUMN_USER_EMAIL + " TEXT, "
                                                   + COLUMN_USER_PASSWORD + " TEXT, "
                                                   + COLUMN_USER_SCORE + " INTEGER "
                                                   + ")";


   // Query for dropping the table
   private static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

   // Constructor
   public DatabaseHelper(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   } // DatabaseHelper


   // Override the methods for creating and updating the db
   @Override
   public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_USER_TABLE);
   } // onCreate

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL(DROP_USER_TABLE);
       onCreate(db);
   } // onUpgrade

   // Method to add a new user to the db
   public void addUser(User user) {
       SQLiteDatabase db = this.getWritableDatabase();

       ContentValues values = new ContentValues();
       values.put(COLUMN_USER_NAME, user.userName);
       values.put(COLUMN_USER_EMAIL, user.email);
       values.put(COLUMN_USER_PASSWORD, user.password);
       values.put(COLUMN_USER_SCORE, user.score);

       db.insert(TABLE_NAME, null, values);
   } //addUser

   public User Authenticate(User user) {
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.query(TABLE_NAME,
               new String[]{COLUMN_USER_NAME, COLUMN_USER_EMAIL, COLUMN_USER_PASSWORD, COLUMN_USER_SCORE},
               COLUMN_USER_EMAIL + "=?",
               new String[]{user.email},
               null, null, null);

       // Taken from the internet cos i'm lazy
       if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
           //if cursor has value then in user database there is user associated with this given email
           User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));

           //Match both passwords check they are same or not
           if (user.password.equalsIgnoreCase(user1.password)) {
               return user1;
           }
       }

       //if user password does not matches or there is no record with that email then return @false
       return null;

   } // Authenticate


    // To verify if the email address already exists in the db, also taken from internet cos I'm lazy.
    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,// Selecting Table
                new String[]{COLUMN_USER_NAME, COLUMN_USER_EMAIL, COLUMN_USER_PASSWORD, COLUMN_USER_SCORE},//Selecting columns want to query
                COLUMN_USER_EMAIL + "=?",
                new String[]{email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    } // isEmailExists


} // DatabaseHelper class

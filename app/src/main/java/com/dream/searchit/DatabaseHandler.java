package com.dream.searchit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dream.searchit.models.Contact_info;

import java.util.ArrayList;

import static android.R.attr.version;

/**
 * Created by Dream on 10/24/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "test";
    private static final int DATABASE_VERSION = 7;

    private final String KEY_TABLE = "inquiry";
    private final String KEY_ID = "id";
    private final String KEY_NAME = "name";
    private final String KEY_NUMBER = "number";
    private final String KEY_ADDRESS = "address";
    private final String KEY_LAT = "lat";
    private final String KEY_LNG = "lng";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createstudenttable = "Create table " + KEY_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_NUMBER + " TEXT," + KEY_ADDRESS + " TEXT," +  KEY_LAT + " TEXT," + KEY_LNG + " TEXT" + ")";
        db.execSQL(createstudenttable);
        String row1="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('CIWEC Hospital',061463082,'Lakeside,Pokhara','28.2120','83.9991');";
        db.execSQL(row1);
        String row2="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Metrocity Hospital',061537932,'Srijanachowk,Pokhara','27.7172','85.3240');";
        db.execSQL(row2);
        String row3="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Fewacity Hospital',061532685,'Naagdhunga,Pokhara','28.1000','83.9955');";
        db.execSQL(row3);
      /*  String row4="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Kantipur Dental Hospital',061530725,'Newroad,Pokhara');";
        db.execSQL(row4);
        String row5="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Fishtail Hospital',061528999,'Gairapatan,Pokhara');";
        db.execSQL(row5);
        String row6="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Western regional Hospital (Gandaki)',061520067,'Hospital chowk,Pokhara');";
        db.execSQL(row6);
        String row7="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Manipal Teaching Hospital',061526416,'kaahudada,Pokhara');";
        db.execSQL(row7);
        String row8="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Himalayan Eye Hospital',061461168,'Birauta,Pokhara');";
        db.execSQL(row8);
        String row9="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Gandaki Medical College',061538595,'Nayabazar,Pokhara');";
        db.execSQL(row9);
        String row10="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Paschimanchal Hospital',061538888,'Prithvi Highway,Pokhara');";
        db.execSQL(row10);
        String row11="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('BG Hospital',061538975,'Sitaldevi,Pokhara');";
        db.execSQL(row11);
        String row12="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Sahara Hospital',061539858,'Baglung buspark,Pokhara');";
        db.execSQL(row12);
        String row13="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('OM Hospital',061534577,'Mahendrapool,Pokhara');";
        db.execSQL(row13);
        String row14="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Sewa Hospital',061528161,'Ranipauwa,Pokhara');";
        db.execSQL(row14);
        String row15="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Advance Poly Clinic',061522985/6,'Newroad,Pokhara');";
        db.execSQL(row15);
        String row16="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Lake city Hospital',061533303,'Bagaletole,Pokhara');";
        db.execSQL(row16);
        String row17="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('AB care and rehabilitation Hospital',061521580,'Sarangkot road,Pokhara');";
        db.execSQL(row17);
        String row18="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Sai archana Hospital',061541587,'Ranipauwa,Pokhara');";
        db.execSQL(row18);
        String row19="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ")  Values ('Parkland Hospital',061431380,'Amarsingh chowk ,Pokhara');";
        db.execSQL(row19);*/



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists " + KEY_TABLE);
        onCreate(db);

    }

    public long AddContact(Contact_info contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_NUMBER, contact.getNumber());
        values.put(KEY_ADDRESS, contact.getAddress());


        long r = db.insert(KEY_TABLE, null, values);
        db.close();
        return r;

    }

    public ArrayList<Contact_info> searchInfo(String name) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Contact_info> infolist = new ArrayList<>();
        String query = "SELECT * from " + KEY_TABLE + " WHERE " + KEY_NAME + " LIKE '%" + name + "%'";
        Cursor cursor = db.rawQuery(query, null);


        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Contact_info info3 = new Contact_info();
                    info3.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                    info3.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                    info3.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                    info3.setNumber(cursor.getLong(cursor.getColumnIndex(KEY_NUMBER)));

                    infolist.add(info3);
                }
                while (cursor.moveToNext());

            }
        }
        cursor.close();
        db.close();
        return infolist;
    }

    public ArrayList<String> getContactNames() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT " + KEY_NAME + " from " + KEY_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                    names.add(name);
                }
                while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return names;

    }

    public ArrayList<Contact_info> getContacts() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Contact_info> info = new ArrayList<>();
        String query = "SELECT " + KEY_NAME + " from " + KEY_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        String name = null;

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Contact_info info2 = new Contact_info();
                    info2.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));

                    info.add(info2);
                }
                while (cursor.moveToNext());

            }
        }
        cursor.close();
        db.close();
        return info;

    }

    public  ArrayList<Contact_info> getcontactlist()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Contact_info> info = new ArrayList<>();
        String query = "Select * from "  + KEY_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        String name = null;

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Contact_info info2 = new Contact_info();
                    info2.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                    info2.setNumber(cursor.getLong(cursor.getColumnIndex(KEY_NUMBER)));
                    info2.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                    info2.setLat(cursor.getDouble(cursor.getColumnIndex(KEY_LAT)));
                    info2.setLng(cursor.getDouble(cursor.getColumnIndex(KEY_LNG)));

                    info.add(info2);
                }
                while (cursor.moveToNext());

            }
        }
        cursor.close();
        db.close();
        return info;

    }
}

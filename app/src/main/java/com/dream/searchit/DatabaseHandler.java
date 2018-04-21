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
    private static final int DATABASE_VERSION = 8;

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

        //hospitals

        String createstudenttable = "Create table " + KEY_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_NUMBER + " TEXT," + KEY_ADDRESS + " TEXT," +  KEY_LAT + " TEXT," + KEY_LNG + " TEXT" + ")";
        db.execSQL(createstudenttable);
        String row1="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('CIWEC Hospital',061463082,'Lakeside, Pokhara','28.2095','83.9592');";
        db.execSQL(row1);
        String row2="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Metrocity Hospital',061537932,'Srijanachowk, Pokhara','28.2117','83.9815');";
        db.execSQL(row2);
        String row3="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Fewacity Hospital',061532685,'Naagdhunga, Pokhara','28.2067','83.9816');";
        db.execSQL(row3);
        String row4="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Kantipur Dental Hospital',061530725,'Newroad, Pokhara','28.2150','83.9857');";
        db.execSQL(row4);
        String row5="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Fishtail Hospital',061528999,'Gairapatan, Pokhara','28.2260','83.9904');";
        db.execSQL(row5);
        String row6="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Western regional Hospital (Gandaki)',061520067,'Hospital chowk, Pokhara','28.2120','83.9988');";
        db.execSQL(row6);
        String row7="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Manipal Teaching Hospital',061526416,'kaahudada, Pokhara','28.2510','83.9870');";
        db.execSQL(row7);
        String row8="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Himalayan Eye Hospital',061461168,'Birauta, Pokhara','28.1910','83.9772');";
        db.execSQL(row8);
        String row9="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Gandaki Medical College',061538595,'Nayabazar, Pokhara','28.2112','83.9871');";
        db.execSQL(row9);
        String row10="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Paschimanchal Hospital',061538888,'Prithvi Highway, Pokhara','28.2090','83.9873');";
        db.execSQL(row10);
        String row11="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('BG Hospital',061538975,'Sitaldevi, Pokhara','28.2157','84.0035');";
        db.execSQL(row11);
        String row12="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Sahara Hospital',061539858,'Baglung buspark, Pokhara','28.2313','83.9831');";
        db.execSQL(row12);
        String row13="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('OM Hospital',061534577,'Mahendrapool, Pokhara','28.2231','83.9901');";
        db.execSQL(row13);
        String row14="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Sewa Hospital',061528161,'Ranipauwa, Pokhara','28.2130','83.0008');";
        db.execSQL(row14);
        String row15="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Advance Poly Clinic',061522985,'Newroad, Pokhara','28.2137','83.9854');";
        db.execSQL(row15);
        String row16="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Lake city Hospital',061533303,'Bagaletole, Pokhara','28.2205','83.9837');";
        db.execSQL(row16);
        String row17="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('AB care and rehabilitation Hospital',061521580,'Sarangkot road, Pokhara','28.2385','83.9828');";
        db.execSQL(row17);
        String row18="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Sai archana Hospital',061541587,'Ranipauwa, Pokhara','28.2188','83.9978');";
        db.execSQL(row18);
        String row19="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Parkland Hospital',061431380,'Amarsingh chowk, Pokhara','28.2044','84.0017');";
        db.execSQL(row19);
        String row20="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Padma Nursing Home',061520159,'Newroad, Pokhara','29.2196','83.9866');";
        db.execSQL(row20);

        //hotels

        String row21="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Peace Plaza',061461505,'Lakeside road,Pokhara','28.2053','83.9616');";
        db.execSQL(row21);
        String row22="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Green Tara',9851052519,'Lakeside road,Pokhara','28.2063','83.9600');";
        db.execSQL(row22);
        String row23="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Trekkers Inn',061463244,'Lakeside road,Pokhara','28.2061','83.9617');";
        db.execSQL(row23);
        String row24="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('New United Hotel','','Gaurighat,Pokhara','28.2071','83.9602');"; //N/A
        db.execSQL(row24);
        String row25="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Himalayan Inn',9856027312,'Lakeside road,Pokhara','28.2061','83.9904');"; // N/A
        db.execSQL(row25);
        String row26="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel View Point',061464648,'Gaurighat,Pokhara','29.2064','83.9610');";
        db.execSQL(row26);
        String row27="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Magnolia Pokhara',061464463,'Ambot Street,Pokhara','28.2054','83.9635');";
        db.execSQL(row27);
        String row28="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Grand Holiday Pokhara',061462967,'Peaceful road,Lakeside,Pokhara','28.2053','83.9625');";
        db.execSQL(row28);
        String row29="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Glacier Hotel & Spa Pokhara',061463722,'Gaurighat,Pokhara','28.2059','83.9613');";
        db.execSQL(row29);
        String row30="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Lakeview Resort',061461477,'Lakeside road ,Pokhara','28.2048','83.9625');";
        db.execSQL(row30);
        String row31="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Yeti Pokhara',061462768,'Baidam,Pokhara','28.2051','84.9641');";
        db.execSQL(row31);
        String row32="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Point',9856010303,'Barahi Path,Pokhara','28.2313','83.9831');"; // N/A
        db.execSQL(row32);
        String row33="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Barahi',061460617,'Barahi Path,Pokhara','28.2082','83.9579');";
        db.execSQL(row33);
        String row34="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Lakestar',9851143088,'Lakestar Street,Lakeside,Pokhara','28.2099','83.9607');";
        db.execSQL(row34);
        String row35="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Crystal Palace',061465133,'Lakeside road,Pokhara','28.2137','83.9854');"; //N/A
        db.execSQL(row35);
        String row36="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Tulsi',061460313,'Barahi tole,Pokhara','28.2093','83.9573');";
        db.execSQL(row36);
        String row37="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Snowland',9856099999,'Lakeside road,Pokhara','28.2088','83.9575');";
        db.execSQL(row37);
        String row38="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Pokhara Choice Inn',061467195,'Lakeside road,Pokhara','28.2093','83.9579');";
        db.execSQL(row38);
        String row39="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Atithi Resort',061466760,'Thadopasal(Nearby),Pokhara','28.2068','83.9665');";
        db.execSQL(row39);
        String row40="INSERT INTO " + KEY_TABLE + " ("+ KEY_NAME + ", "+ KEY_NUMBER + ", "+ KEY_ADDRESS + ", "+ KEY_LAT + ", "+ KEY_LNG + ")  Values ('Hotel Travel Inn',061462631,'Pahari Marga ,Pokhara','29.2196','83.9866');"; // N/A
        db.execSQL(row40);






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
                    info3.setLat(cursor.getDouble(cursor.getColumnIndex(KEY_LAT)));
                    info3.setLng(cursor.getDouble(cursor.getColumnIndex(KEY_LNG)));

                    infolist.add(info3);
                }
                while (cursor.moveToNext());

            }
        }
        cursor.close();
        db.close();
        return infolist;
    }

/*    public ArrayList<String> getContactNames() {
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

    }*/

  /*  public ArrayList<Contact_info> getContacts() {
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

    }*/

    public  ArrayList<Contact_info> getcontactlist()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Contact_info> info = new ArrayList<>();
        String query = "Select * from "  + KEY_TABLE+ " order by " +KEY_NAME ;
        Cursor cursor = db.rawQuery(query+ " ASC", null);
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

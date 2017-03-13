package com.example.ahmed.contactsave_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ahmed on 11/03/17.
 */

public class MyDatabase extends SQLiteOpenHelper {

    final static  String database_name = "Contacts";

    final static  String table_name = "data";

    final static  String key_name = "name";
    final static  String key_mobile ="mobile";
    final static  String key_email = "email";


    public MyDatabase(Context context) {

        super(context, database_name, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + table_name + "(" +  key_name + " TEXT," +  key_mobile + " TEXT," +  key_email + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_name);

        onCreate(db);
    }


    public void insert (Contact contact){

        ContentValues contentValues = new ContentValues();

        contentValues.put(key_name , contact.name);
        contentValues.put(key_mobile , contact.mobile);
        contentValues.put(key_email , contact.email);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(table_name,null,contentValues);
    }



    public ArrayList<Contact> getData(){

        ArrayList<Contact> list = new ArrayList<Contact>();

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + table_name;

        Cursor cursor = db.rawQuery(query,null);



        if (cursor.moveToFirst()){


            do {

                String name = cursor.getString(0);
                String mobile = cursor.getString(1);
                String email = cursor.getString(2);

                list.add( new Contact(name,mobile,email));
            }
            while (cursor.moveToNext());
        }


        return list;
    }
}

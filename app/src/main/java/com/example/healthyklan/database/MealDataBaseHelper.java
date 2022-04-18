package com.example.healthyklan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MealDataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "MealDatabaseHelper";

    private static final String TABLE_NAME = "meals_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "NAME";
    private static final String COL3 = "CALORIES";
    private static final String COL4 = "CARBS";
    private static final String COL5 = "FAT";
    private static final String COL6 = "FIBER";
    private static final String COL7 = "PROTEIN";
    private static final String COL8 = "DATE";



    public MealDataBaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTable = "CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+COL2+" TEXT, "+COL3+" TEXT, "+COL4+" TEXT, "+COL5+" TEXT, "+COL6+" TEXT, "+COL7+" TEXT, "+COL8+" TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String name, String calories, String carbs, String fat, String fiber, String protein,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,calories);
        contentValues.put(COL4,carbs);
        contentValues.put(COL5,fat);
        contentValues.put(COL6,fiber);
        contentValues.put(COL7,protein);
        contentValues.put(COL8,date);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }



    }

    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}

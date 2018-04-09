package com.example.mamun.citizenjournalism;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mamun on 03-03-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CitizenJournalism.db";
    public static final String TABLE_NAME = "problem_table";
    public static final String COL_ID = "ID";
    public static final String COL_DATE = "DATE";
    public static final String COL_LOCATION = "LOCATION";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    public static final String COL_TITLE = "TITLE";
    public static final String COL_STATE = "STATE";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,
                1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        String s = "CREATE TABLE "+TABLE_NAME+" ("+COL_ID+" INTEGER PRIMARY KEY, "+COL_DATE+" TEXT, "+COL_LOCATION+" TEXT,"+COL_DESCRIPTION+" TEXT, "+COL_TITLE+" TEXT, "+COL_STATE+" TEXT)";
        db.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addingDataToTable(DataTemp dt){
        SQLiteDatabase sqd=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_DATE,dt.getDate());
        cv.put(COL_LOCATION,dt.getLocation());
        cv.put(COL_DESCRIPTION,dt.getDescription());
        sqd.insert(TABLE_NAME,null,cv);
        sqd.close();
    }

    // --- ---- showing data ------ ----

    String[] my_data() {

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM "+TABLE_NAME;

        Cursor c = sq.rawQuery(q, null);

        String[] recvied_data = new String[c.getCount()];

        c.moveToFirst();

        if(c.moveToFirst()){
            int counter = 0 ;
            do {
                recvied_data[counter] = c.getString(c.getColumnIndex(COL_DESCRIPTION+"")) +"\nBirthday: "+
                        c.getString(c.getColumnIndex(COL_DATE+""));
                counter = counter+1;

            } while(c.moveToNext());

        }

        return recvied_data;
    }


}

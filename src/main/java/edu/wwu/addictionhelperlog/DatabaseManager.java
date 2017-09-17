package edu.wwu.addictionhelperlog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by dell on 9/16/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "logDB";
    private static final int DATABASE_VERSION = 1;
    private static final String LOGS_TABLE = "log";
    private static final String ID = "id";
    private static final String DATE = "date";
    private static final String ADDICTION = "addiction";
    private static final String CAUSE = "cause";
    private static final String AMOUNT = "amount";
    private static final String COST = "cost";
    private static final String WHO = "who";
    private static final String WHERE = "where";

    public DatabaseManager( Context context ){
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    public void onCreate( SQLiteDatabase db ){
        // build sql create statement
        String sqlCreate = "create table " + LOGS_TABLE + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + DATE + " text, " + ADDICTION;
        sqlCreate += " text, " + CAUSE + " text, " + AMOUNT + " text, ";
        sqlCreate += COST + " text )"; // + WHO + " text, " + WHERE + " text )";

        db.execSQL( sqlCreate );
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + LOGS_TABLE);
        // Re-create table
        onCreate(db);
    }

    public void insert( Entry logEntry ){
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + LOGS_TABLE;
        sqlInsert += " values( null, '" + logEntry.getDate();
        sqlInsert += "', '" + logEntry.getAddiction();
        sqlInsert += "', '" + logEntry.getCause();
        sqlInsert += "', '" + logEntry.getAmount();
        sqlInsert += "', '" + logEntry.getCost() + "' )";
        //sqlInsert += "', '" + logEntry.getWho();
        //sqlInsert += "', '" + logEntry.getWhere() + "' )";

        db.execSQL(sqlInsert);
        db.close();
    }

    public ArrayList<Entry> selectAll(){
        String sqlQuery = "select * from " + LOGS_TABLE;

        SQLiteDatabase db = this.getWritableDatabase( );
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<Entry> entries = new ArrayList<>( );
        while(cursor.moveToNext()){
            Entry curr = new Entry( Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5)
                    /*, cursor.getString(6), cursor.getString(7)*/);
            entries.add(curr);
        }

        db.close();
        cursor.close();
        return entries;
    }
}

package com.example.glunote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CarbsPageDb extends SQLiteOpenHelper {
	
	public static final String TABLE_CARBS = "carbstable";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TIME = "entrytime";
	public static final String COLUMN_MEAL = "meal";
	public static final String COLUMN_CARBS = "carbs";
	
	public static final String DATABASE_NAME = "carbstable.db";
	public static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table "
		      + TABLE_CARBS + "(" 
			  + COLUMN_ID + " integer primary key autoincrement, " 
		      + COLUMN_TIME + " Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP, "
		      + COLUMN_MEAL + " text not null, "
		      + COLUMN_CARBS + " real not null);";
	
	public CarbsPageDb(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}
	
	 @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(CarbsPageDb.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARBS);
	    onCreate(db);
	  }

}


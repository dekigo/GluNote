package com.example.glunote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CarbsPageDB extends SQLiteOpenHelper {
	
	public static final String TABLE_CARBS = "carbstable";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TIME = "entrytime";
	public static final String COLUMN_MEAL = "meal";
	public static final String COLUMN_CARBS = "carbs";
	
	public static final String DATABASE_NAME = "carbstable.db";
	public static final int DATABASE_VERSION = 1;
}

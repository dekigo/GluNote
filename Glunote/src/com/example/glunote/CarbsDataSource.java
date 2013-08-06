package com.example.glunote;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CarbsDataSource {

  // Database fields
  private SQLiteDatabase database;
  private CarbsPageDb dbHelper;
  private String[] allColumns = { CarbsPageDb.COLUMN_ID,
      CarbsPageDb.COLUMN_TIME, CarbsPageDb.COLUMN_MEAL, CarbsPageDb.COLUMN_CARBS };

  public CarbsDataSource(Context context) {
    dbHelper = new CarbsPageDb(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public CarbsDBEntry CreateCarbEntry(CarbsDBEntry entry) {
    ContentValues values = new ContentValues();
    values.put(CarbsPageDb.COLUMN_TIME, entry.GetTime());
    values.put(CarbsPageDb.COLUMN_MEAL, entry.GetMeal());
    values.put(CarbsPageDb.COLUMN_CARBS, entry.GetCarbs());
    
    long insertId = database.insert(CarbsPageDb.TABLE_CARBS, null,
        values);
    Cursor cursor = database.query(CarbsPageDb.TABLE_CARBS,
        allColumns, CarbsPageDb.COLUMN_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    CarbsDBEntry newCarbEntry = CursorToCarbEntry(cursor);
    cursor.close();
    return newCarbEntry;
  }

  public void deleteCarbEntry(CarbsDBEntry entry) {
    long id = entry.GetId();
    System.out.println("Comment deleted with id: " + id);
    database.delete(CarbsPageDb.TABLE_CARBS, CarbsPageDb.COLUMN_ID
        + " = " + id, null);
  }

  public List<CarbsDBEntry> getAllCarbEntries() {
    List<CarbsDBEntry> CarbEntries = new ArrayList<CarbsDBEntry>();

    Cursor cursor = database.query(CarbsPageDb.TABLE_CARBS,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      CarbsDBEntry entry = CursorToCarbEntry(cursor);
      CarbEntries.add(entry);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return CarbEntries;
  }

  private CarbsDBEntry CursorToCarbEntry(Cursor cursor) {
    CarbsDBEntry entry = new CarbsDBEntry();
    entry.SetId(cursor.getInt(0));
    entry.SetTime(cursor.getString(1));
    entry.SetMeal(cursor.getString(2));
    entry.setCarbs(cursor.getDouble(3));
    return entry;
  }
} 
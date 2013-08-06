package com.example.glunote;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class CarbsPageActivity extends ListActivity {
	private CarbsDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carbs_page);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Spinner mealspinner = (Spinner) findViewById(R.id.meal_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.meal_array, android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mealspinner.setAdapter(adapter);
		
		int app_Integer=10;
		String app_String = "" +app_Integer;

		TextView tot_carbs = (TextView) findViewById(R.id.Carb_Num);
		tot_carbs.setText(app_String);
		
		datasource = new CarbsDataSource(this);
	    datasource.open();
	    
	    List<CarbsDBEntry> values = datasource.getAllCarbEntries();
	    
	    ArrayAdapter<CarbsDBEntry> adapter2 = new ArrayAdapter<CarbsDBEntry>(this,
	            android.R.layout.simple_list_item_1, values);
	        setListAdapter(adapter2);
	        
	}
	
	 public void Save_Carb_Entry(View view) {
		    @SuppressWarnings("unchecked")
		    ArrayAdapter<CarbsDBEntry> adapter = (ArrayAdapter<CarbsDBEntry>) getListAdapter();
		    CarbsDBEntry entry = null;
		    CarbsDBEntry[] entries = new CarbsDBEntry[] {};
		    int nextInt = new Random().nextInt(3);
		    // Save the new entry to the database
		    entry = datasource.CreateCarbEntry(entries[nextInt]);
		    adapter.add(entry);
		    adapter.notifyDataSetChanged();
	 }

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.carbs_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
	    datasource.open();
	    super.onResume();
	}

	@Override
	protected void onPause() {
	    datasource.close();
	    super.onPause();
	}

}
